package com.bluetechnology.service.impl;

import org.springframework.stereotype.Service;

import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultRequest;
import com.bluetechnology.service.ITicketSeatInquiryRequestService;
import com.bluetechnology.wsdl.RequestXmlRequestObjectFactory;

/**
 * @author kerrigan
 * 飛機座位查詢WebSerivce service layer
 */
@Service
public class TicketSeatInquiryImplRequestService implements ITicketSeatInquiryRequestService {
	
	@Override
	public TicketSeatInquiryResultRequest getSeatInquiryRequest() {
		return RequestXmlRequestObjectFactory.createTicketSeatInquiryXmlObject();
	}
}
