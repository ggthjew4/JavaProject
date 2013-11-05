package org.webservice.ticket.service;

import org.webservice.generated.cxf.trade.schema.joemo.com.Comment;
import org.webservice.generated.cxf.trade.schema.joemo.com.Status;
import org.webservice.generated.cxf.trade.schema.joemo.com.Trade;
import org.webservice.generated.cxf.tradeservice.schema.joemo.com.TradeService;

public class TradeServiceImpl implements TradeService {
	@Override
	public Status book(Trade trade) {
		System.out.print ("Booking security ");
		System.out.print (trade.getSecurity());
		System.out.print (", quantity ");
		System.out.print (trade.getQuantity());
		System.out.println();
		if (trade.getComments() != null) {
			System.out.println ("Comments:");
			for (Comment c : trade.getComments()) {
				System.out.print (c.getAuthor());
				System.out.print (": ");
				System.out.print (c.getMessage());
				System.out.println();
			}
		}
		Status s = new Status();
		s.setId("1234577777777777777777");
		s.setMessage("ok");
		return s;
	}
}
