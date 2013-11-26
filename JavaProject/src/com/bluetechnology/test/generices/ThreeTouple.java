package com.bluetechnology.test.Generices;

public class ThreeTouple<A,B,C> extends TwoTuple<A, B> {
	
	public final C third;
	
	public ThreeTouple(A a, B b ,C c) {
		super(a,b);
		this.third = c;
	}
}
