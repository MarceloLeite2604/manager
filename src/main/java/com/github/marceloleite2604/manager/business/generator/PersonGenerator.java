package com.github.marceloleite2604.manager.business.generator;

import com.github.marceloleite2604.manager.model.Person;
import com.github.marceloleite2604.manager.model.SchoolingLevel;
import com.github.marceloleite2604.manager.model.id.IdController;

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
