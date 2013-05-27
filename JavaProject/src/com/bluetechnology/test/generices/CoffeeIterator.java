package com.bluetechnology.test.generices;

import java.util.Iterator;

public class CoffeeIterator implements Iterator<Coffee> {
	
	private int count = 0;
	
	public CoffeeIterator() {
		// TODO Auto-generated constructor stub
	}
	
	public CoffeeIterator(int sz) {
		count = sz;
	}

	@Override
	public boolean hasNext() {
		return count > 0;
	}

	@Override
	public Coffee next() {
		count--;
		return new CoffeeGenerator().next();
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}

}
