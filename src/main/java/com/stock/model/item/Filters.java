package com.stock.model.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement()
@XmlAccessorType(XmlAccessType.FIELD)
public class Filters {

	@XmlElement(name="filter")
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
