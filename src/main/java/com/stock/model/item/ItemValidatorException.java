package com.stock.model.item;

import java.util.List;

public class ItemValidatorException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ItemValidatorException(List<String> errors) {
		super(errors.toString());
	}
	
}
