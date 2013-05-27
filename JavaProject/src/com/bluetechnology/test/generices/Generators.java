package com.bluetechnology.test.generices;

import java.util.ArrayList;
import java.util.Collection;

public class Generators {
	
	public static <T> Collection<T> fill(Collection<T> coll,Generator<T> get,int n){
        for(int i = 0 ;i<=n;i++){
        	coll.add(get.next());
        }
		return coll;
	}
	
	public static void main (String aresp[]){
		Collection<Coffee> coffees = fill(new ArrayList<Coffee>(),new CoffeeGenerator(),8);
		for (Coffee coffee : coffees) {
			System.out.println(coffee);
		  }
		Collection<Integer> funmber = fill(new ArrayList<Integer>(),new Fibonacci(),8);
		for (Integer integer : funmber) {
			System.out.println(integer);
		}
		
	}
}
