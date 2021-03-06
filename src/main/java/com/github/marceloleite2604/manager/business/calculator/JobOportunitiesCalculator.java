package com.github.marceloleite2604.manager.business.calculator;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.marceloleite2604.manager.business.filter.OccupiedLotsFilter;
import com.github.marceloleite2604.manager.model.CityMap;
import com.github.marceloleite2604.manager.model.Lot;

public class JobOportunitiesCalculator implements Calculator {

	private CityMap cityMap;

	public JobOportunitiesCalculator(CityMap cityMap) {
		super();
		this.cityMap = cityMap;
	}

	@Override
	public double calculate() {

		
		List<Lot> occupiedLots = new OccupiedLotsFilter(cityMap).filter();
		
		return occupiedLots.stream().map(lot -> lot.getBuilding().getJobs()).flatMap(jobsMap -> jobsMap.entrySet().stream())
				.map(entry -> entry.getValue().getPersonGroup().getPersons()).flatMap(map -> map.entrySet().stream())
				.map(Map.Entry::getValue).filter(Objects::isNull).count();
	}

}
