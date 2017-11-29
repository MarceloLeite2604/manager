package org.marceloleite.manager.business.filter;

import java.util.List;

public interface Filter<T extends Object> {

	List<T> filter();
}
