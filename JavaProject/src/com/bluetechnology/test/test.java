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
	
	class Person{
		
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
	}


	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Test person1 = new Test("gggg");
		Test person2 = new Test("kkkk");
		Test person3 = new Test("uuuu");
		List<Test> list = new ArrayList<Test>();
		list.add(person1);
		list.add(person2);
		list.add(person3);
		list.set(0,person3);
		int index = list.indexOf(person3);
		System.out.println(index);
		for(Test vo: list){
			System.out.println(vo.hashCode());
			System.out.println(vo.getVideoDate());	
		}
		
		
	}

	public String getVideoDate() {
		return videoDate;
	}

	public void setVideoDate(String videoDate) {
		this.videoDate = videoDate;
	}
}
