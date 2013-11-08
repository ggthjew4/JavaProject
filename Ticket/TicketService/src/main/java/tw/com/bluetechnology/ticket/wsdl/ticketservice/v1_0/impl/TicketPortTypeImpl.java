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

	@Override
	public TicketSeatInquiryResultResponse ticketSeatInquiry(TicketSeatInquiryRequest body) {
		return ticketDao.getTicketSeatInquiryResultResponse(body);
	}

	@Override
	public TicketSeatOrderInquiryResultResponse ticketSeatOrderInquiry(TicketSeatOrderInquiryRequest body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TicketSeatOrderResultResponse ticketSeatOrder(TicketSeatOrderResultRequest body) {
		// TODO Auto-generated method stub
		return null;
	}
}
