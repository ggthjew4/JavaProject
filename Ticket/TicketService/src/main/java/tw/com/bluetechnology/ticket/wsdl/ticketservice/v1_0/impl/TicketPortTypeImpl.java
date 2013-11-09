package tw.com.bluetechnology.ticket.wsdl.ticketservice.v1_0.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.com.bluetechnology.ticket.dao.ITicketDao;
import tw.com.bluetechnology.ticket.wsdl.ticketservice.v1_0.TicketPortType;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultResponse;

@Service
public class TicketPortTypeImpl implements TicketPortType {
	@Autowired
	ITicketDao	ticketDao;

	/**
	 * 獲得班機剩餘座位資訊
	 * 
	 * @param 查詢剩餘座位資訊輸入物件 {@link TicketSeatInquiryRequest}
	 * @return 查詢剩餘座位資訊回傳物件 {@link TicketSeatInquiryResultResponse}
	 */
	@Override
	public TicketSeatInquiryResultResponse ticketSeatInquiry(TicketSeatInquiryRequest body) {
		return ticketDao.getTicketSeatInquiryResultResponse(body);
	}

	/**
	 * 獲得班機訂位查詢資訊
	 * 
	 * @param 班機訂位查詢資訊輸入物件 {@link TicketSeatOrderInquiryRequest}
	 * @return 班機訂位查詢資訊回傳物件 {@link TicketSeatOrderInquiryResultResponse}
	 */
	@Override
	public TicketSeatOrderInquiryResultResponse ticketSeatOrderInquiry(TicketSeatOrderInquiryRequest body) {
		return ticketDao.getTicketSeatOrderInquiryResultResponse(body);
	}

	/**
	 * 獲得訂位作業資訊
	 * 
	 * @param 剩餘機位查詢+訂位作業資訊輸入物件 {@link TicketSeatOrderInquiryRequest}
	 * @return 剩餘機位查詢+訂位作業資訊回傳物件 {@link TicketSeatOrderInquiryResultResponse}
	 */
	@Override
	public TicketSeatOrderResultResponse ticketSeatOrder(TicketSeatOrderResultRequest body) {
		return ticketDao.getTicketSeatOrderResultResponse(body);
	}
}
