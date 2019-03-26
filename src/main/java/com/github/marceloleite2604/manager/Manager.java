package com.github.marceloleite2604.manager;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import com.github.marceloleite2604.manager.builder.BudgetBuilder;
import com.github.marceloleite2604.manager.business.BudgetBO;
import com.github.marceloleite2604.manager.business.CityMapBO;
import com.github.marceloleite2604.manager.business.PersonGroupBO;
import com.github.marceloleite2604.manager.model.Blueprint;
import com.github.marceloleite2604.manager.model.BlueprintName;
import com.github.marceloleite2604.manager.model.Budget;
import com.github.marceloleite2604.manager.model.Building;
import com.github.marceloleite2604.manager.model.BuildingType;
import com.github.marceloleite2604.manager.model.CityMap;
import com.github.marceloleite2604.manager.model.Dimension;
import com.github.marceloleite2604.manager.model.Lot;
import com.github.marceloleite2604.manager.model.MapSize;
import com.github.marceloleite2604.manager.model.Person;
import com.github.marceloleite2604.manager.model.Position;
import com.github.marceloleite2604.manager.studio.BlueprintStudio;

public class Manager {

	private CityMap cityMap;

	private Map<BlueprintName, Blueprint> blueprints;

	private Budget budget;

	public Manager() {
		this.cityMap = createCityMap();
		this.budget = createBudget();
		this.blueprints = createBlueprints();
	}

	private CityMap createCityMap() {
		return new CityMap("city", MapSize.SMALL);
	}

	private Budget createBudget() {
		return new BudgetBuilder().withDefaultBalance().withDefaultTaxRate().build();
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

	public void createMap(String name, MapSize mapSize) {
		cityMap = new CityMap(name, mapSize);
	}

	public void createLot(Position position, Dimension dimension, BuildingType buildingType) {
		new CityMapBO().placeLotOnMap(cityMap, position, dimension, buildingType);
		System.out.println(cityMap.getLots().get(0).getPlotGroup().getDimension());
	}

	public void putBuildingOnLot(Lot lot, BlueprintName blueprintName) {
		Blueprint blueprint = blueprints.get(blueprintName);

		BudgetBO budgetBO = new BudgetBO();
		if (!budgetBO.hasBalanceFor(budget, blueprint.getCostToBuild())) {
			throw new RuntimeException("Not enough balance to build " + blueprint.getName() + ".");
		}

		budgetBO.discountFromBalance(budget, blueprint.getCostToBuild());
		Building building = new Building(blueprint);
		lot.setBuilding(building);
		new PlotGroupBO().occupy(lot.getPlotGroup());

	}

	public void putPersonOnResidence(Person person, Building building) {
		PersonGroupBO personGroupBO = new PersonGroupBO();
		if (personGroupBO.canAddPerson(building.getInhabitants())) {
			throw new RuntimeException("Cannot put person on residence. Max inhabitants reached.");
		}
		personGroupBO.addPerson(building.getInhabitants(), person);
	}
}
