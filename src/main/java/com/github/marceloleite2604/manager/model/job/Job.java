package com.github.marceloleite2604.manager.model.job;

import com.github.marceloleite2604.manager.model.PersonGroup;
import com.github.marceloleite2604.manager.model.SchoolingLevel;

public class Job {

	private SchoolingLevel requiredSchoolingLevel;

	private double payment;

	private int maxEmployees;

	private PersonGroup employees;

	public Job(SchoolingLevel requiredSchoolingLevel, double payment, int maxEmployees) {
		super();
		this.requiredSchoolingLevel = requiredSchoolingLevel;
		this.payment = payment;
		this.maxEmployees = maxEmployees;
		this.employees = new PersonGroup(maxEmployees);
	}

	public Job(JobOportunities jobOportunities) {
		this(jobOportunities.getSchoolingLevel(), jobOportunities.getPayment(), jobOportunities.getAmount());
	}

	public SchoolingLevel getRequiredSchoolingLevel() {
		return requiredSchoolingLevel;
	}

	public double getPayment() {
		return payment;
	}

	public int getMaxEmployees() {
		return maxEmployees;
	}

	public PersonGroup getPersonGroup() {
		return employees;
	}

}
