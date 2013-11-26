package com.bluetechnology.test.Generices;

public class BasicGenerator<T> implements Generator<T> {
	private Class<T> type;

	public BasicGenerator(final Class clzz) {
		this.type = clzz;
	}

	@Override
	public T next() {
		try {
			return type.newInstance();
		}
		catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static <T>Generator<T> create(Class type){
		return new BasicGenerator<T>(type);
	}
	
	public static void main (String[] args){
		Generator<CountedObject> ge = BasicGenerator.create(CountedObject.class);
		ge.next();
		
	}
}
