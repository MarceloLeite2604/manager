package org.marceloleite.manager.business.validator;

public interface BinaryValidator<T1, T2> {
	
	public void validate(T2 firstObject, T2 secondObject);
}
