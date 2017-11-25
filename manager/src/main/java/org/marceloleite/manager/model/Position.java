package org.marceloleite.manager.model;

import java.awt.Point;

public class Position extends Point implements Comparable<Position> {

	private static final long serialVersionUID = 1L;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int compareX(Position other) {
		return Integer.compare(this.x, other.x);
	}

	private int compareY(Position other) {
		return Integer.compare(this.y, other.y);
	}

	@Override
	public int compareTo(Position other) {
		int compareXresult = compareX(other);
		if (compareXresult < 0) {
			return -1;
		} else {
			if (compareXresult > 0) {
				return 1;
			} else {
				int compareYresult = compareY(other);
				if (compareYresult < 0) {
					return -1;
				} else {
					if (compareYresult > 0) {
						return 1;
					} else {
						return 0;
					}
				}
			}
		}
	}

	@Override
	public String toString() {
		return "[" + x + ", " + y + "]";
	}

}
