package com.bluetechnology.test.generices;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class New<T> {
	
	public static <K,V> Map<K,V> map(){
		return new HashMap<K,V>();
	}
	
	public List list(){
		return new ArrayList<T>();
	}
	
	public static void limite(Map<String,String> map){}
	
	public static void main (String[] args){
		
		Map<String,String> map = New.map();
		List<String> list = new New().list();
		list.add("test");
		limite(map);
		System.out.println(map.getClass());
	}
}
