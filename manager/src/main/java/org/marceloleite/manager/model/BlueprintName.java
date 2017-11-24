package org.marceloleite.manager.model;

public enum BlueprintName {

	TRAILER("Trailer"),
	SMALL_STORE("Small store"),
	GARAGE("Garage"),
	WATER_TOWER("Water tower"),
	WIND_TURBINE("Wind turbine");

	private String name;

	private BlueprintName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
