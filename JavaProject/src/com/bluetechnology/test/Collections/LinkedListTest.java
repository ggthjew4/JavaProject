package com.bluetechnology.test.Collections;

import java.util.LinkedList;

public class LinkedListTest {
	public void testLinkedList() {
		LinkedList<String> linkedList = new LinkedList<String>();
		linkedList.add("test1");
		linkedList.add("test2");
		linkedList.add("test3");
		linkedList.add("test4");
		System.out.println(linkedList.getFirst());
		System.out.println(linkedList.element());
		System.out.println("linedList offer test : "+linkedList.offer("test1"));
		System.out.println("linedList offerLast test : "+linkedList.offerLast("test1"));
		System.out.println("linedList add add : "+linkedList.add("test5"));
		//兩者效果依樣，實作方法也幾乎一樣，不懂為何要創立兩種方法
		System.out.println("linkedlist content : " + linkedList);
	}

	public static void main(String[] args) {
		new LinkedListTest().testLinkedList();
	}
}
