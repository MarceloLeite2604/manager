package com.github.marceloleite2604.manager.business.filter;

import java.util.List;

public interface Filter<T extends Object> {

	List<T> filter();
}
