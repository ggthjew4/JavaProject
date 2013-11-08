
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ticketSeatInquiryRequest element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="ticketSeatInquiryRequest">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="airPlaneInterval" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="airPlaneFrom" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="airPlaneDestination" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="airPlaneClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "airPlaneInterval",
    "airPlaneFrom",
    "airPlaneDestination",
    "airPlaneClass"
})
@XmlRootElement(name = "ticketSeatInquiryRequest")
public class TicketSeatInquiryRequest {

    @XmlElement(required = true)
    protected String airPlaneInterval;
    @XmlElement(required = true)
    protected String airPlaneFrom;
    @XmlElement(required = true)
    protected String airPlaneDestination;
    @XmlElement(required = true)
    protected String airPlaneClass;

    /**
     * Gets the value of the airPlaneInterval property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirPlaneInterval() {
        return airPlaneInterval;
    }

    /**
     * Sets the value of the airPlaneInterval property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirPlaneInterval(String value) {
        this.airPlaneInterval = value;
    }

    /**
     * Gets the value of the airPlaneFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirPlaneFrom() {
        return airPlaneFrom;
    }

    /**
     * Sets the value of the airPlaneFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirPlaneFrom(String value) {
        this.airPlaneFrom = value;
    }

    /**
     * Gets the value of the airPlaneDestination property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirPlaneDestination() {
        return airPlaneDestination;
    }

    /**
     * Sets the value of the airPlaneDestination property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirPlaneDestination(String value) {
        this.airPlaneDestination = value;
    }

    /**
     * Gets the value of the airPlaneClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirPlaneClass() {
        return airPlaneClass;
    }

    /**
     * Sets the value of the airPlaneClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirPlaneClass(String value) {
        this.airPlaneClass = value;
    }

}
