package com.github.marceloleite2604.manager.business;

import com.github.marceloleite2604.manager.business.verifier.LotBuildingVerifier;
import com.github.marceloleite2604.manager.model.Building;
import com.github.marceloleite2604.manager.model.Lot;

public class LotBO {

	public void placeBuilingOnLot(Lot lot, Building building) {
		new LotBuildingVerifier().verify(lot, building);
		lot.setBuilding(building);
	}
}
