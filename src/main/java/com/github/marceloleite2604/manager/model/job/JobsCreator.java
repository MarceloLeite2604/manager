package com.github.marceloleite2604.manager.model.job;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;

import com.github.marceloleite2604.manager.model.Blueprint;
import com.github.marceloleite2604.manager.model.SchoolingLevel;

public class JobsCreator {

	private Blueprint blueprint;

	public JobsCreator(Blueprint blueprint) {
		super();
		this.blueprint = blueprint;
	}
	
	public Map<SchoolingLevel, Job> create() {
		Map<SchoolingLevel, Job> jobs = new EnumMap<>(SchoolingLevel.class);
		Map<SchoolingLevel, JobOportunities> jobOportunities = blueprint.getJobOportunities();
		Set<SchoolingLevel> schoolingLevels = jobOportunities.keySet();
		for (SchoolingLevel schoolingLevel : schoolingLevels) {
			jobs.put(schoolingLevel, new Job(jobOportunities.get(schoolingLevel)));
		}
		return jobs;
	}
}
