package com.bt.xml;

import java.io.FileInputStream;
import java.io.IOException;

import javax.xml.transform.stream.StreamSource;

import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import com.bt.xml.jaxb.BluetechnologyMapping;

public class BtXmlParsingHelp {
	// private static ApplicationContext springContext = new ClassPathXmlApplicationContext("Spring-Configuration.xml");
	private static Jaxb2Marshaller			marshaller;
	private static Jaxb2Marshaller			unmarshaller;
	private static BluetechnologyMapping	object;

	public static BluetechnologyMapping loadXMLFile(final String fileName) {
		if (null == object) {
			try {
				object = (BluetechnologyMapping) (convertFromXMLToObject(BtXmlParsingHelp.getXmlActualFilePath(fileName)));
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return object;
	}

	private static Object convertFromXMLToObject(String xmlfile) throws IOException {
		FileInputStream is = null;
		try {
			is = new FileInputStream(xmlfile);
			return unmarshaller.unmarshal(new StreamSource(is));
		}
		finally {
			if (is != null) {
				is.close();
			}
		}
	}

	public static String getXmlActualFilePath(final String flieName) {
		return BtXmlParsingHelp.class.getClassLoader().getResource(flieName).getFile();
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
}
