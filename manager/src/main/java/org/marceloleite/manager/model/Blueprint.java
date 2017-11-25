package org.marceloleite.manager.model;

import java.awt.Dimension;
import java.util.Map;

import org.marceloleite.manager.model.job.JobOportunities;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Blueprint {

	private BlueprintName name;

	private Dimension dimension;

	private Terrain terrain;

	private PopulationDensity populationDensity;

	private Map<Resource, Integer> consumptions;

	private Map<Resource, Integer> generations;

	private int maxInhabitants;

	private Map<SchoolingLevel, JobOportunities> jobOportunities;

	public Blueprint(BlueprintName name, Dimension dimension, Terrain terrain, PopulationDensity populationDensity,
			Map<Resource, Integer> consumptions, Map<Resource, Integer> generations, int maxInhabitants,
			Map<SchoolingLevel, JobOportunities> jobOportunities) {
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

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
}
