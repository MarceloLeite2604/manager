/**
 * 
 */
package org.marceloleite.manager;

import org.marceloleite.manager.model.plot.PlotGroup;

public class PlotGroupBO {

	public void occupy(PlotGroup plotGroup) {
		plotGroup.getPlots().values().forEach(plot -> plot.setOccupied(true));
	}
}
