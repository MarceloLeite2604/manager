package org.marceloleite.manager.model;

import org.marceloleite.manager.model.Dimension;
import java.util.Map;

import org.marceloleite.manager.model.job.JobOportunities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Blueprint {

	private BlueprintName name;

	private BuildingType buildingType;

	private Dimension dimension;

	private Terrain terrain;

	private PopulationDensity populationDensity;

	private Map<Resource, Integer> consumptions;

	private Map<Resource, Integer> generations;

	private int maxInhabitants;

	private Map<SchoolingLevel, JobOportunities> jobOportunities;

	private double costToBuild;

	public Blueprint(BlueprintName name, BuildingType buildingType, Dimension dimension, Terrain terrain,
			PopulationDensity populationDensity, Map<Resource, Integer> consumptions,
			Map<Resource, Integer> generations, int maxInhabitants,
			Map<SchoolingLevel, JobOportunities> jobOportunities, double costToBuild) {
		super();
		this.name = name;
		this.buildingType = buildingType;
		this.terrain = terrain;
		this.populationDensity = populationDensity;
		this.consumptions = consumptions;
		this.generations = generations;
		this.maxInhabitants = maxInhabitants;
		this.jobOportunities = jobOportunities;
		this.costToBuild = costToBuild;
	}

	public BlueprintName getName() {
		return name;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public Terrain getTerrain() {
		return terrain;
	}

	public PopulationDensity getPopulationDensity() {
		return populationDensity;
	}

	public Map<Resource, Integer> getConsumptions() {
		return consumptions;
	}

	public Map<Resource, Integer> getGenerations() {
		return generations;
	}

	public int getMaxInhabitants() {
		return maxInhabitants;
	}

	public Map<SchoolingLevel, JobOportunities> getJobOportunities() {
		return jobOportunities;
	}

	public Dimension getDimension() {
		return dimension;
	}

	public double getCostToBuild() {
		return costToBuild;
	}

	@Override
	public String toString() {
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
