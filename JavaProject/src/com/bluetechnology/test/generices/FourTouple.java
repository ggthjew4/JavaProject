package com.bluetechnology.test.generices;

public class FourTouple<A, B, C, D> extends ThreeTouple<A, B, C> {
	final D	fourth;

	public FourTouple(A a, B b, C c, D d) {
		super(a, b, c);
		this.fourth = d;
	}
	
	private static class Node<U>{
		U item;
		Node<U> next;
		Node(U item,Node<U> next){
			this.item = item;
			this.next = next;
		}
		
	}
}
