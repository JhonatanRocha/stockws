package com.stock.ws;

import java.util.List;

import javax.jws.WebService;

import com.stock.model.item.Item;
import com.stock.model.item.ItemDao;

@WebService
public class StockWS {

	private ItemDao itemDao = new ItemDao();

	public List<Item> getItems() {
		System.out.println("Calling get Items method");
		return itemDao.allItens();
	}
}
