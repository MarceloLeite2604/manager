package com.github.marceloleite2604.manager.business;

import com.github.marceloleite2604.manager.model.BuildingType;
import com.github.marceloleite2604.manager.model.CityMap;
import com.github.marceloleite2604.manager.model.Dimension;
import com.github.marceloleite2604.manager.model.Lot;
import com.github.marceloleite2604.manager.model.Position;
import com.github.marceloleite2604.manager.model.plot.PlotGroup;

public class CityMapBO {

	public void placeLotOnMap(CityMap cityMap, Position position, Dimension dimension, BuildingType buildingType) {
		PlotGroup subPlot = cityMap.getPlotGroup().retrieveSubPlot(position, dimension);
		if (subPlot.isOccupied()) {
			throw new RuntimeException("Plot " + subPlot + " is occupied.");
		}

		cityMap.getLots().add(new Lot(subPlot, buildingType));
	}
}
