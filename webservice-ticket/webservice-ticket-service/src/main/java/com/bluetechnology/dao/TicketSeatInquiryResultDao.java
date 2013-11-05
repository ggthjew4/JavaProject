package com.bluetechnology.dao;

import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultRequest;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultResponse;

public interface TicketSeatInquiryResultDao {
	
	public TicketSeatInquiryResultResponse queryTicketSeatInquiryResult(TicketSeatInquiryResultRequest request);
}
