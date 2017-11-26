package org.marceloleite.manager.model.plot;

import org.marceloleite.manager.model.Position;
import org.marceloleite.manager.model.Terrain;

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
