package org.marceloleite.manager.business;

import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.CityMap;
import org.marceloleite.manager.model.Position;

public class CityMapBO {

	private CityMap cityMap;

	public CityMapBO(CityMap cityMap) {
		super();
		this.cityMap = cityMap;
	}

	public void placeBuilingOnMap(Blueprint blueprint, Position position) {
		cityMap.getPlotGroup().retrieveSubPlot(position, blueprint.getDimension());
		/* TODO: Concluir. */
	}
}
