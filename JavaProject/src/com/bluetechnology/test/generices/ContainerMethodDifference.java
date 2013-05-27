package com.bluetechnology.test.generices;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class ContainerMethodDifference {
	final static Set<String>	object	= null;
	static {
		methodSet(Object.class);
		object.add("clone");
	}

	static Set<String> methodSet(Class<?> type) {
		Set<String> result = new TreeSet<String>();
		for (Method m : type.getMethods()) {
			result.add(m.getName());
		}
		return result;
	}

	static void interfaces(Class<?> type) {
		List<String> result = new ArrayList<String>();
		for (Class<?> c : type.getInterfaces()) {
			result.add(c.getSimpleName());
		}
		System.out.println(result);
	}

	static void difference(Class<?> superSet, Class<?> subSet) {
		Set<String> comp = Sets.difference(methodSet(superSet), methodSet(subSet));
		comp.removeAll(object);
		System.out.println(comp);
		interfaces(superSet);
	}
}
