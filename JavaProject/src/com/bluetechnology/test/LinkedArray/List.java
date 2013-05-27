package com.bluetechnology.test.LinkedArray;

import java.util.ArrayList;

public class List {
	private ListNode	root;
	private int			max	= 10;	// use a realistic number
	private int			number;

	// constructor
	public List() {
		this.root = null;
		this.number = 0;
	}

	// getters and setters
	public ListNode getRoot() {
		return this.root;
	}

	public void setRoot(ListNode root) {
		this.root = root;
	}

	public int getMax() {
		return this.max;
	}

	public int getNumber() {
		return this.number;
	}

	public void insert_after(int value) {
		// used values
		ListNode tmp = new ListNode(value);
		ListNode tmp2 = root;
		// if list is empty
		// new node is root
		if (this.root == null) {
			this.root = tmp;
			return;
		}
		// if list is full
		// do not insert any further node
		if (this.number == this.max) {
			System.out.println("[insert] full list");
			return;
		}
		// find next empty space
		while (tmp2.getNext() != null) {
			tmp2 = tmp2.getNext();
		}
		tmp2.setNext(tmp);
		this.number++;
	}

	// 移除第N個Node
	public void remove_nth(int n) {
		ListNode tmpRootNode = this.root;
		for (int i = 1; i < n; i++) {
			if (null == tmpRootNode.getNext()) {
				return;
			}
			tmpRootNode = tmpRootNode.getNext();
			tmpRootNode.setNext(tmpRootNode.getNext().getNext());
			this.number--;
		}
	}

	// 移除value 為 N 的 ListNode
	public void removeOneNode(int value) {
		ListNode tmpRootNode = this.root;
		// 判斷如果root為null則跳出
		if (tmpRootNode == null) {
			return;
		}
		// 判斷root的value equal value 則刪除
		if (tmpRootNode.getValue() == value) {
			this.setRoot(tmpRootNode.getNext());
		}
		while (tmpRootNode.getNext() != null) {
			if (tmpRootNode.getNext().getValue() == value) {
				tmpRootNode.getNext().setNext(tmpRootNode.getNext().getNext());
				this.number--;
			}
		}
	}

	public void insert_begin(int value) {
		ListNode listNode = new ListNode(value, this.root);
		if (this.number == this.max) {
			System.out.println("list is full");
			return;
		}
		this.root = listNode;
		this.number++;
	}

	class ListNode {
		// variables
		private int			value;
		private ListNode	next;

		// constructors
		public ListNode() {
		}

		public ListNode(int value) {
			this.value = value;
		}

		public ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}

		// getters and setters
		public int getValue() {
			return this.value;
		}

		public void setValue(int value) {
			this.value = value;
		}

		public ListNode getNext() {
			return this.next;
		}

		public void setNext(ListNode next) {
			this.next = next;
		}
	}

	public static void main(String arg[]) {
//		List list = new List();
//		list.insert_after(0);
//		list.insert_after(1);
//		list.insert_after(3);
//		list.insert_after(5);
//		list.insert_begin(8);
//		list.remove_nth(2);
//		System.out.println(list.getNumber());
		ArrayList<String> testList = new ArrayList<String>();
		testList.add(0,"");
		testList.add(1,"common");
		testList.add(2,"commonl");
		testList.remove(0);
		testList.indexOf("common");
		System.out.println(testList.indexOf("common"));
	}
}
