package tw.com.bluetechnology.ticket.clinet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import tw.com.bluetechnology.ticket.wsdl.ticketservice.v1_0.TicketPortType;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.ObjectFactory;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResultResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:appContext.xml" })
public class WebServiceClinet {
	@Autowired
	private TicketPortType	service;

	@Test
	public void testTicketSeatInquiry() {
		final TicketSeatInquiryRequest requestObject = ObjectFactory.getInstance().createTicketSeatInquiryRequest();
		requestObject.setAirPlaneClass("FIRST");
		requestObject.setAirPlaneFrom("TPE");
		requestObject.setAirPlaneDestination("HWC");
		requestObject.setAirPlaneInterval("201311041300-201311041800");
		final TicketSeatInquiryResultResponse response = service.ticketSeatInquiry(requestObject);
		for (TicketSeatInquiryResult result : response.getTicketSeatInquiryResult()) {
			System.out.println(result.getAirPlaneNo());
		}
	}
	// public static void main(String[] args) throws MalformedURLException {
	//
	// ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] { "classpath*:appContext.xml" });
	// TicketSeatInquiryPortType instance = (TicketSeatInquiryPortType) context.getBean("webServiceTicketClient");
	// TicketSeatInquiryResultRequest request = new TicketSeatInquiryResultRequest();
	// TicketSeatInquiryResultResponse response = instance.ticketSeatInquiryResult(request);
	// System.out.println(response.getAirPlaneNo());
	// }
}