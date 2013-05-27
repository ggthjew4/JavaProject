package com.bluetechnology.test.generices;

public class Tuple {
	public static <A, B> TwoTuple<A, B> tuple(A a, B b) {
		return new TwoTuple<A, B>(a, b);
	}

	public static <A, B, C> ThreeTouple<A, B, C> tuple(A a, B b, C c) {
		return new ThreeTouple<A, B, C>(a, b, c);
	}

	public static <A, B, C, D> FourTouple<A, B, C, D> tuple(A a, B b, C c, D d) {
		return new FourTouple<A, B, C, D>(a, b, c, d);
	}
}
