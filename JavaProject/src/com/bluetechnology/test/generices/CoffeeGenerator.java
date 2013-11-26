package com.bluetechnology.test.Generices;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>, Iterable<Coffee> {
	private Class[]			types	= { Latte.class, Mocha.class };
	private static Random	rand	= new Random(50);
	private int				count	= 0;
	
	static {
		
		System.out.println("come to here");
	}

	public CoffeeGenerator() {
		// TODO Auto-generated constructor stub
	}

	public CoffeeGenerator(int st) {
		this.count = st;
	}

	@Override
	public Iterator<Coffee> iterator() {
		return new CoffeeIterator(count);
	}

	@Override
	public Coffee next() {
		Coffee returnObject = null;
		try {
			returnObject = (Coffee) types[rand.nextInt(types.length)].newInstance();
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			return returnObject;
		}
	}
}
