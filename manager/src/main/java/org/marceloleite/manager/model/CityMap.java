package org.marceloleite.manager.model;

public class CityMap {

	private String name;

	private MapSize mapSize;

	private PlotGroup plotGroup;

	public CityMap(String name, MapSize mapSize) {
		super();
		this.name = name;
		this.mapSize = mapSize;
		this.plotGroup = new PlotGroup(new Position(0, 0), mapSize.getDimension());
	}

	public String getName() {
		return name;
	}

	public PlotGroup getPlotGroup() {
		return plotGroup;
	}

	public MapSize getMapSize() {
		return mapSize;
	}
}
