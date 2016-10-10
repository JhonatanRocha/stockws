package com.stock.model.item;

import javax.xml.bind.annotation.XmlEnumValue;

public enum ItemType {

	@XmlEnumValue("Book")
	BOOK("Book"), 
	@XmlEnumValue("Cellphone")
	CELLPHONE("Cellphone"),
	@XmlEnumValue("Tablet")
	TABLET("Tablet");
	
	private String name;

	ItemType(String name) { 
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public static boolean exists(String value) {
		try{
			//joga IllegalArgumentException caso nao exista
			ItemType.valueOf(value.toUpperCase());
		}catch(IllegalArgumentException e) {
			return false;
		}
		return true;
	}
}
