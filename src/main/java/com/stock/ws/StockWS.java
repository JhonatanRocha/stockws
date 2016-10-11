package com.stock.ws;

import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

import com.stock.model.item.Filters;
import com.stock.model.item.Item;
import com.stock.model.item.ItemDao;
import com.stock.model.item.ItemValidator;
import com.stock.model.user.TokenDao;
import com.stock.model.user.TokenUser;
import com.stock.util.AuthorizationException;

@WebService
public class StockWS {

	private ItemDao itemDao = new ItemDao();

	/*
	 * @WebMethod(operationName="allItems")
	 * @ResponseWrapper(localName="items")
	 * @WebResult(name="item")
	 * @RequestWrapper(localName="listItems") public List<Item> getItems() {
	 * System.out.println("Calling get Items method"); return
	 * itemDao.allItens(); }
	 */

	// Utilizando com filtros
	@WebMethod(operationName = "AllItems")
	@ResponseWrapper(localName = "items")
	@WebResult(name = "item")
	@RequestWrapper(localName = "listItems")
	public List<Item> getItems(@WebParam(name = "filters") Filters filters) {
		System.out.println("Calling getItems() method");
		return itemDao.allItens(filters.getList());
	}

	@WebMethod(operationName = "RegisterItem")
	@WebResult(name = "item")
	public Item registerItem(@WebParam(name = "userToken", header = true) TokenUser token,
			@WebParam(name = "item") Item item) throws AuthorizationException {
		System.out.println("Token: " + token + " | Registering item: " + item);

		boolean isValid = new TokenDao().isValid(token);

		if (!isValid)
			//cheked exception
			throw new AuthorizationException("Authorization failed.");
		
		new ItemValidator(item).validate();

		this.itemDao.register(item);
		return item;
	}
}
