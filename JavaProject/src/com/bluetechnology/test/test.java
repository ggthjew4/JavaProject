package com.bluetechnology.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test implements Serializable{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2692078186248108167L;
	private static final String	EMAIL_PATTERN	= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern				pattern;
	private Matcher				matcher;
	private String				videoDate;

	Test() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}
	
	Test(final String videoDate ){
		this.videoDate = videoDate;
	}
	
	class Person extends Test {
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}
	
	public void print(){
		Person p = new Person();
		Test t =  new Test();
		System.out.println(p.getClass().isAssignableFrom(t.getClass()));
		System.out.println(t.getClass().isAssignableFrom(p.getClass()));
		System.out.println(p.getClass().isAssignableFrom(p.getClass()));
		System.out.println(t.getClass().isInstance(p));
		System.out.println(new Person() instanceof Test);
		
	}


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		new Test().print();
		
	}

	public String getVideoDate() {
		return videoDate;
	}

	public void setVideoDate(String videoDate) {
		this.videoDate = videoDate;
	}
}
