package com.github.marceloleite2604.manager.business;

import com.github.marceloleite2604.manager.model.Person;
import com.github.marceloleite2604.manager.model.PersonGroup;

public class PersonGroupBO {

	public boolean canAddPerson(PersonGroup personGroup) {
		return (personGroup.getPersons().size() < personGroup.getMaxPersons());
	}

	public void addPerson(PersonGroup inhabitants, Person person) {
		if (!canAddPerson(inhabitants)) {
			throw new RuntimeException("Maximum amount of persons reached.");
		}

		inhabitants.getPersons().put(person.getId(), person);
	}

}
