package com.github.marceloleite2604.manager.business.calculator;

import java.util.Map;
import java.util.stream.Collectors;

import com.github.marceloleite2604.manager.model.Blueprint;
import com.github.marceloleite2604.manager.model.Building;
import com.github.marceloleite2604.manager.model.BuildingType;
import com.github.marceloleite2604.manager.model.Person;
import com.github.marceloleite2604.manager.model.PopulationDensity;
import com.github.marceloleite2604.manager.model.TaxRateKey;
import com.github.marceloleite2604.manager.model.job.Job;

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
