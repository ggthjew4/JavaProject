
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 機位訂位request
 * 
 * <p>Java class for ticketSeatOrderResultRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ticketSeatOrderResultRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}ticketSeatOrderRequestResult" maxOccurs="unbounded"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ticketSeatOrderResultRequest", propOrder = {
    "ticketSeatOrderRequestResult"
})
public class TicketSeatOrderResultRequest {

    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected List<TicketSeatOrderRequestResult> ticketSeatOrderRequestResult;

    /**
     * Gets the value of the ticketSeatOrderRequestResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ticketSeatOrderRequestResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTicketSeatOrderRequestResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TicketSeatOrderRequestResult }
     * 
     * 
     */
    public List<TicketSeatOrderRequestResult> getTicketSeatOrderRequestResult() {
        if (ticketSeatOrderRequestResult == null) {
            ticketSeatOrderRequestResult = new ArrayList<TicketSeatOrderRequestResult>();
        }
        return this.ticketSeatOrderRequestResult;
    }

}
