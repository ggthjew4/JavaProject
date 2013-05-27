package com.bluetechnology.test.generices;

public class Fibonacci implements Generator<Integer> {
	private int	count	= 0;

	private Integer fib(int n) {
		if (n < 2) {
			return 1;
		}
		return fib(n - 1) + fib(n - 2);
	}

	private Integer test(int n) {
		if (n < 2) {
			return 1;
		}
		int test1 = test(n - 1);
		int test2 = test(n - 2);
		return test1 + test2;
	}

	@Override
	public Integer next() {
		// return fib(count++);
		return test(count++);
	}

	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		for (int i = 0; i < 18; i++) {
			System.out.println(fibonacci.next());
		}
	}
}
