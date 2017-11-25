package org.marceloleite.manager.builder;

import java.util.EnumMap;
import java.util.Map;

import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.BlueprintName;
import org.marceloleite.manager.model.JobGenerator;
import org.marceloleite.manager.model.PopulationDensity;
import org.marceloleite.manager.model.Resource;
import org.marceloleite.manager.model.SchoolingLevel;
import org.marceloleite.manager.model.Terrain;
import org.marceloleite.manager.validator.ObjectNotNullValidator;
import org.marceloleite.manager.validator.fordouble.DoubleGreaterThanZeroValidator;
import org.marceloleite.manager.validator.forinteger.IntegerGreaterThanZeroValidator;

public class BlueprintBuilder implements Builder<Blueprint> {

	private BlueprintName name;

	private Terrain terrain;

	private PopulationDensity populationDensity;

	private Map<Resource, Integer> consumptions;

	private Map<Resource, Integer> generations;

	private int maxInhabitants;

	private Map<SchoolingLevel, JobGenerator> jobOportunities;

	public BlueprintBuilder() {
		consumptions = new EnumMap<>(Resource.class);
		generations = new EnumMap<>(Resource.class);
		jobOportunities = new EnumMap<>(SchoolingLevel.class);
		maxInhabitants = 0;
	}

	public BlueprintBuilder name(BlueprintName name) {
		new ObjectNotNullValidator("blueprint name").validate(name);

		this.name = name;

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
		this.jobOportunities.put(schoolingLevel, new JobGenerator(quantity, schoolingLevel, payment));
		return this;
	}

	@Override
	public Blueprint build() {
		return new Blueprint(name, terrain, populationDensity, consumptions, generations, maxInhabitants,
				jobOportunities);
	}

}
