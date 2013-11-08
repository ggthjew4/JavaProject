package tw.com.bluetechnology.ticket.dao;

import java.util.Date;
import java.util.GregorianCalendar;

import javax.sql.DataSource;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class CommonTicketDao {
	private JdbcTemplate	jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	protected final XMLGregorianCalendar dateCovertToXMLGregorianCalendar(final Date pDate) {
		GregorianCalendar gregory = new GregorianCalendar();
		gregory.setTime(pDate);
		XMLGregorianCalendar calendar = null;
		try {
			calendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregory);
		}
		catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return calendar;
	}
}
