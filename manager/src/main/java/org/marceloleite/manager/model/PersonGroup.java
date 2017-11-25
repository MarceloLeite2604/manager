package org.marceloleite.manager.model;

import java.util.HashMap;
import java.util.Map;

public class PersonGroup {

	private Map<Long, Person> persons;

	private int max;

	public PersonGroup(int max) {
		super();
		this.max = max;
		this.persons = new HashMap<>();
	}

	public Map<Long, Person> getPersons() {
		return persons;
	}

	public int getMaxPersons() {
		return max;
	}

	public void add(Person person) {
		if (max >= persons.size()) {
			throw new IllegalStateException("Maximum amount of persons reached.");
		}

		persons.put(person.getId(), person);
	}
}
