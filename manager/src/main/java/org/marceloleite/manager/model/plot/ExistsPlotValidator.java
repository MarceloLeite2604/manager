package org.marceloleite.manager.model.plot;

import java.text.MessageFormat;

import org.marceloleite.manager.validator.BinaryValidator;

public class ExistsPlotValidator implements BinaryValidator<PlotGroup, PlotGroup> {

	String[] args;

	public ExistsPlotValidator(String... args) {
		super();
		this.args = args;
	}

	@Override
	public void validate(PlotGroup firstObject, PlotGroup secondObject) {
		if (firstObject.retrieveMinorPosition().compareTo(secondObject.retrieveMinorPosition()) < 0
				|| firstObject.retrieveMajorPosition().compareTo(secondObject.retrieveMajorPosition()) < 0) {
			throw new IllegalArgumentException(
					new MessageFormat("Plot group {0} is not on plot group {1}.").format(args));
		}
	}
}
