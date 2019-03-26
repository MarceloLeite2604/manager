package com.github.marceloleite2604.manager.model;

import java.util.Map;

import com.github.marceloleite2604.manager.model.job.Job;
import com.github.marceloleite2604.manager.model.job.JobsCreator;

public class Building {

	private Blueprint blueprint;

	private PersonGroup inhabitants;

	private Map<SchoolingLevel, Job> jobs;

	public Building(Blueprint blueprint) {
		super();
		this.blueprint = blueprint;
		this.jobs = new JobsCreator(blueprint).create();
		this.inhabitants = new PersonGroup(blueprint.getMaxInhabitants());
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
