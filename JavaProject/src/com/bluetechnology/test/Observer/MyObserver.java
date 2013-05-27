package com.bluetechnology.test.Observer;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import com.bluetechnology.test.Observer.MyModel.Person;

public class MyObserver implements PropertyChangeListener {
	public MyObserver(MyModel model) {
		model.addChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		System.out.println("Changed property: " + event.getPropertyName() + " old:" + event.getOldValue() + " new: " + event.getNewValue());
	}

	public static void main(String[] args) {
		MyModel model = new MyModel();
		new MyObserver(model);
		// We change the last name of the person, observer will get notified
		for (Person person : model.getPersons()) {
			person.setLastName(person.getLastName() + "1");
		}
		// We change the name of the person, observer will get notified
		for (Person person : model.getPersons()) {
			person.setFirstName(person.getFirstName() + "1");
		}
	}
}
