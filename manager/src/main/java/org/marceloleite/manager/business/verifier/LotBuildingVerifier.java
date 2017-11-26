package org.marceloleite.manager.business.verifier;

import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.Building;
import org.marceloleite.manager.model.Lot;

public class LotBuildingVerifier implements Verifier<Lot, Building> {

	@Override
	public void verify(Lot lot, Building building) {
		Blueprint blueprint = building.getBlueprint();
		if (lot.getBuildingType() != blueprint.getBuildingType()) {
			throw new RuntimeException("Building " + blueprint.getName() + " is of type " + blueprint.getBuildingType()
					+ ". The lot " + lot + " requires a building of type " + lot.getBuildingType());
		}
	}

}
