package com.github.marceloleite2604.manager.studio;

import java.util.ArrayList;
import java.util.List;

import com.github.marceloleite2604.manager.builder.BlueprintBuilder;
import com.github.marceloleite2604.manager.model.Blueprint;
import com.github.marceloleite2604.manager.model.BlueprintName;
import com.github.marceloleite2604.manager.model.BuildingType;
import com.github.marceloleite2604.manager.model.PopulationDensity;
import com.github.marceloleite2604.manager.model.Resource;
import com.github.marceloleite2604.manager.model.SchoolingLevel;
import com.github.marceloleite2604.manager.model.Terrain;

public class BlueprintStudio implements Studio<Blueprint> {

	@Override
	public List<Blueprint> create() {
		List<Blueprint> blueprints = new ArrayList<>();

		blueprints.add(new BlueprintBuilder()
				.name(BlueprintName.TRAILER)
				.forTerrain(Terrain.LAND)
				.ofBuildingType(BuildingType.RESIDENTIAL)
				.ofPopulationDensity(PopulationDensity.SMALL)
				.consumes(Resource.ELECTRICITY, 10)
				.consumes(Resource.WATER, 20)
				.generates(Resource.POLUTION, 5)
				.maxInhabitants(4)
				.build());
		blueprints.add(new BlueprintBuilder()
				.name(BlueprintName.SMALL_STORE)
				.forTerrain(Terrain.LAND)
				.ofBuildingType(BuildingType.COMMERCIAL)
				.ofPopulationDensity(PopulationDensity.SMALL)
				.consumes(Resource.ELECTRICITY, 20)
				.consumes(Resource.WATER, 40)
				.generates(Resource.POLUTION, 15)
				.generatesJobs(SchoolingLevel.UNNEDUCATED, 4, 3)
				.generatesJobs(SchoolingLevel.ELEMENTARY, 1, 5)
				.build());
		return blueprints;
	}
}
