package com.github.marceloleite2604.manager.model.job;

import com.github.marceloleite2604.manager.model.SchoolingLevel;

public class JobOportunities {

	private int quantity;

	private SchoolingLevel schoolingLevel;

	private double payment;

	public JobOportunities(int quantity, SchoolingLevel schoolingLevel, double payment) {
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
