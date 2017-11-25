package org.marceloleite.manager.validator;

public interface Validator<T> {

	void validate(T object);
}
