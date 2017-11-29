package org.marceloleite.manager;

import org.marceloleite.manager.business.generator.PersonGenerator;
import org.marceloleite.manager.model.BlueprintName;
import org.marceloleite.manager.model.BuildingType;
import org.marceloleite.manager.model.Dimension;
import org.marceloleite.manager.model.Lot;
import org.marceloleite.manager.model.MapSize;
import org.marceloleite.manager.model.Position;
import org.marceloleite.manager.util.JsonFormatter;

public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.createMap("My city", MapSize.SMALL);
		manager.createLot(new Position(0, 0), new Dimension(2, 2), BuildingType.RESIDENTIAL);
		
		Lot lot = manager.getCityMap().getLots().get(0);
		manager.putBuildingOnLot(lot, BlueprintName.TRAILER);
		
		manager.putPersonOnResidence(new PersonGenerator().generate(), lot.getBuilding());
		System.out.println(new JsonFormatter().format(lot));
	}
}
