package org.marceloleite.manager.business;

import org.marceloleite.manager.model.BuildingType;
import org.marceloleite.manager.model.CityMap;
import org.marceloleite.manager.model.Dimension;
import org.marceloleite.manager.model.Lot;
import org.marceloleite.manager.model.Position;
import org.marceloleite.manager.model.plot.PlotGroup;

public class CityMapBO {

	public void placeLotOnMap(CityMap cityMap, Position position, Dimension dimension, BuildingType buildingType) {
		PlotGroup subPlot = cityMap.getPlotGroup().retrieveSubPlot(position, dimension);
		if (subPlot.isOccupied()) {
			throw new RuntimeException("Plot " + subPlot + " is occupied.");
		}

		cityMap.getLots().add(new Lot(subPlot, buildingType));
	}
}
