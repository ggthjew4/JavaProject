package tw.com.bluetechnology.ticket.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import tw.com.bluetechnology.ticket.dao.CommonTicketDao;
import tw.com.bluetechnology.ticket.dao.ITicketDao;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultResponse;

@Repository
public class TicketDaoImpl extends CommonTicketDao implements ITicketDao {
	
	private final static SimpleDateFormat	DATE_FORMATTER_PATTERN	= new SimpleDateFormat("yyyyMMddHHmm");

	@Override
	public TicketSeatInquiryResultResponse getTicketSeatInquiryResultResponse(TicketSeatInquiryRequest request) {
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

	@Override
	public TicketSeatOrderInquiryResultResponse getTicketSeatOrderInquiryResultResponse(TicketSeatOrderInquiryRequest request) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketSeatOrderResultResponse getTicketSeatOrderResultResponse(TicketSeatOrderResultRequest request) {
		// TODO Auto-generated method stub
		return null;
	}
}
