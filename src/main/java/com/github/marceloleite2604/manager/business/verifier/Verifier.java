package com.github.marceloleite2604.manager.business.verifier;

public interface Verifier<T1, T2> {

	void verify(T1 firstObject, T2 secondObject);
}
