package com.bluetechnology.test.Collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;

public class AsListInference {
	class Snow {
	};
	class Power extends Snow {
		private String	id;
		private String	name;

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public boolean equals(Object object) {
			if (this == object) {
				return true;
			}
			if (object instanceof Power == false) {
				return false;
			}
			final Power otherObject = (Power) object;
			return new EqualsBuilder().append(this.id, otherObject.id).append(this.name, otherObject.name).isEquals();
		}
	};
	class Light extends Power {
	};
	class Heavy extends Power {
	};
	class Crusty extends Snow {
	};
	class Slush extends Snow {
	};

	public static <T> List<T> asList(T... a) {
		return Arrays.<T> asList(a);
	}

	public static <T>List<T> asList(int initialCapacity) {
		return new ArrayList<T>(initialCapacity);
	}

	public void test() {
		// List<Snow> list = Arrays.asList(new Slush(), new Crusty(), new Power());
		// // List<Snow> list2 = Arrays.asList(new Light(),new Heavy());
		// List<Snow> list3 = new ArrayList<Snow>();
		// List<Snow> list4 = Arrays.<Snow> asList(new Light(), new Heavy());
		// Collections.addAll(list3, new Light(), new Heavy());
		List<Snow> list = AsListInference.asList(7);
		Power power = new Power();
		list.add(0, power);
		list.add(1, power);
		list.add(1, power);
		list.add(1, power);
		// list.remove(power);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.indexOf(power));
		}
		// System.out.println(list.get(3));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		new AsListInference().test();
		ArrayList list = new ArrayList();
		list.listIterator();
	}
}
