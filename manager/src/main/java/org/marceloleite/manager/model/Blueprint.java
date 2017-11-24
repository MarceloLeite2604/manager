package org.marceloleite.manager.model;

import java.util.Map;

public class Blueprint {

	private BlueprintName name;

	private Terrain terrain;

	private PopulationDensity populationDensity;

	private Map<ResourceType, Integer> consumptions;

	private Map<ResourceType, Integer> generations;

	private int maxInhabitants;

	private Map<SchoolingLevel, JobGenerator> jobOportunities;

	public Blueprint(BlueprintName name, Terrain terrain, PopulationDensity populationDensity,
			Map<ResourceType, Integer> consumptions, Map<ResourceType, Integer> generations, int maxInhabitants,
			Map<SchoolingLevel, JobGenerator> jobOportunities) {
		super();
		this.name = name;
		this.terrain = terrain;
		this.populationDensity = populationDensity;
		this.consumptions = consumptions;
		this.generations = generations;
		this.maxInhabitants = maxInhabitants;
		this.jobOportunities = jobOportunities;
	}

	public BlueprintName getName() {
		return name;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public PopulationDensity getPopulationDensity() {
		return populationDensity;
	}

	public Map<ResourceType, Integer> getConsumptions() {
		return consumptions;
	}

	public Map<ResourceType, Integer> getGenerations() {
		return generations;
	}

	public int getMaxInhabitants() {
		return maxInhabitants;
	}

	public Map<SchoolingLevel, JobGenerator> getJobOportunities() {
		return jobOportunities;
	}
}
