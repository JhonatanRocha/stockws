package com.stock.model.item;

import java.util.List;

public class ListItens {

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
