package com.stock.model.item;

import java.util.List;

public class Filters {

	private List<Filter> filters;

	public Filters(List<Filter> filters) {
		this.filters = filters;
	}

	Filters() {
		
	}
	
	public List<Filter> getList() {
		return filters;
	}
	
}
