package org.marceloleite.manager.model.plot;

import org.marceloleite.manager.model.Lot;
import org.marceloleite.manager.model.Position;
import org.marceloleite.manager.model.Terrain;

public class Plot {

	private Position position;

	private Terrain terrain;

	private Lot lot;

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

	public void setLot(Lot lot) {
		this.lot = lot;
	}

	public Lot getLot() {
		return lot;
	}

	public boolean isOccupied() {
		return lot != null;
	}
}
