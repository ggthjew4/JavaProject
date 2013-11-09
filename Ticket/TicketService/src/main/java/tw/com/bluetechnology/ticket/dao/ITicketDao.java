package tw.com.bluetechnology.ticket.dao;

import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultResponse;
/**
 * @author kerrigan
 * Ticket WebService Dao 介面
 */
public interface ITicketDao {
	
	/**
	 * 獲得班機剩餘座位資訊
	 * @param 查詢剩餘座位資訊輸入物件 {@link TicketSeatInquiryRequest}
	 * @return 查詢剩餘座位資訊回傳物件 {@link TicketSeatInquiryResultResponse}
	 */
	public TicketSeatInquiryResultResponse getTicketSeatInquiryResultResponse(final TicketSeatInquiryRequest request);
	/**
	 * 獲得班機訂位查詢資訊
	 * @param 班機訂位查詢資訊輸入物件 {@link TicketSeatOrderInquiryRequest}
	 * @return 班機訂位查詢資訊回傳物件 {@link TicketSeatOrderInquiryResultResponse}
	 */
	public TicketSeatOrderInquiryResultResponse getTicketSeatOrderInquiryResultResponse(final TicketSeatOrderInquiryRequest request);
	/**
	 * 獲得訂位作業資訊
	 * @param 訂位作業資訊輸入物件 {@link TicketSeatOrderInquiryRequest}
	 * @return 訂位作業資訊回傳物件 {@link TicketSeatOrderInquiryResultResponse}
	 */
	public TicketSeatOrderResultResponse getTicketSeatOrderResultResponse(final TicketSeatOrderResultRequest request);
}
