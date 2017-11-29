package org.marceloleite.manager.business;

import org.marceloleite.manager.model.Person;
import org.marceloleite.manager.model.PersonGroup;

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
