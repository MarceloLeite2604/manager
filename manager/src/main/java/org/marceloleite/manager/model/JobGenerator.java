package org.marceloleite.manager.model;

public class JobGenerator {

	private int quantity;

	private SchoolingLevel schoolingLevel;

	private double payment;

	public JobGenerator(int quantity, SchoolingLevel schoolingLevel, double payment) {
		super();
		this.quantity = quantity;
		this.schoolingLevel = schoolingLevel;
		this.payment = payment;
	}

	public int getAmount() {
		return quantity;
	}

	public SchoolingLevel getSchoolingLevel() {
		return schoolingLevel;
	}

	public double getPayment() {
		return payment;
	}
}
