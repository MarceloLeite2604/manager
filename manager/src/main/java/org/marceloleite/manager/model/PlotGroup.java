package org.marceloleite.manager.model;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class PlotGroup {

	private Position initialPosition;

	private Dimension dimension;

	private Map<Position, Plot> plots;

	public PlotGroup(Position initialPosition, Dimension dimension) {
		super();
		this.initialPosition = initialPosition;
		this.dimension = dimension;
		this.plots = createPlots(initialPosition, dimension);
	}

	public PlotGroup(Map<Position, Plot> plots) {
		super();
		this.plots = plots;
		this.initialPosition = retrieveInitialPosition(plots);
		this.dimension = retrieveDimension(plots);
	}

	public Dimension getDimension() {
		return dimension;
	}

	public Map<Position, Plot> getPlots() {
		return plots;
	}

	private Map<Position, Plot> createPlots(Position initialPosition, Dimension dimension) {
		Map<Position, Plot> plots = new HashMap<>();
		for (int xPosition = 0; xPosition < dimension.height; xPosition++) {
			for (int yPosition = 0; yPosition < dimension.width; yPosition++) {
				Position position = new Position(initialPosition.x + xPosition, initialPosition.y + yPosition);
				/* TODO: How to define terrain type. */
				plots.put(position, new Plot(position, Terrain.LAND));
			}
		}
		return plots;
	}

	private Position retrieveInitialPosition(Map<Position, Plot> plots) {
		Position minorPosition = retrieveMinorPosition(plots);
		return minorPosition;
	}

	private Dimension retrieveDimension(Map<Position, Plot> plots) {
		Position initialPosition;
		if (this.initialPosition != null) {
			initialPosition = this.initialPosition;
		} else {
			initialPosition = retrieveMinorPosition(plots);
		}
		initialPosition = retrieveMinorPosition(plots);
		Position majorPosition = retrieveMajorPosition(plots);
		return new Dimension(majorPosition.x - initialPosition.x, majorPosition.y - initialPosition.y);
	}

	private Position retrieveMinorPosition(Map<Position, Plot> plots) {
		Position minorPosition = null;
		Set<Position> plotPositions = plots.keySet();
		for (Position plotPosition : plotPositions) {
			if (minorPosition == null) {
				minorPosition = plotPosition;
			} else {
				if (minorPosition.compareTo(plotPosition) < 0) {
					minorPosition = plotPosition;
				}
			}
		}
		return minorPosition;
	}

	private Position retrieveMajorPosition(Map<Position, Plot> plots) {
		Position majorPosition = null;
		Set<Position> plotPositions = plots.keySet();
		for (Position plotPosition : plotPositions) {
			if (majorPosition == null) {
				majorPosition = plotPosition;
			} else {
				if (majorPosition.compareTo(plotPosition) > 0) {
					majorPosition = plotPosition;
				}
			}
		}
		return majorPosition;
	}

}
