package com.bluetechnology.test.Iterable;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class IterableClass<T> implements Iterable<T> {
	private List<T>	list	= null;
	private int		size	= 0;
	private int		index	= 0;

	public IterableClass(final List<T> list) {
		this.list = list;
		this.size = list.size();
	}

	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			@Override
			public void remove() {
				throw new UnsupportedOperationException();
			}

			@Override
			public T next() {
				return list.get(index++);
			}

			@Override
			public boolean hasNext() {
				return index < size;
			}
		};
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final String[] array = "I,am,a,Strudent".split(",");
		final IterableClass<String> imp = new IterableClass<String>(Arrays.<String> asList(array));
		for (final String v : imp) {
			System.out.println(v);
		}
	}
}
