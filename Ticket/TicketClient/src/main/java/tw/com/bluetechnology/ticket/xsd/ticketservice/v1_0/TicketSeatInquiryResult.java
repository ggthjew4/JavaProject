package tw.com.bluetechnology.ticket.xsd.ticketservice.v1_0;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ticketSeatInquiryResult element declaration.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;element name="ticketSeatInquiryResult">
 *   &lt;complexType>
 *     &lt;complexContent>
 *       &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *         &lt;sequence>
 *           &lt;element name="airPlaneNo" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *           &lt;element name="seatCode" type="{http://www.w3.org/2001/XMLSchema}string"/>
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
@XmlType(name = "", propOrder = { "airPlaneNo", "seatCode", "seatNo" })
/**
 * 班機剩餘座位查詢結果物件
 * @author kerrigan
 */
@XmlRootElement(name = "ticketSeatInquiryResult")
public class TicketSeatInquiryResult {
	/**
     * 班機代號
     */
	@XmlElement(required = true)
	protected String	airPlaneNo;
	/**
     * 座位代號
     */
	@XmlElement(required = true)
	protected String	seatCode;
	/**
     * 座位編號
     */
	@XmlElement(required = true)
	protected String	seatNo;

	/**
	 * Gets the value of the airPlaneNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAirPlaneNo() {
		return airPlaneNo;
	}

	/**
	 * Sets the value of the airPlaneNo property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAirPlaneNo(String value) {
		this.airPlaneNo = value;
	}

	/**
	 * Gets the value of the seatCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSeatCode() {
		return seatCode;
	}

	/**
	 * Sets the value of the seatCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSeatCode(String value) {
		this.seatCode = value;
	}

	/**
	 * Gets the value of the seatNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSeatNo() {
		return seatNo;
	}

	/**
	 * Sets the value of the seatNo property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSeatNo(String value) {
		this.seatNo = value;
	}
}
