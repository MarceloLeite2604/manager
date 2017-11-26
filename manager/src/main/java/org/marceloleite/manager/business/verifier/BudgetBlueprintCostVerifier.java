package org.marceloleite.manager.business.verifier;

import org.marceloleite.manager.model.Blueprint;
import org.marceloleite.manager.model.Budget;

public class BudgetBlueprintCostVerifier implements Verifier<Budget, Blueprint> {

	@Override
	public void verify(Budget budget, Blueprint blueprint) {
		if (budget.getBalance() < blueprint.getCostToBuild()) {
			throw new RuntimeException("Not enough balance to build " + blueprint.getName() + ".");
		}
	}

}
