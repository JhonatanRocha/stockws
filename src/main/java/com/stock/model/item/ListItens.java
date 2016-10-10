package com.stock.model.item;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ListItens {

	@XmlElement(name="item")
	private List<Item> itens;

	public ListItens(List<Item> itens) {
		this.itens = itens;
	}

	ListItens() {
	}
	
	public List<Item> getItens() {
		return itens;
	}
	
}
