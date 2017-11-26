package org.marceloleite.manager.business;

import org.marceloleite.manager.business.verifier.LotBuildingVerifier;
import org.marceloleite.manager.model.Building;
import org.marceloleite.manager.model.Lot;

public class LotBO {

	public void placeBuilingOnLot(Lot lot, Building building) {
		new LotBuildingVerifier().verify(lot, building);
		lot.setBuilding(building);
	}
}
