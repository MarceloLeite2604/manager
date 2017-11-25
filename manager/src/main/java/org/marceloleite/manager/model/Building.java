package org.marceloleite.manager.model;

import java.util.List;
import java.util.Map;

import org.marceloleite.manager.model.job.Job;
import org.marceloleite.manager.model.job.JobsCreator;

public class Building {

	private Lot lot;

	private Blueprint blueprint;

	private PersonGroup inhabitants;

	private Map<SchoolingLevel, Job> jobs;

	public Building(Lot lot, PopulationDensity populationDensity, BuildingType buildingType, Blueprint blueprint) {
		super();
		this.lot = lot;
		this.blueprint = blueprint;
		this.jobs = new JobsCreator(blueprint).create();
	}

	public Lot getLot() {
		return lot;
	}

	public Blueprint getBlueprint() {
		return blueprint;
	}

	public PersonGroup getInhabitants() {
		return inhabitants;
	}

	public Map<SchoolingLevel, Job> getJobs() {
		return jobs;
	}

}
