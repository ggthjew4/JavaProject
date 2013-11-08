
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 訂位查詢request
 * 
 * <p>Java class for ticketSeatOrderInquiryRequest element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="ticketSeatOrderInquiryRequest">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}customerId"/>
 *           &lt;element ref="{http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0}customerSn"/>
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
    "customerId",
    "customerSn"
})
@XmlRootElement(name = "ticketSeatOrderInquiryRequest")
public class TicketSeatOrderInquiryRequest {

    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected String customerId;
    @XmlElement(namespace = "http://www.bluetechnology.com.tw/Ticket/xsd/TicketService/v1-0", required = true)
    protected BigInteger customerSn;

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
     * Gets the value of the customerSn property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getCustomerSn() {
        return customerSn;
    }

    /**
     * Sets the value of the customerSn property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setCustomerSn(BigInteger value) {
        this.customerSn = value;
    }

}
