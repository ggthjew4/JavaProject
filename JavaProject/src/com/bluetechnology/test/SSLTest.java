package com.bluetechnology.test;

import java.io.IOException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.BasicClientConnectionManager;

public class SSLTest {
	public void SSLMainTest() throws NoSuchAlgorithmException, KeyManagementException, ClientProtocolException, IOException, KeyStoreException, CertificateException {
		//建立SSLContext
		SSLContext sslContext = SSLContext.getInstance("TLS");
		
		// 指定金鑰寫法
		// TrustManagerFactory tmf = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
		// KeyStore ks = KeyStore.getInstance("JKS");
		// File trustFile = new File("clientTrustStore.jks");
		// ks.load(new FileInputStream(trustFile), null);
		// tmf.init(ks);
		
		// 預設金鑰寫法
		X509TrustManager tm = new X509TrustManager() {
			public void checkClientTrusted(X509Certificate[] xcs, String string) throws CertificateException {
			}

			public void checkServerTrusted(X509Certificate[] xcs, String string) throws CertificateException {
			}

			public X509Certificate[] getAcceptedIssuers() {
				return  new X509Certificate[] {};
			}
		};
		
		sslContext.init(null, new TrustManager[] { tm }, null);
		//忽略hostName檢查
		SSLSocketFactory sf = new SSLSocketFactory(sslContext, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
		
		//建立httpsScheme
		Scheme httpsScheme = new Scheme("https", 443, sf);
		SchemeRegistry schemeRegistry = new SchemeRegistry();
		schemeRegistry.register(httpsScheme);
		
		//建立連線
		ClientConnectionManager cm = new BasicClientConnectionManager(schemeRegistry);
		HttpClient httpClient = new DefaultHttpClient(cm);
		// https://data.brightcove.com/analytics-api/videocloud/account/57838016001
		HttpUriRequest httpGet = new HttpGet("https://data.brightcove.com/analytics-api/videocloud/account/57838016001");
		HttpResponse httpResponse = httpClient.execute(httpGet);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("ee");
		List<String> testList = new ArrayList<String>();
//		testList.add("1");
//		testList.add("2");
//		testList.add("3");
//		testList.add("4");
		Collections.sort(testList, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.compareTo(o2);
			}
			
		});
	}
}
