package org.marceloleite.manager.model;

public class Plot {

	private Position position;

	private Terrain terrain;

	public Plot(Position position, Terrain terrain) {
		super();
		this.position = position;
		this.terrain = terrain;
	}

	public Position getPosition() {
		return position;
	}

	public Terrain getTerrain() {
		return terrain;
	}
}
