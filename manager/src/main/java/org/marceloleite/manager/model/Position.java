package org.marceloleite.manager.model;

import java.io.Serializable;

public class Position implements Serializable, Comparable<Position> {

	private static final long serialVersionUID = 1L;

	private int x;
	private int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + x;
		result = prime * result + y;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Position other = (Position) obj;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}
}
