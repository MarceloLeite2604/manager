package org.marceloleite.manager.studio;

import java.util.ArrayList;
import java.util.List;

import org.marceloleite.manager.builder.BlueprintBuilder;
import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.BlueprintName;
import org.marceloleite.manager.model.PopulationDensity;
import org.marceloleite.manager.model.Resource;
import org.marceloleite.manager.model.SchoolingLevel;
import org.marceloleite.manager.model.Terrain;

public class BlueprintStudio implements Studio<Blueprint> {

	@Override
	public List<Blueprint> create() {
		List<Blueprint> blueprints = new ArrayList<>();

		blueprints.add(new BlueprintBuilder()
				.name(BlueprintName.TRAILER)
				.forTerrain(Terrain.LAND)
				.ofPopulationDensity(PopulationDensity.SMALL)
				.consumes(Resource.ELECTRICITY, 10)
				.consumes(Resource.WATER, 20)
				.generates(Resource.POLUTION, 5)
				.maxInhabitants(4)
				.build());
		blueprints.add(new BlueprintBuilder()
				.name(BlueprintName.SMALL_STORE)
				.forTerrain(Terrain.LAND)
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
