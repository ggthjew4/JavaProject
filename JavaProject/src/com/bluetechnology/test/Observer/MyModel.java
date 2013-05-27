package com.bluetechnology.test.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;

public class MyModel {
	private List<Person>					persons					= new ArrayList<Person>();
	private List<PropertyChangeListener>	propertyChangeListeners	= new ArrayList<PropertyChangeListener>();

	public MyModel() {
		persons.add(new Person("lin", "yang"));
		persons.add(new Person("li", "fun"));
	}

	public List<Person> getPersons() {
	    return persons;
	  }
	private void notifyListeners(Object object, String property, String oldValue, String newValue) {
		for (PropertyChangeListener listener : propertyChangeListeners) {
			listener.propertyChange(new PropertyChangeEvent(this, property, oldValue, newValue));
		}
	}

	public void addChangeListener(PropertyChangeListener listener) {
		propertyChangeListeners.add(listener);
	}

	public class Person {
		private String	firstName;
		private String	lastName;

		public Person(String firstName, String lastName) {
			this.firstName = firstName;
			this.lastName = lastName;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			notifyListeners(this, "firstName", this.firstName, this.firstName = firstName);
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
	}
}
