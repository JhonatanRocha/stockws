package com.stock.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.stock.model.item.Item;
import com.stock.model.item.ItemDao;

@WebService
public class StockWS {

	private ItemDao itemDao = new ItemDao();
	
	@WebMethod(operationName="allItems")
    @ResponseWrapper(localName="items")
	@WebResult(name="item")
	@RequestWrapper(localName="listItems")
	public List<Item> getItems() {
		System.out.println("Calling get Items method");
		return itemDao.allItens();
	}
	
	//Utilizando com filtros
	/*@WebMethod(operationName="allItems")
    @ResponseWrapper(localName="items")
	@WebResult(name="item")
	public List<Item> getItems(@WebParam(name="filters") Filters filters) {
		System.out.println("Calling getItems() method");
		return itemDao.allItens(filters.getList());
	}*/
}
