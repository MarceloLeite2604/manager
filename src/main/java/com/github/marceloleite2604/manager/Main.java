package com.github.marceloleite2604.manager;

import com.github.marceloleite2604.manager.business.generator.PersonGenerator;
import com.github.marceloleite2604.manager.model.BlueprintName;
import com.github.marceloleite2604.manager.model.BuildingType;
import com.github.marceloleite2604.manager.model.Dimension;
import com.github.marceloleite2604.manager.model.Lot;
import com.github.marceloleite2604.manager.model.MapSize;
import com.github.marceloleite2604.manager.model.Position;
import com.github.marceloleite2604.manager.util.JsonFormatter;

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
