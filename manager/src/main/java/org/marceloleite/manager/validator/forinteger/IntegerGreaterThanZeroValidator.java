package org.marceloleite.manager.validator.forinteger;

import java.text.MessageFormat;

import org.marceloleite.manager.validator.Validator;

public class IntegerGreaterThanZeroValidator implements Validator<Integer> {

	private String[] args;

	public IntegerGreaterThanZeroValidator(String... args) {
		super();
		this.args = args;
	}

	@Override
	public void validate(Integer object) {
		if (object.intValue() <= 0) {
			throw new IllegalArgumentException(new MessageFormat("{0} must be greater than zero.").format(args));
		}
	}

}
