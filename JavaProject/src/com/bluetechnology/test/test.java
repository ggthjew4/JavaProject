package com.bluetechnology.test;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test implements Serializable{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= 2692078186248108167L;
	private static final String	EMAIL_PATTERN	= "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private Pattern				pattern;
	private Matcher				matcher;
	private String				videoDate;

	test() {
		pattern = Pattern.compile(EMAIL_PATTERN);
	}

	public void test() {
		Arrays.<String> asList(null);
	}

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("ee");
		List<test> testList = new ArrayList<test>();
		testList.add(new test());
		testList.add(new test());
		// testList.add("2");
		// testList.add("3");
		// testList.add("4");
		Collections.sort(testList, new Comparator<test>() {
			@Override
			public int compare(test o1, test o2) {
				// TODO Auto-generated method stub
				return o1.getVideoDate().compareTo(o2.getVideoDate());
			}
		});
	}

	public String getVideoDate() {
		return videoDate;
	}

	public void setVideoDate(String videoDate) {
		this.videoDate = videoDate;
	}
}
