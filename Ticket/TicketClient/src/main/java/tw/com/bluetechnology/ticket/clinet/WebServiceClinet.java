package tw.com.bluetechnology.ticket.clinet;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

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
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResponseResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderRequestResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResponseResult;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultResponse;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:appContext.xml" })
/**
 * WebService Spring Class 測試主程式
 * @author kerrigan
 */
public class WebServiceClinet {
	@Autowired
	private TicketPortType					service;
	private final static SimpleDateFormat	DATE_FORMATTER_PATTERN	= new SimpleDateFormat("yyyy-MM-dd HH:mm");

	/**
	 * 剩餘機位查詢測試
	 */
	// @Test
	public void testTicketSeatInquiry() {
		final TicketSeatInquiryResultResponse response = service.ticketSeatInquiry(createTicketSeatInquiryRequestforTest());
		for (TicketSeatInquiryResult result : response.getTicketSeatInquiryResult()) {
			System.out.println(result.getAirPlaneNo());
		}
	}

	/**
	 * 剩餘訂位作業測試
	 */
	// @Test
	public void testTicketSeatOrder() {
		final TicketSeatOrderResultRequest body = ObjectFactory.getInstance().createTicketSeatOrderResultRequest();
		final TicketSeatOrderRequestResult request = ObjectFactory.getInstance().createTicketSeatOrderRequestResult();
		request.setCustomerId("A123456789");
		request.setCustomerUsername("kerrigan");
		request.setSeatCode("PNR100000001");
		body.getTicketSeatOrderRequestResult().add(request);
		final TicketSeatOrderResultResponse response = service.ticketSeatOrder(body);
		for (TicketSeatOrderResponseResult r : response.getTicketSeatOrderResponseResult()) {
			System.out.println(r.getCustomerSn());
			System.out.println(r.getCustomerUsername());
			System.out.println(r.getCustomerId());
			System.out.println(r.getCustomerStatus());
		}
	}

	/**
	 * 訂位查詢測試
	 */
	// @Test
	public void testTicketSeatOrderInquiry() {
		TicketSeatOrderInquiryRequest request = ObjectFactory.getInstance().createTicketSeatOrderInquiryRequest();
		request.setCustomerId("A123456789");
		request.setCustomerSn(new BigInteger("2"));
		for (TicketSeatOrderInquiryResponseResult response : service.ticketSeatOrderInquiry(request).getTicketSeatOrderInquiryResponseResult()) {
			System.out.println(DATE_FORMATTER_PATTERN.format(xmlGregorianCalendarToDate(response.getAirPlaneDepartureTime())));
			System.out.println(DATE_FORMATTER_PATTERN.format(xmlGregorianCalendarToDate(response.getAirPlaneArrivalTime())));
			System.out.println(response.getAirPlaneNo());
			System.out.println(response.getCabinClass());
			System.out.println(response.getSeatNo());
		}
	}

	/**
	 * 剩餘機位查詢+訂位作業測試
	 */
	@Test
	public void finalTest() {
		final TicketSeatInquiryResultResponse response = service.ticketSeatInquiry(createTicketSeatInquiryRequestforTest());
		final TicketSeatOrderResultRequest body = ObjectFactory.getInstance().createTicketSeatOrderResultRequest();
		for (TicketSeatInquiryResult result : response.getTicketSeatInquiryResult()) {
			final TicketSeatOrderRequestResult request = ObjectFactory.getInstance().createTicketSeatOrderRequestResult();
			request.setCustomerId("A123456789");
			request.setCustomerUsername("kerrigan");
			request.setSeatCode(result.getSeatCode());
			body.getTicketSeatOrderRequestResult().add(request);
		}
		for (TicketSeatOrderResponseResult result : service.ticketSeatOrder(body).getTicketSeatOrderResponseResult()) {
			System.out.println(result.getCustomerSn());
			System.out.println(result.getCustomerUsername());
			System.out.println(result.getCustomerId());
			System.out.println(result.getCustomerStatus());
		}
		;
	}

	private TicketSeatInquiryRequest createTicketSeatInquiryRequestforTest() {
		final TicketSeatInquiryRequest requestObject = ObjectFactory.getInstance().createTicketSeatInquiryRequest();
		requestObject.setAirPlaneClass("FIRST");
		requestObject.setAirPlaneFrom("TPE");
		requestObject.setAirPlaneDestination("HWC");
		requestObject.setAirPlaneInterval("201311041300-201311041800");
		return requestObject;
	}

	private Date xmlGregorianCalendarToDate(final XMLGregorianCalendar cal) {
		return cal.toGregorianCalendar().getTime();
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