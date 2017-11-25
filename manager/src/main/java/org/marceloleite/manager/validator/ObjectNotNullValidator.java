package org.marceloleite.manager.validator;

import java.text.MessageFormat;

public class ObjectNotNullValidator implements Validator<Object> {

	public String[] args;

	public ObjectNotNullValidator(String... args) {
		this.args = args;
	}

	@Override
	public void validate(Object object) {

		if (object == null) {
			throw new IllegalArgumentException(new MessageFormat("{0} cannot be null.").format(args));
		}

	}

}
