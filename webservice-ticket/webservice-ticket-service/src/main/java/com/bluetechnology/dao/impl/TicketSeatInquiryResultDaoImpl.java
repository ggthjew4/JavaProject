package com.bluetechnology.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bluetechnology.dao.AbstractCommonDao;
import com.bluetechnology.dao.TicketSeatInquiryResultDao;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResult;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultRequest;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultResponse;

@Repository
public class TicketSeatInquiryResultDaoImpl extends AbstractCommonDao implements TicketSeatInquiryResultDao {
	
	private final static SimpleDateFormat	DATE_FORMATTER_PATTERN	= new SimpleDateFormat("yyyyMMddHHmm");

	public TicketSeatInquiryResultResponse queryTicketSeatInquiryResult(final TicketSeatInquiryResultRequest request) {
		List<TicketSeatInquiryResult> response = null;
		TicketSeatInquiryResultResponse ticketSeatInquiryResultResponse = null;
		try {
			final String airPlaneInterval = request.getAirPlaneInterval();
			final String[] airPlaneIntervalArray = airPlaneInterval.split("-");
			final Date startTime = DATE_FORMATTER_PATTERN.parse(airPlaneIntervalArray[0]);
			final Date endTime = DATE_FORMATTER_PATTERN.parse(airPlaneIntervalArray[1]);
			final String sql = "SELECT airplane.AIR_NUMBER,seats.SEA_CODE,seats.SEA_NO" + " FROM airplane" + " INNER JOIN class_cabin ON airplane.AIR_SN = class_cabin.CAB_AIR_SN" + " INNER JOIN seats ON seats.SEA_CAB_SN = class_cabin.CAB_SN RIGHT JOIN customer on customer.USER_SEA_SN = seats.SEA_SN" + " WHERE airplane.AIR_FROM = ?" + " AND airplane.AIR_DESTINATION = ?" + " AND airplane.AIR_DEPARTURE_TIME BETWEEN ? AND ?" + " AND class_cabin.CAB_CLASS = ?";
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
}
