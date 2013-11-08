
package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * 訂位查詢response
 * 
 * <p>Java class for ticketSeatOrderInquiryResponseResult element declaration.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="ticketSeatOrderInquiryResponseResult">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="airPlaneDepartureTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *           &lt;element name="airPlaneArrivalTime" type="{http://www.w3.org/2001/XMLSchema}dateTime"/>
 *           &lt;element name="airPlaneNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="cabinClass" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="seatNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
    "airPlaneDepartureTime",
    "airPlaneArrivalTime",
    "airPlaneNo",
    "cabinClass",
    "seatNo"
})
@XmlRootElement(name = "ticketSeatOrderInquiryResponseResult")
public class TicketSeatOrderInquiryResponseResult {

    @XmlElement(required = true)
    protected XMLGregorianCalendar airPlaneDepartureTime;
    @XmlElement(required = true)
    protected XMLGregorianCalendar airPlaneArrivalTime;
    @XmlElement(required = true)
    protected String airPlaneNo;
    @XmlElement(required = true)
    protected String cabinClass;
    @XmlElement(required = true)
    protected String seatNo;

    /**
     * Gets the value of the airPlaneDepartureTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAirPlaneDepartureTime() {
        return airPlaneDepartureTime;
    }

    /**
     * Sets the value of the airPlaneDepartureTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAirPlaneDepartureTime(XMLGregorianCalendar value) {
        this.airPlaneDepartureTime = value;
    }

    /**
     * Gets the value of the airPlaneArrivalTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getAirPlaneArrivalTime() {
        return airPlaneArrivalTime;
    }

    /**
     * Sets the value of the airPlaneArrivalTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setAirPlaneArrivalTime(XMLGregorianCalendar value) {
        this.airPlaneArrivalTime = value;
    }

    /**
     * Gets the value of the airPlaneNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAirPlaneNo() {
        return airPlaneNo;
    }

    /**
     * Sets the value of the airPlaneNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAirPlaneNo(String value) {
        this.airPlaneNo = value;
    }

    /**
     * Gets the value of the cabinClass property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCabinClass() {
        return cabinClass;
    }

    /**
     * Sets the value of the cabinClass property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCabinClass(String value) {
        this.cabinClass = value;
    }

    /**
     * Gets the value of the seatNo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeatNo() {
        return seatNo;
    }

    /**
     * Sets the value of the seatNo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeatNo(String value) {
        this.seatNo = value;
    }

}
