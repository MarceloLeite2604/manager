package org.marceloleite.manager.model;

import java.util.Map;

public class Budget {

	private double balance;

	private Map<TaxRateKey, Double> taxRates;

	public Budget(double balance, Map<TaxRateKey, Double> taxRates) {
		super();
		this.balance = balance;
		this.taxRates = taxRates;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public Map<TaxRateKey, Double> getTaxRates() {
		return taxRates;
	}
}
