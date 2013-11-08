
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 機位訂位request
 * 
 * <p>Java class for ticketSeatOrderRequestResult element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="ticketSeatOrderRequestResult">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}customerUsername"/>
 *           &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}customerId"/>
 *           &lt;element name="seatCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;/sequence>
 *       &lt;/restriction>
 *     &lt;/complexContent>
 *   &lt;/complexType>
 * &lt;/element>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "customerUsername",
    "customerId",
    "seatCode"
})
@XmlRootElement(name = "ticketSeatOrderRequestResult")
public class TicketSeatOrderRequestResult {

    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected String customerUsername;
    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected String customerId;
    @XmlElement(required = true)
    protected String seatCode;

    /**
     * Gets the value of the customerUsername property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerUsername() {
        return customerUsername;
    }

    /**
     * Sets the value of the customerUsername property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerUsername(String value) {
        this.customerUsername = value;
    }

    /**
     * Gets the value of the customerId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Sets the value of the customerId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCustomerId(String value) {
        this.customerId = value;
    }

    /**
     * Gets the value of the seatCode property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatCode() {
        return seatCode;
    }

    /**
     * Sets the value of the seatCode property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatCode(String value) {
        this.seatCode = value;
    }

}
