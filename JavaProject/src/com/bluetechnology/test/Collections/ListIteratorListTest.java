package com.bluetechnology.test.Collections;

import java.util.ArrayList;
import java.util.ListIterator;

public class ListIteratorListTest {
	public ArrayList<String> getListInstance() {
		return (ArrayList<String>) AsListInference.<String> asList(10);
	}
	
	
	public final static void main(final String[]arg){
		ArrayList<String> list = new ListIteratorListTest().getListInstance();
		list.add("a");
		list.add("b");
		list.add("c");
		list.add("d");
		list.add("e");
		for(String vo :list){
			if(list.indexOf(vo)==1){
				list.add(1,"f");
			}
		}
//		ListIterator<String> listIterator = list.listIterator();
//		while(listIterator.hasNext()){
//			System.out.println(listIterator.next());
//			
//		}
//		System.out.println(listIterator.previous());
	}
}
