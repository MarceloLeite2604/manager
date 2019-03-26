package com.github.marceloleite2604.manager.model.id;

import java.util.HashMap;
import java.util.Map;

public class IdController {

	private Map<Class<? extends Object>, IdGenerator> generators;

	private static IdController instance;

	private IdController() {
		this.generators = new HashMap<>();
	}

	public static IdController getInstance() {
		if (instance == null) {
			instance = new IdController();
		}
		return instance;
	}

	public long nextIdFor(Class<? extends Object> forClass) {
		IdGenerator idGenerator = generators.get(forClass);
		if (idGenerator == null) {
			idGenerator = new IdGenerator();
			generators.put(forClass, idGenerator);
		}
		return idGenerator.nextId();
	}
}
