package org.marceloleite.manager;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.BlueprintName;
import org.marceloleite.manager.model.CityMap;
import org.marceloleite.manager.model.MapSize;
import org.marceloleite.manager.studio.BlueprintStudio;

public class Manager {

	private CityMap cityMap;

	private Map<BlueprintName, Blueprint> blueprints;

	public Manager() {
		this.cityMap = createCityMap();
		this.blueprints = createBlueprints();
	}

	private CityMap createCityMap() {
		return new CityMap("city", MapSize.SMALL);
	}

	private Map<BlueprintName, Blueprint> createBlueprints() {
		List<Blueprint> blueprints = new BlueprintStudio().create();

		Map<BlueprintName, Blueprint> blueprintsMap = new EnumMap<>(BlueprintName.class);
		for (Blueprint blueprint : blueprints) {
			blueprintsMap.put(blueprint.getName(), blueprint);
		}
		return blueprintsMap;
	}

	public CityMap getCityMap() {
		return cityMap;
	}

	public Map<BlueprintName, Blueprint> getBlueprints() {
		return blueprints;
	}
}
