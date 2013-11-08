package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import java.math.BigInteger;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0 package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content. The Java representation of XML content can consist of schema derived interfaces
 * and classes representing the binding of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {
	private final static QName	_CustomerId_QNAME							= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "customerId");
	private final static QName	_CustomerSn_QNAME							= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "customerSn");
	private final static QName	_TicketSeatInquiryResultResponse_QNAME		= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "ticketSeatInquiryResultResponse");
	private final static QName	_TicketSeatOrderResultResponse_QNAME		= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "ticketSeatOrderResultResponse");
	private final static QName	_CustomerUsername_QNAME						= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "customerUsername");
	private final static QName	_TicketSeatOrderResultRequest_QNAME			= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "ticketSeatOrderResultRequest");
	private final static QName	_TicketSeatOrderInquiryResultResponse_QNAME	= new QName("http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", "ticketSeatOrderInquiryResultResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0
	 * 
	 */
	private ObjectFactory() {
	}

	public static ObjectFactory getInstance() {
		return new ObjectFactory();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderInquiryResultResponse }
	 * 
	 */
	public TicketSeatOrderInquiryResultResponse createTicketSeatOrderInquiryResultResponse() {
		return new TicketSeatOrderInquiryResultResponse();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderResultResponse }
	 * 
	 */
	public TicketSeatOrderResultResponse createTicketSeatOrderResultResponse() {
		return new TicketSeatOrderResultResponse();
	}

	/**
	 * Create an instance of {@link TicketSeatInquiryResultResponse }
	 * 
	 */
	public TicketSeatInquiryResultResponse createTicketSeatInquiryResultResponse() {
		return new TicketSeatInquiryResultResponse();
	}

	/**
	 * Create an instance of {@link TicketSeatInquiryRequest }
	 * 
	 */
	public TicketSeatInquiryRequest createTicketSeatInquiryRequest() {
		return new TicketSeatInquiryRequest();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderResultRequest }
	 * 
	 */
	public TicketSeatOrderResultRequest createTicketSeatOrderResultRequest() {
		return new TicketSeatOrderResultRequest();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderInquiryResponseResult }
	 * 
	 */
	public TicketSeatOrderInquiryResponseResult createTicketSeatOrderInquiryResponseResult() {
		return new TicketSeatOrderInquiryResponseResult();
	}

	/**
	 * Create an instance of {@link TicketSeatInquiryResult }
	 * 
	 */
	public TicketSeatInquiryResult createTicketSeatInquiryResult() {
		return new TicketSeatInquiryResult();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderResponseResult }
	 * 
	 */
	public TicketSeatOrderResponseResult createTicketSeatOrderResponseResult() {
		return new TicketSeatOrderResponseResult();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderInquiryRequest }
	 * 
	 */
	public TicketSeatOrderInquiryRequest createTicketSeatOrderInquiryRequest() {
		return new TicketSeatOrderInquiryRequest();
	}

	/**
	 * Create an instance of {@link TicketSeatOrderRequestResult }
	 * 
	 */
	public TicketSeatOrderRequestResult createTicketSeatOrderRequestResult() {
		return new TicketSeatOrderRequestResult();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "customerId")
	public JAXBElement<String> createCustomerId(String value) {
		return new JAXBElement<String>(_CustomerId_QNAME, String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "customerSn")
	public JAXBElement<BigInteger> createCustomerSn(BigInteger value) {
		return new JAXBElement<BigInteger>(_CustomerSn_QNAME, BigInteger.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TicketSeatInquiryResultResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "ticketSeatInquiryResultResponse")
	public JAXBElement<TicketSeatInquiryResultResponse> createTicketSeatInquiryResultResponse(TicketSeatInquiryResultResponse value) {
		return new JAXBElement<TicketSeatInquiryResultResponse>(_TicketSeatInquiryResultResponse_QNAME, TicketSeatInquiryResultResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TicketSeatOrderResultResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "ticketSeatOrderResultResponse")
	public JAXBElement<TicketSeatOrderResultResponse> createTicketSeatOrderResultResponse(TicketSeatOrderResultResponse value) {
		return new JAXBElement<TicketSeatOrderResultResponse>(_TicketSeatOrderResultResponse_QNAME, TicketSeatOrderResultResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "customerUsername")
	public JAXBElement<String> createCustomerUsername(String value) {
		return new JAXBElement<String>(_CustomerUsername_QNAME, String.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TicketSeatOrderResultRequest }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "ticketSeatOrderResultRequest")
	public JAXBElement<TicketSeatOrderResultRequest> createTicketSeatOrderResultRequest(TicketSeatOrderResultRequest value) {
		return new JAXBElement<TicketSeatOrderResultRequest>(_TicketSeatOrderResultRequest_QNAME, TicketSeatOrderResultRequest.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link TicketSeatOrderInquiryResultResponse }{@code >}
	 * 
	 */
	@XmlElementDecl(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", name = "ticketSeatOrderInquiryResultResponse")
	public JAXBElement<TicketSeatOrderInquiryResultResponse> createTicketSeatOrderInquiryResultResponse(TicketSeatOrderInquiryResultResponse value) {
		return new JAXBElement<TicketSeatOrderInquiryResultResponse>(_TicketSeatOrderInquiryResultResponse_QNAME, TicketSeatOrderInquiryResultResponse.class, null, value);
	}
}
