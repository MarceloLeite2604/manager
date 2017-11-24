package org.marceloleite.manager.model;

public class JobGenerator {

	private int amount;

	private SchoolingLevel schoolingLevel;

	private double payment;

	public JobGenerator(int amount, SchoolingLevel schoolingLevel, double payment) {
		super();
		this.amount = amount;
		this.schoolingLevel = schoolingLevel;
		this.payment = payment;
	}

	public int getAmount() {
		return amount;
	}

	public SchoolingLevel getSchoolingLevel() {
		return schoolingLevel;
	}

	public double getPayment() {
		return payment;
	}
}
