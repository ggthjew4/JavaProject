package tw.com.bluetechnology.ticket.dao;

import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderInquiryResultResponse;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultRequest;
import tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0.TicketSeatOrderResultResponse;

public interface ITicketDao {
	
	public TicketSeatInquiryResultResponse getTicketSeatInquiryResultResponse(final TicketSeatInquiryRequest request);
	
	public TicketSeatOrderInquiryResultResponse getTicketSeatOrderInquiryResultResponse(final TicketSeatOrderInquiryRequest request);
	
	public TicketSeatOrderResultResponse getTicketSeatOrderResultResponse(final TicketSeatOrderResultRequest request);
}
