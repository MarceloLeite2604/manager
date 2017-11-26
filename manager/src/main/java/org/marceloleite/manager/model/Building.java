package org.marceloleite.manager.model;

import java.util.Map;

import org.marceloleite.manager.model.job.Job;
import org.marceloleite.manager.model.job.JobsCreator;

public class Building {

	private Blueprint blueprint;

	private PersonGroup inhabitants;

	private Map<SchoolingLevel, Job> jobs;

	public Building(Blueprint blueprint) {
		super();
		this.blueprint = blueprint;
		this.jobs = new JobsCreator(blueprint).create();
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
