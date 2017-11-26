package org.marceloleite.manager.model;

import java.util.ArrayList;
import java.util.List;

import org.marceloleite.manager.model.plot.PlotGroup;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CityMap {

	private String name;

	private MapSize mapSize;

	private PlotGroup plotGroup;

	private List<Lot> lots;

	public CityMap(String name, MapSize mapSize) {
		super();
		this.name = name;
		this.mapSize = mapSize;
		this.plotGroup = new PlotGroup(new Position(0, 0), mapSize.getDimension());
		this.lots = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public PlotGroup getPlotGroup() {
		return plotGroup;
	}

	public MapSize getMapSize() {
		return mapSize;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		try {
			return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(this);
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Lot> getLots() {
		return lots;
	}
}
