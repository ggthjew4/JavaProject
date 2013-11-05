package com.bluetechnology.wsdl;

import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultRequest;

public class RequestXmlRequestObjectFactory {
	
	public static TicketSeatInquiryResultRequest createTicketSeatInquiryXmlObject(){
		return new TicketSeatInquiryResultRequest();
	}
}
