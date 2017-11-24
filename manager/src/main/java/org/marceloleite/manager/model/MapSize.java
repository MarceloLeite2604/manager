package org.marceloleite.manager.model;

import java.awt.Dimension;

public enum MapSize {
	SMALL(25, 25), MEDIUM(50, 50), LARGE(75, 75);

	private Dimension dimension;

	private MapSize(int width, int height) {
		this.dimension = new Dimension(width, height);
	}

	public Dimension getDimension() {
		return dimension;
	}
}
