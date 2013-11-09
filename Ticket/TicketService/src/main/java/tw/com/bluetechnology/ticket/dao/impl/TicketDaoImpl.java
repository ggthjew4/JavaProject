package tw.com.bluetechnology.ticket.dao.impl;

import java.math.BigInteger;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tw.com.bluetechnology.ticket.dao.CommonTicketDao;
import tw.com.bluetechnology.ticket.dao.ITicketDao;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.ObjectFactory;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResponseResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderRequestResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResponseResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultResponse;
/**
 * @author kerrigan
 * Ticket WebService Dao 實作類別
 */
@Repository
public class TicketDaoImpl extends CommonTicketDao implements ITicketDao {
	
	private final static SimpleDateFormat	DATE_FORMATTER_PATTERN	= new SimpleDateFormat("yyyyMMddHHmm");

	/**
	 * 獲得班機剩餘座位資訊
	 * @param 查詢剩餘座位資訊輸入物件 {@link TicketSeatInquiryRequest}
	 * @return 查詢剩餘座位資訊回傳物件 {@link TicketSeatInquiryResultResponse}
	 */
	@Override
	public TicketSeatInquiryResultResponse getTicketSeatInquiryResultResponse(final TicketSeatInquiryRequest request) {
		List<TicketSeatInquiryResult> response = null;
		TicketSeatInquiryResultResponse ticketSeatInquiryResultResponse = null;
		try {
			final String airPlaneInterval = request.getAirPlaneInterval();
			final String[] airPlaneIntervalArray = airPlaneInterval.split("-");
			final Date startTime = DATE_FORMATTER_PATTERN.parse(airPlaneIntervalArray[0]);
			final Date endTime = DATE_FORMATTER_PATTERN.parse(airPlaneIntervalArray[1]);
			final String sql = "SELECT airplane.AIR_NUMBER,seats.SEA_CODE,seats.SEA_NO" 
				               + " FROM airplane" 
				               + " INNER JOIN class_cabin ON airplane.AIR_SN = class_cabin.CAB_AIR_SN" 
				               + " INNER JOIN seats ON seats.SEA_CAB_SN = class_cabin.CAB_SN LEFT JOIN customer on customer.USER_SEA_SN = seats.SEA_SN" 
				               + " WHERE airplane.AIR_FROM = ?" 
				               + " AND airplane.AIR_DESTINATION = ?" 
				               + " AND airplane.AIR_DEPARTURE_TIME BETWEEN ? AND ?" + " AND class_cabin.CAB_CLASS = ?"
				               + " AND seats.SEA_SN not in (select customer.USER_SEA_SN from customer)";
			response = getJdbcTemplate().query(sql, new Object[] { request.getAirPlaneFrom(), request.getAirPlaneDestination(), startTime, endTime, request.getAirPlaneClass() }, new RowMapper<TicketSeatInquiryResult>() {
				@Override
				public TicketSeatInquiryResult mapRow(final ResultSet rs, final int rowNum) throws SQLException {
					TicketSeatInquiryResult response = new TicketSeatInquiryResult();
					response.setAirPlaneNo(rs.getString("AIR_NUMBER"));
					response.setSeatCode(rs.getString("SEA_CODE"));
					response.setSeatNo(rs.getString("SEA_NO"));
					return response;
				}
			});
			ticketSeatInquiryResultResponse = new TicketSeatInquiryResultResponse();
			ticketSeatInquiryResultResponse.getTicketSeatInquiryResult().addAll(response);
		}
		catch (ParseException e) {
			e.printStackTrace();
		}
		return ticketSeatInquiryResultResponse;
	}

