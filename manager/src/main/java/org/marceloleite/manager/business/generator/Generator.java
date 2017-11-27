package org.marceloleite.manager.business.generator;

public interface Generator<T> {

	default T generate() {
		return generate(1)[0];
	}
	T[] generate(int amount);
}
