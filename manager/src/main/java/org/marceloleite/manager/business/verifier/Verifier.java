package org.marceloleite.manager.business.verifier;

public interface Verifier<T1, T2> {

	void verify(T1 firstObject, T2 secondObject);
}
