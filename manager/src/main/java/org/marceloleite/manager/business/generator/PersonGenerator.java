package org.marceloleite.manager.business.generator;

import org.marceloleite.manager.model.Person;
import org.marceloleite.manager.model.SchoolingLevel;
import org.marceloleite.manager.model.id.IdController;

public class PersonGenerator implements Generator<Person> {

	@Override
	public Person[] generate(int amount) {
		Person[] persons = new Person[amount];
		for (int counter = 0; counter < amount; counter++) {
			persons[counter] = new Person(IdController.getInstance().nextIdFor(Person.class),
					SchoolingLevel.UNNEDUCATED);
		}
		return persons;
	}

}
