package org.marceloleite.manager.business.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.marceloleite.management.budget.TaxRateKey;
import org.marceloleite.management.building.Building;
import org.marceloleite.management.job.Job;
import org.marceloleite.management.job.JobOportunity;
import org.marceloleite.management.lot.PopulationDensity;
import org.marceloleite.management.lot.LotType;
import org.marceloleite.management.person.Person;

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
		LotType buildingLotType = building.getBuildingType().getLotTypeRequired();
		PopulationDensity buildingLotDensity = building.getBuildingType().getLotDensityRequired();
		Double taxRate = taxRates.get(new TaxRateKey(buildingLotType, buildingLotDensity));

		List<Person> persons = building.getInhabitants().getPersons();
		Double totalPayments = persons.stream().filter(Person::isEmployed).map(Person::getJob)
				.map(Job::getJobOportunity).collect(Collectors.summingDouble(JobOportunity::getPayment));

		return totalPayments * taxRate;
	}

	@Override
	public LotType forLotType() {
		return LotType.COMMERCIAL;
	}
}
