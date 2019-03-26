package com.github.marceloleite2604.manager.model;

public enum Resource {

	MONEY("?$"), ELECTRICITY("kW/h"), WATER("l/day"), POLUTION("ppm"), LAND_VALUE("?$/m2");

	private String unitOfMeasure;

	private Resource(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}
}
