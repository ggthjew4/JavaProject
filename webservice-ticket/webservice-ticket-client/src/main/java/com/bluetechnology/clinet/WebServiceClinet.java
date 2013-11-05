package com.bluetechnology.clinet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResult;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultRequest;
import com.bluetechnology.jaxb.TicketSeatInquiry.TicketSeatInquiryResultResponse;
import com.bluetechnology.service.ITicketSeatInquiryRequestService;
import com.bluetechnology.wsdl.v1_0.TicketSeatInquiryPortType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:appContext.xml" })
public class WebServiceClinet {
	
	@Autowired
	private ITicketSeatInquiryRequestService ticketSeatInquiryRequestService;
	
	@Autowired
	private TicketSeatInquiryPortType service;
	
	@Test
	public void testTicketSeatInquiry(){
		final TicketSeatInquiryResultRequest requestObject = ticketSeatInquiryRequestService.getSeatInquiryRequest();
		requestObject.setAirPlaneClass("FIRST");
		requestObject.setAirPlaneFrom("TPE");
		requestObject.setAirPlaneDestination("HWC");
		requestObject.setAirPlaneInterval("201311041300-201311041800");
		final TicketSeatInquiryResultResponse response = service.ticketSeatInquiryResult(requestObject);
		for(TicketSeatInquiryResult result:response.getTicketSeatInquiryResult()){
			System.out.println(result.getAirPlaneNo());
		}
	}
//	public static void main(String[] args) throws MalformedURLException {
//		
//		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath*:appContext.xml" });
//		TicketSeatInquiryPortType instance = (TicketSeatInquiryPortType) context.getBean("webServiceTicketClient");
//		TicketSeatInquiryResultRequest request = new TicketSeatInquiryResultRequest();
//		TicketSeatInquiryResultResponse response = instance.ticketSeatInquiryResult(request);
//		System.out.println(response.getAirPlaneNo());
//	}
}
