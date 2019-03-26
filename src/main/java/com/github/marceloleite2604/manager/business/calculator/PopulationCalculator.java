package com.github.marceloleite2604.manager.business.calculator;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import com.github.marceloleite2604.manager.business.filter.OccupiedLotsFilter;
import com.github.marceloleite2604.manager.model.CityMap;
import com.github.marceloleite2604.manager.model.Lot;

public class PopulationCalculator implements Calculator {

	private CityMap cityMap;

	public PopulationCalculator(CityMap cityMap) {
		super();
		this.cityMap = cityMap;
	}

	@Override
	public double calculate() {
		List<Lot> occupiedLots = new OccupiedLotsFilter(cityMap).filter();
		return occupiedLots.stream().map(lot -> lot.getBuilding().getInhabitants().getPersons())
				.flatMap(personsMap -> personsMap.entrySet().stream()).map(Map.Entry::getValue)
				.filter(Objects::nonNull).count();
	}
}
