
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 訂位查詢response
 * 
 * <p>Java class for ticketSeatOrderInquiryResultResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticketSeatOrderInquiryResultResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}ticketSeatOrderInquiryResponseResult" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticketSeatOrderInquiryResultResponse", propOrder = {
    "ticketSeatOrderInquiryResponseResult"
})
public class TicketSeatOrderInquiryResultResponse {

    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected List<TicketSeatOrderInquiryResponseResult> ticketSeatOrderInquiryResponseResult;

    /**
     * Gets the value of the ticketSeatOrderInquiryResponseResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketSeatOrderInquiryResponseResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketSeatOrderInquiryResponseResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketSeatOrderInquiryResponseResult }
     * 
     * 
     */
    public List<TicketSeatOrderInquiryResponseResult> getTicketSeatOrderInquiryResponseResult() {
        if (ticketSeatOrderInquiryResponseResult == null) {
            ticketSeatOrderInquiryResponseResult = new ArrayList<TicketSeatOrderInquiryResponseResult>();
        }
        return this.ticketSeatOrderInquiryResponseResult;
    }

}
