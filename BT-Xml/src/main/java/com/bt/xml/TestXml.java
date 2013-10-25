package com.bt.xml;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.xml.transform.stream.StreamSource;

import org.apache.commons.beanutils.BeanUtils;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.bt.BtMainPlaform;
import com.bt.session.BtHibernateSession;
import com.bt.vo.BtUser;

public class TestXml {
	
	private Jaxb2Marshaller marshaller;
	
	private Jaxb2Marshaller unmarshaller;
	
	public void execute(Element element) throws DocumentException{
		
	}
	
	public Object convertFromXMLToObject(String xmlfile) throws IOException {
		 
		FileInputStream is = null;
		try {
			is = new FileInputStream(xmlfile);
			return unmarshaller.unmarshal(new StreamSource(is));
		} finally {
			if (is != null) {
				is.close();
			}
		}
	}
	
    public Jaxb2Marshaller getMarshaller() {
		return marshaller;
	}

	public void setMarshaller(Jaxb2Marshaller marshaller) {
		this.marshaller = marshaller;
	}

	public Jaxb2Marshaller getUnmarshaller() {
		return unmarshaller;
	}

	public void setUnmarshaller(Jaxb2Marshaller unmarshaller) {
		this.unmarshaller = unmarshaller;
	}

	public static void main(final String arg[]) throws DocumentException, IOException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException, NoSuchMethodException{
		ApplicationContext appContext = new ClassPathXmlApplicationContext("Spring-Configuration.xml");
//		TestXml converter = (TestXml) appContext.getBean("XMLConverter");
//		System.out.println(BtXmlParsingHelp.getXmlActualFilePath("bt_hibernate.xml"));
//		BluetechnologyMapping ob = (BluetechnologyMapping)converter.convertFromXMLToObject(BtXmlParsingHelp.getXmlActualFilePath("bt_hibernate.xml"));
        BtHibernateSession session = BtMainPlaform.openSession();
//        List<BtUser> resultList = session.list(BtUser.class);
//        BtUser bt = session.findById(BtUser.class, new Long(1));
//        System.out.println(session.save(new BtUser()));
        BtUser user = new BtUser();
        user.setUserAge(20);
        user.setUserName("kerrigan");
        user.setUserPwd("2juclau");
        user.setUserVer(1);
        user.setUserId("2");
        final String columnValue = BeanUtils.getProperty(user,"userSn");
        session.save(user);
//        Map map = new HashMap();
//        map.put("userId", "kerrigan");
//        BtUser bt = (BtUser) Class.forName(BtUser.class.getName()).newInstance();
//        BeanUtils.populate(bt, map);
//        System.out.println(bt.getUserId());
        
        
		//		System.out.println(BtXmlParsingHelp.getXmlActualFilePath("bt_hibernate.xml"));

    }
}
