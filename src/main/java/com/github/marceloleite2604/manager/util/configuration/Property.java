package com.github.marceloleite2604.manager.util.configuration;

public enum Property {

	DEFAULT_TAX_RATE_START_VALUE("budget.taxRate"),
	DEFAULT_TREASURE_START_VALUE("budget.treasure"),
	DEFAULT_CITY_MAP_SIZE("cityMap.size");

	private String name;

	private Property(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}
