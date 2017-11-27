package org.marceloleite.manager.builder;

import java.util.HashMap;
import java.util.Map;

import org.marceloleite.manager.model.Budget;
import org.marceloleite.manager.model.BuildingType;
import org.marceloleite.manager.model.PopulationDensity;
import org.marceloleite.manager.model.TaxRateKey;
import org.marceloleite.manager.util.configuration.Configuration;
import org.marceloleite.manager.util.configuration.Property;

public class BudgetBuilder implements Builder<Budget> {

	Double treasure;

	Map<TaxRateKey, Double> taxRates;

	public BudgetBuilder withTaxRate(Double startingTaxRate) {
		taxRates = createTaxRates(startingTaxRate);
		return this;
	}

	public BudgetBuilder withDefaultTaxRate() {
		taxRates = createDefaultTaxRates();
		return this;
	}

	private Map<TaxRateKey, Double> createDefaultTaxRates() {
		Double defaultStartTaxRate = Double
				.valueOf(Configuration.getInstance().getConfiguration(Property.DEFAULT_TAX_RATE_START_VALUE));
		return createTaxRates(defaultStartTaxRate);
	}

	private Double createDefaultTreasure() {
		return Double.valueOf(Configuration.getInstance().getConfiguration(Property.DEFAULT_TREASURE_START_VALUE));
	}

	private static Map<TaxRateKey, Double> createTaxRates(Double taxRate) {
		Map<TaxRateKey, Double> taxRates = new HashMap<>();
		for (BuildingType lotType : BuildingType.values()) {
			for (PopulationDensity lotDensity : PopulationDensity.values()) {
				taxRates.put(new TaxRateKey(lotType, lotDensity), taxRate);
			}
		}
		return taxRates;
	}

	public BudgetBuilder withBalance(double treasure) {
		this.treasure = treasure;
		return this;
	}

	public BudgetBuilder withDefaultBalance() {
		this.treasure = createDefaultTreasure();
		return this;
	}

	@Override
	public Budget build() {
		if (taxRates == null) {
			taxRates = createDefaultTaxRates();
		}

		if (treasure == null) {
			treasure = createDefaultTreasure();
		}
		return new Budget(treasure, taxRates);
	}
}
