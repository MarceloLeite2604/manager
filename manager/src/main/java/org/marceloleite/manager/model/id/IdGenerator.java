package org.marceloleite.manager.model.id;

class IdGenerator {

	private long nextId;

	public IdGenerator() {
		super();
		this.nextId = 0l;
	}

	public long nextId() {
		return nextId++;
	}

}
