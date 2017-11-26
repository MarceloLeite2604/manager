package org.marceloleite.manager.model;

public class Dimension extends java.awt.Dimension {

	private static final long serialVersionUID = 1L;

	public Dimension() {
		super();
	}

	public Dimension(java.awt.Dimension dimension) {
		super(dimension);
	}

	public Dimension(int width, int height) {
		super(width, height);
	}

	@Override
	public String toString() {
		return "[" + width + ", " + height + "]";
	}

}
