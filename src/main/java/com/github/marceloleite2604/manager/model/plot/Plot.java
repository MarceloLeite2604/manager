package com.github.marceloleite2604.manager.model.plot;

import com.github.marceloleite2604.manager.model.Position;
import com.github.marceloleite2604.manager.model.Terrain;

public class Plot {

	private Position position;

	private Terrain terrain;

	private boolean occupied;

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

	public void setOccupied(boolean occupied) {
		this.occupied = occupied;
	}

	public boolean isOccupied() {
		return occupied;
	}
}
