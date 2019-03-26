package com.github.marceloleite2604.manager.model.plot;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.github.marceloleite2604.manager.model.Dimension;
import com.github.marceloleite2604.manager.model.Position;
import com.github.marceloleite2604.manager.model.Terrain;

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

	public Position getInitialPosition() {
		return initialPosition;
	}

	private Map<Position, Plot> createPlots(Position initialPosition, Dimension dimension) {
		Map<Position, Plot> plots = new HashMap<>();
		for (int xPosition = 0; xPosition < dimension.height; xPosition++) {
			for (int yPosition = 0; yPosition < dimension.width; yPosition++) {
				Position position = new Position(initialPosition.getX() + xPosition,
						initialPosition.getY() + yPosition);
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
		Position majorPosition = retrieveMajorPosition();
		return new Dimension(majorPosition.getX() + 1, majorPosition.getY() + 1);
	}

	public Position retrieveMinorPosition() {
		Position minorPosition = null;
		Set<Position> plotPositions = plots.keySet();
		for (Position plotPosition : plotPositions) {
			if (minorPosition == null) {
				minorPosition = plotPosition;
			} else {
				if (plotPosition.compareTo(minorPosition) < 0) {
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
				if (plotPosition.compareTo(majorPosition) > 0) {
					majorPosition = plotPosition;
				}
			}
		}
		return majorPosition;
	}

	public boolean isOccupied() {
		return (plots.values().stream().filter(Plot::isOccupied).count() > 0l);
	}

	public PlotGroup retrieveSubPlot(Position position, Dimension dimension) {
		PlotGroup plotGroup = new PlotGroup(position, dimension);
		new ExistsPlotValidator().validate(plotGroup, this);
		Map<Position, Plot> plotsRetrieved = new HashMap<>();
		for (int xPosition = position.getX(); xPosition < (position.getX() + dimension.getWidth()); xPosition++) {
			for (int yPosition = position.getY(); yPosition < (position.getY() + dimension.getHeight()); yPosition++) {
				Position positionToRetrieve = new Position(xPosition, yPosition);
				plotsRetrieved.put(positionToRetrieve, plots.get(positionToRetrieve));
			}
		}
		return new PlotGroup(plotsRetrieved);
	}

	@Override
	public String toString() {
		return initialPosition.toString() + dimension.toString();
	}

}
