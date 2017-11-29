package org.marceloleite.manager.business.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.Building;
import org.marceloleite.manager.model.BuildingType;
import org.marceloleite.manager.model.Person;
import org.marceloleite.manager.model.PopulationDensity;
import org.marceloleite.manager.model.TaxRateKey;
import org.marceloleite.manager.model.job.Job;

public class CommercialBuildingTaxRevenueCalculator implements BuildingTaxRevenueCalculator {

	private Building building;

	private Map<TaxRateKey, Double> taxRates;

	public CommercialBuildingTaxRevenueCalculator(Building building, Map<TaxRateKey, Double> taxRates) {
		super();
		this.building = building;
		this.taxRates = taxRates;
	}

	@Override
	public double calculate() {

		Blueprint blueprint = building.getBlueprint();
		BuildingType buildingType = blueprint.getBuildingType();
		PopulationDensity populationDensity = blueprint.getPopulationDensity();
		Double taxRate = taxRates.get(new TaxRateKey(buildingType, populationDensity));

		Map<Long, Person> persons = building.getInhabitants().getPersons();
		Double totalPayments = persons.values().stream().filter(Person::isEmployed).map(Person::getJob)
				.collect(Collectors.summingDouble(Job::getPayment));

		return totalPayments * taxRate;
	}

	@Override
	public BuildingType forBuildingType() {
		return BuildingType.COMMERCIAL;
	}

}