	/**
	 * 獲得班機訂位查詢資訊
	 * @param 班機訂位查詢資訊輸入物件 {@link TicketSeatOrderInquiryRequest}
	 * @return 班機訂位查詢資訊回傳物件 {@link TicketSeatOrderInquiryResultResponse}
	 */
	@Override
	public TicketSeatOrderInquiryResultResponse getTicketSeatOrderInquiryResultResponse(final TicketSeatOrderInquiryRequest request) {
		final String sql = "SELECT airplane.AIR_DEPARTURE_TIME,airplane.AIR_ARRIVAL_TIME,airplane.AIR_NUMBER,class_cabin.CAB_CLASS,seats.SEA_NO"
			             + " FROM airplane"
			             + " INNER JOIN class_cabin ON airplane.AIR_SN = class_cabin.CAB_AIR_SN INNER JOIN seats ON seats.SEA_CAB_SN = class_cabin.CAB_SN INNER JOIN customer on customer.USER_SEA_SN = seats.SEA_SN"
			             + " WHERE customer.USER_ID = ? and customer.USER_SN = ?";
		final TicketSeatOrderInquiryResultResponse returnResponse = ObjectFactory.getInstance().createTicketSeatOrderInquiryResultResponse();
		returnResponse.getTicketSeatOrderInquiryResponseResult().addAll(getJdbcTemplate().query(sql, new Object[] { request.getCustomerId(), request.getCustomerSn() }, new RowMapper<TicketSeatOrderInquiryResponseResult>() {
			@Override
			public TicketSeatOrderInquiryResponseResult mapRow(ResultSet rs, int rowNum) throws SQLException {
				TicketSeatOrderInquiryResponseResult result = ObjectFactory.getInstance().createTicketSeatOrderInquiryResponseResult();
				result.setAirPlaneArrivalTime(dateCovertToXMLGregorianCalendar(rs.getTimestamp("AIR_ARRIVAL_TIME")));
				result.setAirPlaneDepartureTime(dateCovertToXMLGregorianCalendar(rs.getTimestamp("AIR_DEPARTURE_TIME")));
				result.setAirPlaneNo(rs.getString("AIR_NUMBER"));
				result.setCabinClass(rs.getString("CAB_CLASS"));
				result.setSeatNo(rs.getString("SEA_NO"));
				return result;
			}
		}));
		return returnResponse;
	}

	/**
	 * 獲得訂位作業資訊
	 * @param 訂位作業資訊輸入物件 {@link TicketSeatOrderInquiryRequest}
	 * @return 訂位作業資訊回傳物件 {@link TicketSeatOrderInquiryResultResponse}
	 */
	@Override
	public TicketSeatOrderResultResponse getTicketSeatOrderResultResponse(final TicketSeatOrderResultRequest request) {
		final String insertSql = "INSERT INTO customer (USER_NAME,USER_SEA_SN,USER_ID,USER_STATUS)"
        	                    +" VALUES (?,(select seats.SEA_SN from seats where seats.SEA_CODE = ?),?,?)";
		final String querySql = "SELECT customer.USER_SN,customer.USER_NAME,customer.USER_ID,customer.USER_STATUS"
			   +" FROM airplane"
			   +" INNER JOIN class_cabin ON airplane.AIR_SN = class_cabin.CAB_AIR_SN INNER JOIN seats ON seats.SEA_CAB_SN = class_cabin.CAB_SN INNER JOIN customer on customer.USER_SEA_SN = seats.SEA_SN"
			   +" WHERE customer.USER_NAME = ? AND customer.USER_ID = ? and SEA_CODE = ?";
		final TicketSeatOrderResultResponse returnResponse = ObjectFactory.getInstance().createTicketSeatOrderResultResponse();
		for(final TicketSeatOrderRequestResult r : request.getTicketSeatOrderRequestResult()){
			getJdbcTemplate().update(insertSql, new Object[]{r.getCustomerUsername(),r.getSeatCode(),r.getCustomerId(),"Y"});
			final TicketSeatOrderResponseResult result = getJdbcTemplate().query(querySql, new Object[]{r.getCustomerUsername(),r.getCustomerId(),r.getSeatCode()},new ResultSetExtractor<TicketSeatOrderResponseResult>(){
				@Override
				public TicketSeatOrderResponseResult extractData(ResultSet rs) throws SQLException {
					TicketSeatOrderResponseResult result = ObjectFactory.getInstance().createTicketSeatOrderResponseResult();
					while(rs.next()){
						result.setCustomerId(rs.getString("USER_ID"));
						result.setCustomerSn(new BigInteger(String.valueOf(rs.getInt("USER_SN"))));
						result.setCustomerStatus(rs.getString("USER_STATUS"));
						result.setCustomerUsername(rs.getString("USER_NAME"));
					}
					return result;
				}});
			returnResponse.getTicketSeatOrderResponseResult().add(result);
		}
		return returnResponse;
	}
}
