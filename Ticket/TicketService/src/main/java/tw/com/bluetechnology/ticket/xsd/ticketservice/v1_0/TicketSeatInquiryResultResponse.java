
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 剩餘機位查詢Response
 * 
 * <p>Java class for ticketSeatInquiryResultResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticketSeatInquiryResultResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}ticketSeatInquiryResult" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticketSeatInquiryResultResponse", propOrder = {
    "ticketSeatInquiryResult"
})
public class TicketSeatInquiryResultResponse {

    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected List<TicketSeatInquiryResult> ticketSeatInquiryResult;

    /**
     * Gets the value of the ticketSeatInquiryResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketSeatInquiryResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketSeatInquiryResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketSeatInquiryResult }
     * 
     * 
     */
    public List<TicketSeatInquiryResult> getTicketSeatInquiryResult() {
        if (ticketSeatInquiryResult == null) {
            ticketSeatInquiryResult = new ArrayList<TicketSeatInquiryResult>();
        }
        return this.ticketSeatInquiryResult;
    }

}
