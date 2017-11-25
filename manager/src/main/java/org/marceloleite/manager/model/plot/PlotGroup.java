package org.marceloleite.manager.model.plot;

import java.awt.Dimension;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.marceloleite.manager.model.Position;
import org.marceloleite.manager.model.Terrain;

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
		Position minorPosition = retrieveMinorPosition();
		return minorPosition;
	}

	private Dimension retrieveDimension(Map<Position, Plot> plots) {
		Position initialPosition;
		if (this.initialPosition != null) {
			initialPosition = this.initialPosition;
		} else {
			initialPosition = retrieveMinorPosition();
		}
		initialPosition = retrieveMinorPosition();
		Position majorPosition = retrieveMajorPosition();
		return new Dimension(majorPosition.x - initialPosition.x, majorPosition.y - initialPosition.y);
	}

	public Position retrieveMinorPosition() {
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

	public Position retrieveMajorPosition() {
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

	public boolean isVacant() {
		return (plots.entrySet().stream().filter(entry -> entry.getValue().isOccupied()).count() == 0l);
	}

	public PlotGroup retrieveSubPlot(Position position, Dimension dimension) {
		PlotGroup plotGroup = new PlotGroup(position, dimension);
		new ExistsPlotValidator(this.toString(), plotGroup.toString()).validate(this, plotGroup);
		Map<Position, Plot> plotsRetrieved = new HashMap<>();
		for (int xPosition = position.x; xPosition < (position.x + dimension.getWidth()); xPosition++) {
			for (int yPosition = position.y; yPosition < (position.y + dimension.getHeight()); yPosition++) {
				Position positionToRetrieve = new Position(xPosition, yPosition);
				plotsRetrieved.put(positionToRetrieve, plotsRetrieved.get(positionToRetrieve));
			}
		}
		return new PlotGroup(plotsRetrieved);
	}

	/*
	 * public boolean exists(PlotGroup plotGroup) { return
	 * (plotGroup.retrieveMinorPosition().compareTo(retrieveMinorPosition()) >= 0 &&
	 * plotGroup.retrieveMajorPosition().compareTo(retrieveMajorPosition()) >= 0); }
	 */

	@Override
	public String toString() {
		return initialPosition.toString() + dimension.toString();
	}

}
