package org.marceloleite.manager.business.filter;

import java.util.List;
import java.util.stream.Collectors;

import org.marceloleite.manager.model.CityMap;
import org.marceloleite.manager.model.Lot;

public class OccupiedLotsFilter implements Filter<Lot> {

	private CityMap cityMap;

	public OccupiedLotsFilter(CityMap cityMap) {
		super();
		this.cityMap = cityMap;
	}

	@Override
	public List<Lot> filter() {
		return cityMap.getLots().stream().filter(lot -> lot.getPlotGroup().isOccupied())
				.collect(Collectors.toList());
	}

}
