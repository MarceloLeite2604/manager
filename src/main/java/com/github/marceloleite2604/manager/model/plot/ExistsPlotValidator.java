package com.github.marceloleite2604.manager.model.plot;

import java.text.MessageFormat;

import com.github.marceloleite2604.manager.business.validator.BinaryValidator;

public class ExistsPlotValidator implements BinaryValidator<PlotGroup, PlotGroup> {

	@Override
	public void validate(PlotGroup firstObject, PlotGroup secondObject) {
		if (firstObject.retrieveMinorPosition().compareTo(secondObject.retrieveMinorPosition()) < 0
				|| firstObject.retrieveMajorPosition().compareTo(secondObject.retrieveMajorPosition()) > 0) {
			String[] messageArguments = new String[] { firstObject.toString(), secondObject.toString() };
			throw new RuntimeException(
					new MessageFormat("Plot group {0} is not on plot group {1}.").format(messageArguments));
		}
	}
}
