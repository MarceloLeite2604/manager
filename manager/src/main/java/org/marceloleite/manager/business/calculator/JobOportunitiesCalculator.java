package org.marceloleite.manager.business.calculator;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.marceloleite.manager.model.Building;
import org.marceloleite.manager.model.CityMap;
import org.marceloleite.manager.model.Lot;
import org.marceloleite.manager.model.SchoolingLevel;
import org.marceloleite.manager.model.job.Job;

public class JobOportunitiesCalculator implements Calculator {

	private CityMap cityMap;

	public JobOportunitiesCalculator(CityMap cityMap) {
		super();
		this.cityMap = cityMap;
	}

	@Override
	public double calculate() {

		List<Lot> occupiedLots = cityMap.getLots().stream().filter(lot -> lot.getPlotGroup().isOccupied()).collect(Collectors.toList());
		Stream<Map<SchoolingLevel, Job>> map = occupiedLots.stream().map(Lot::getBuilding).map(Building::getJobs);
		/*return occupiedLots.stream().map(Lot::getBuilding).map(Building::getJobs).map(Jobs::getJobsList)
				.flatMap(listJobs -> listJobs.stream()).filter(job -> job.getPerson() == null).count();*/
		return 0.0;
	}

}
