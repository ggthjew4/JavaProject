package com.bluetechnology.impl;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bluetechnology.dao.TicketSeatInquiryResultDao;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultRequest;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultResponse;
import com.bluetechnology.wsdl.v1_0.TicketSeatInquiryPortType;

@WebService(endpointInterface = "com.bluetechnology.wsdl.v1_0.TicketSeatInquiryPortType",
        serviceName = "TicketSeatInquiryHttpService")
@Service
public class TicketSeatInquiryImpl implements TicketSeatInquiryPortType {
	@Autowired
	TicketSeatInquiryResultDao ticketSeatInquiryResultDao;
	@Override
	public TicketSeatInquiryResultResponse ticketSeatInquiryResult(TicketSeatInquiryResultRequest body) {
		return ticketSeatInquiryResultDao.queryTicketSeatInquiryResult(body);
	}
}
