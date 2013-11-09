package tw.com.bluetechnology.ticket.dao;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.sql.DataSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Ticket Dao 共用抽象類別
 * 
 * @see JdbcTemplate
 * @see XMLGregorianCalendar
 * @author kerrigan
 */
public abstract class CommonTicketDao {
	/**
	 * Spring {@link JdbcTemplate} 程式，供給Dao子類別存取資料庫用
	 */
	private JdbcTemplate	jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	/**
	 * 轉換{@link Date}物件為{@link XMLGregorianCalendar}
	 * 
	 * @param 帶轉換的{@link Date}物件
	 * @return {@link XMLGregorianCalendar}物件
	 */
	protected final XMLGregorianCalendar dateCovertToXMLGregorianCalendar(final Date pDate) {
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(pDate);
		XMLGregorianCalendar calendar = null;
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
		}
		catch (DatatypeConfigurationException e) {
			e.printStackTrace();
		}
		return calendar;
	}
}
