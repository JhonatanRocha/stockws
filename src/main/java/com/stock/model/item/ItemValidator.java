package com.stock.model.item;

import java.util.ArrayList;
import java.util.List;

public class ItemValidator {

	private Item item;

	public ItemValidator(Item item) {
		this.item = item;
	}

	public void validate() {
		List<String> errors = new ArrayList<>();
		
		String sku = item.getSku();
		if(isEmpty(sku) || sku.length() != 3){
			errors.add("Invalid Sku");
		}

		String name = item.getName();
		if(isEmpty(name) || name.length() < 3){
			errors.add("Invalid Name");
		}
		
		int quantity = item.getQuantity();
		if(quantity <= 0){
			errors.add("Invalid Quantity");
		}
		
		String type = item.getType();
		if(isEmpty(type) || !ItemType.exists(type)) {
			errors.add("Invalid Type");
		}
		
		if(!errors.isEmpty()){
//			throw new RuntimeException("argg"); 
			throw new ItemValidatorException(errors); 
		}
	}

	private boolean isEmpty(String valor) {
		return valor == null || valor.isEmpty();
	}

}
