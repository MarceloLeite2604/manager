package org.marceloleite.manager.model;

import org.marceloleite.manager.model.plot.PlotGroup;

public class Lot {

	private PlotGroup plotGroup;
	
	private BuildingType buildingType;

	public Lot(PlotGroup plotGroup, BuildingType buildingType) {
		super();
		this.plotGroup = plotGroup;
		/* TODO: Set lot on plot group. */
		this.buildingType = buildingType;
	}

	public PlotGroup getPlotGroup() {
		return plotGroup;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}
}