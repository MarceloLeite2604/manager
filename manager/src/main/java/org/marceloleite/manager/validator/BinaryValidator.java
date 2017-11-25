package org.marceloleite.manager.validator;

public interface BinaryValidator<T1, T2> {
	
	public void validate(T2 firstObject, T2 secondObject);
}
