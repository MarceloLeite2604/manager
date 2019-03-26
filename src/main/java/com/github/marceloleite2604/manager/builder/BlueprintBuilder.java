package com.github.marceloleite2604.manager.builder;

import java.util.EnumMap;
import java.util.Map;

import com.github.marceloleite2604.manager.business.validator.ObjectNotNullValidator;
import com.github.marceloleite2604.manager.business.validator.fordouble.DoubleGreaterThanZeroValidator;
import com.github.marceloleite2604.manager.business.validator.forinteger.IntegerGreaterThanZeroValidator;
import com.github.marceloleite2604.manager.model.Blueprint;
import com.github.marceloleite2604.manager.model.BlueprintName;
import com.github.marceloleite2604.manager.model.BuildingType;
import com.github.marceloleite2604.manager.model.Dimension;
import com.github.marceloleite2604.manager.model.PopulationDensity;
import com.github.marceloleite2604.manager.model.Resource;
import com.github.marceloleite2604.manager.model.SchoolingLevel;
import com.github.marceloleite2604.manager.model.Terrain;
import com.github.marceloleite2604.manager.model.job.JobOportunities;

public class BlueprintBuilder implements Builder<Blueprint> {

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

	public BlueprintBuilder() {
		buildingType = BuildingType.NONE;
		consumptions = new EnumMap<>(Resource.class);
		generations = new EnumMap<>(Resource.class);
		jobOportunities = new EnumMap<>(SchoolingLevel.class);
		maxInhabitants = 0;
		costToBuild = 0.0;
	}

	public BlueprintBuilder name(BlueprintName name) {
		new ObjectNotNullValidator("blueprint name").validate(name);

		this.name = name;

		return this;
	}

	public BlueprintBuilder ofBuildingType(BuildingType buildingType) {
		new ObjectNotNullValidator("building type").validate(buildingType);
		this.buildingType = buildingType;
		return this;
	}

	public BlueprintBuilder ofDimension(Dimension dimension) {
		new ObjectNotNullValidator("dimension").validate(dimension);
		this.dimension = dimension;
		return this;
	}

	public BlueprintBuilder forTerrain(Terrain terrain) {
		new ObjectNotNullValidator("terrain").validate(terrain);

		this.terrain = terrain;
		return this;
	}

	public BlueprintBuilder ofPopulationDensity(PopulationDensity populationDensity) {
		new ObjectNotNullValidator("population density").validate(populationDensity);

		this.populationDensity = populationDensity;
		return this;
	}

	public BlueprintBuilder consumes(Resource resource, Integer amount) {
		new ObjectNotNullValidator("resource").validate(resource);

		new IntegerGreaterThanZeroValidator("amount").validate(amount);

		consumptions.put(resource, amount);

		return this;
	}

	public BlueprintBuilder generates(Resource resource, Integer amount) {
		new ObjectNotNullValidator("resource").validate(resource);
		new IntegerGreaterThanZeroValidator("amount").validate(amount);

		generations.put(resource, amount);

		return this;
	}

	public BlueprintBuilder maxInhabitants(int maxInhabitants) {
		new IntegerGreaterThanZeroValidator("max inhabitants").validate(maxInhabitants);
		this.maxInhabitants = maxInhabitants;

		return this;
	}

	public BlueprintBuilder generatesJobs(SchoolingLevel schoolingLevel, int quantity, double payment) {
		new ObjectNotNullValidator("schooling level").validate(schoolingLevel);
		new IntegerGreaterThanZeroValidator("quantity").validate(quantity);
		new DoubleGreaterThanZeroValidator("payment").validate(payment);
		this.jobOportunities.put(schoolingLevel, new JobOportunities(quantity, schoolingLevel, payment));
		return this;
	}

	@Override
	public Blueprint build() {
		return new Blueprint(name, buildingType, dimension, terrain, populationDensity, consumptions, generations,
				maxInhabitants, jobOportunities, costToBuild);
	}

}
