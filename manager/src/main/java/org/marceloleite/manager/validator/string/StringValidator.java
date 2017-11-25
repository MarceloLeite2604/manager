package org.marceloleite.manager.validator.string;

import java.text.MessageFormat;

import org.marceloleite.manager.validator.ObjectNotNullValidator;
import org.marceloleite.manager.validator.Validator;

public class StringValidator implements Validator<String> {

	private String[] args;

	public StringValidator(String... args) {
		super();
		this.args = args;
	}

	@Override
	public void validate(String object) {
		new ObjectNotNullValidator(args).validate(object);
		if (object.isEmpty()) {
			throw new IllegalArgumentException(new MessageFormat("{0} is empty.").format(args));
		}
	}

}
