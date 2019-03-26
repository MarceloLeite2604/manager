/**
 * 
 */
package com.github.marceloleite2604.manager;

import com.github.marceloleite2604.manager.model.plot.PlotGroup;

public class PlotGroupBO {

	public void occupy(PlotGroup plotGroup) {
		plotGroup.getPlots().values().forEach(plot -> plot.setOccupied(true));
	}
}
