package tw.com.bluetechnology.ticket.clinet;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.datatype.XMLGregorianCalendar;

import org.apache.log4j.Logger;
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
 * @see TicketSeatInquiryResultResponse
 * @see TicketSeatInquiryResult
 * @see TicketSeatOrderResultRequest
 * @see TicketSeatOrderRequestResult
 * @see TicketSeatOrderResultResponse
 * @author kerrigan
 */
public class WebServiceClinet {
	@Autowired
	private TicketPortType					service;
	private final static SimpleDateFormat	DATE_FORMATTER_PATTERN	= new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private final static Logger				logger					= Logger.getLogger(WebServiceClinet.class);

	/**
	 * 剩餘機位查詢測試
	 */
	@Test
	public void testTicketSeatInquiry() {
		final TicketSeatInquiryResultResponse response = service.ticketSeatInquiry(createTicketSeatInquiryRequestforTest());
		logTestDescription("剩餘機位查詢測試開始");
		logTestDescription("輸入參數:\r" + "時間區間:2013-11-04 13:00 ~ 2013-11-04 18:00\r起點:TPE\r終點:HWC\r艙等:First");
		for (TicketSeatInquiryResult result : response.getTicketSeatInquiryResult()) {
			logTestDescription("回傳資料:\r" + "飛機代號:" + result.getAirPlaneNo() + "\r機位代碼:" + result.getSeatCode() + "\r座位號:" + result.getSeatNo());
		}
		logTestDescription("剩餘機位查詢測試結束");
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
		logTestDescription("剩餘訂位作業測試開始");
		logTestDescription("輸入參數:\r" + "旅客身份證字號:A123456789\r旅客姓名:kerrigan\r座位代號:PNR100000001");
		final TicketSeatOrderResultResponse response = service.ticketSeatOrder(body);
		for (TicketSeatOrderResponseResult r : response.getTicketSeatOrderResponseResult()) {
			logTestDescription("回傳資料:\r" + "訂位代碼:" + r.getCustomerSn() + "\r旅客姓名:" + r.getCustomerUsername() + "\r旅客身份證字號:" + r.getCustomerId() + "\r訂位狀態:" + r.getCustomerStatus());
		}
		logTestDescription("剩餘機位查詢測試結束");
	}

	/**
	 * 訂位查詢測試
	 */
	// @Test
	public void testTicketSeatOrderInquiry() {
		TicketSeatOrderInquiryRequest request = ObjectFactory.getInstance().createTicketSeatOrderInquiryRequest();
		request.setCustomerId("A123456789");
		// Note:此數字要看[剩餘訂位作業測試]所回傳的訂位代碼
		request.setCustomerSn(new BigInteger("2"));
		logTestDescription("訂位查詢測試開始");
		logTestDescription("輸入參數:\r" + "旅客身份證字號:A123456789\r訂位序號:2");
		for (TicketSeatOrderInquiryResponseResult response : service.ticketSeatOrderInquiry(request).getTicketSeatOrderInquiryResponseResult()) {
			logTestDescription("回傳資料:\r" + "起飛時間:" + DATE_FORMATTER_PATTERN.format(xmlGregorianCalendarToDate(response.getAirPlaneDepartureTime())) + "\r到達時間:" + DATE_FORMATTER_PATTERN.format(xmlGregorianCalendarToDate(response.getAirPlaneArrivalTime())) + "\r班機編號:" + response.getAirPlaneNo() + "\r班機艙等:" + response.getCabinClass() + "\r座位號:" + response.getSeatNo());
		}
		logTestDescription("訂位查詢測試結束");
	}

	/**
	 * 剩餘機位查詢+訂位作業測試
	 */
	// @Test
	public void finalTest() {
		final TicketSeatInquiryResultResponse response = service.ticketSeatInquiry(createTicketSeatInquiryRequestforTest());
		final TicketSeatOrderResultRequest body = ObjectFactory.getInstance().createTicketSeatOrderResultRequest();
		logTestDescription("剩餘機位查詢+訂位作業測試開始");
		for (final TicketSeatInquiryResult result : response.getTicketSeatInquiryResult()) {
			final TicketSeatOrderRequestResult request = ObjectFactory.getInstance().createTicketSeatOrderRequestResult();
			request.setCustomerId("A123456789");
			request.setCustomerUsername("kerrigan");
			request.setSeatCode(result.getSeatCode());
			body.getTicketSeatOrderRequestResult().add(request);
		}
		for (final TicketSeatOrderResponseResult result : service.ticketSeatOrder(body).getTicketSeatOrderResponseResult()) {
			logTestDescription("回傳資料:\r" + "訂位代碼:" + result.getCustomerSn() + "\r旅客姓名:" + result.getCustomerUsername() + "\r旅客身份證字號:" + result.getCustomerId() + "\r訂位狀態:" + result.getCustomerStatus());
		}
		logTestDescription("剩餘機位查詢+訂位作業測試結束");
	}

	/**
	 * 建立測試用{@link TicketSeatInquiryRequest}(班機查詢作業測試)資料
	 * 
	 * @return {@link TicketSeatInquiryRequest}
	 */
	private TicketSeatInquiryRequest createTicketSeatInquiryRequestforTest() {
		final TicketSeatInquiryRequest requestObject = ObjectFactory.getInstance().createTicketSeatInquiryRequest();
		requestObject.setAirPlaneClass("FIRST");
		requestObject.setAirPlaneFrom("TPE");
		requestObject.setAirPlaneDestination("HWC");
		requestObject.setAirPlaneInterval("201311041300-201311041800");
		return requestObject;
	}

	/**
	 * 轉換{@link XMLGregorianCalendar} to ${@link Date}物件
	 * 
	 * @param 需解析的{@link XMLGregorianCalendar}物件
	 * @return {@link TicketSeatInquiryRequest}
	 */
	private Date xmlGregorianCalendarToDate(final XMLGregorianCalendar cal) {
		return cal.toGregorianCalendar().getTime();
	}

	/**
	 * 紀錄測試過程紀錄
	 * 
	 * @param log 紀錄內容{@link String}
	 */
	public void logTestDescription(final String log) {
		logger.info(log);
	}
}