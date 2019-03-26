package com.github.marceloleite2604.manager.business.verifier;

import com.github.marceloleite2604.manager.model.Blueprint;
import com.github.marceloleite2604.manager.model.Budget;

public class BudgetBlueprintCostVerifier implements Verifier<Budget, Blueprint> {

	@Override
	public void verify(Budget budget, Blueprint blueprint) {
		if (budget.getBalance() < blueprint.getCostToBuild()) {
			throw new RuntimeException("Not enough balance to build " + blueprint.getName() + ".");
		}
	}

}
