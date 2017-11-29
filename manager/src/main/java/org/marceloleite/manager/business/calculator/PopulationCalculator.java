package org.marceloleite.manager.business.calculator;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.marceloleite.manager.business.filter.OccupiedLotsFilter;
import org.marceloleite.manager.model.CityMap;
import org.marceloleite.manager.model.Lot;

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
