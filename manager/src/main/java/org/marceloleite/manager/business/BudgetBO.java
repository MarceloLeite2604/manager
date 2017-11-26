package org.marceloleite.manager.business;

import org.marceloleite.manager.model.Budget;

public class BudgetBO {

	public boolean hasBalanceFor(Budget budget, double value) {
		return ((budget.getBalance() - value) > 0);
	}

	public void discountFromBalance(Budget budget, double value) {
		if (!hasBalanceFor(budget, value)) {
			throw new RuntimeException("Not enough balance to discount " + value + ".");
		}
		budget.setBalance(budget.getBalance() - value);
	}

}
