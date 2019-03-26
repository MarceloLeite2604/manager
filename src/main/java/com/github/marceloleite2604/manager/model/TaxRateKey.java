package com.github.marceloleite2604.manager.model;

public class TaxRateKey {

	private BuildingType buildingType;
	private PopulationDensity populationDensity;

	public TaxRateKey(BuildingType buildingType, PopulationDensity populationDensity) {
		super();
		this.buildingType = buildingType;
		this.populationDensity = populationDensity;
	}

	public BuildingType getBuildingType() {
		return buildingType;
	}

	public PopulationDensity getPopulationDensity() {
		return populationDensity;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((populationDensity == null) ? 0 : populationDensity.hashCode());
		result = prime * result + ((buildingType == null) ? 0 : buildingType.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TaxRateKey other = (TaxRateKey) obj;
		if (populationDensity != other.populationDensity)
			return false;
		if (buildingType != other.buildingType)
			return false;
		return true;
	}
}