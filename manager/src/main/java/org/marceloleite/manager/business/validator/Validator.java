package org.marceloleite.manager.business.validator;

public interface Validator<T> {

	void validate(T object);
}
