package org.marceloleite.manager.business.validator.fordouble;

import java.text.MessageFormat;

import org.marceloleite.manager.business.validator.Validator;

public class DoubleGreaterThanZeroValidator implements Validator<Double> {

	private String[] args;

	public DoubleGreaterThanZeroValidator(String... args) {
		this.args = args;
	}

	@Override
	public void validate(Double object) {
		if (object.doubleValue() <= 0.0d) {
			throw new IllegalArgumentException(new MessageFormat("{0} must be greater than zero.").format(args));
		}

	}

}
