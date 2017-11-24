package org.marceloleite.manager.model;

import java.util.List;

public class Building {

	private PlotGroup occupiedPlotGroup;

	private PopulationDensity populationDensity;

	private BuildingType buildingType;

	private Blueprint blueprint;

	private PersonGroup inhabitants;

	private List<Job> jobs;

	public Building(PlotGroup occupiedPlotGroup, PopulationDensity populationDensity, BuildingType buildingType,
			Blueprint blueprint) {
		super();
		this.occupiedPlotGroup = occupiedPlotGroup;
		this.populationDensity = populationDensity;
		this.buildingType = buildingType;
		this.blueprint = blueprint;
		this.jobs = createJobs(blueprint);
	}

	public PlotGroup getOccupiedPlotGroup() {
		return occupiedPlotGroup;
	}

	public PopulationDensity getPopulationDensity() {
		return populationDensity;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public Blueprint getBlueprint() {
		return blueprint;
	}

	public PersonGroup getInhabitants() {
		return inhabitants;
	}

	public List<Job> getJobs() {
		return jobs;
	}
	
	private List<Job> createJobs(Blueprint blueprint) {
		List<Job> jobs;
		return null;
	}

	

}
