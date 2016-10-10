package com.stock.model.item;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class ItemDao {

	private static Map<String, Item> ITENS = new LinkedHashMap<>();

	public ItemDao() {
		populateItensOnMap();
	}
	
	public void cadastrar(Item item) {
		ITENS.put(item.getSku(), item);
	}

	public ArrayList<Item> allItens(List<Filter> filters) {
		
		ArrayList<Item> results = new ArrayList<Item>();
		Collection<Item> allItens = ITENS.values();

		if (filters == null || filters.isEmpty()) {
			results.addAll(allItens);
			return results;
		}
		
		for(Filter filter : filters) {
			for (Item item : allItens) {
				
				String type = filter.getType().getName();
				String name = filter.getName();
				
				if(itemHasType(item, type) && itemHasName(item, name)){
					results.add(item);
				}
			}
		}
		return results;
	}

	//este método existe apenas para facilitar o primeiro exercicio que não usa o filtro
	public ArrayList<Item> allItens() {
		return new ArrayList<>(ITENS.values());
	}
	
	private boolean itemHasName(Item item, String name) {
		return item.getName().contains(name);
	}

	private boolean itemHasType(Item item, String type) {
		return item.getType().equals(type);
	}
	
	public Item quantityOf(String sku) {
		return ITENS.get(sku);
	}
	
	private void populateItensOnMap() {
		ITENS.put("MEA", new Item.Builder().withSku("MEA").withName("MEAN").withType("Book").withQuantity(5).build());
		ITENS.put("MEA", new Item.Builder().withSku("SEO").withName("SEO na Prática").withType("Book").withQuantity(4).build());
		ITENS.put("RUB", new Item.Builder().withSku("RUB").withName("Jogos com Ruby").withType("Book").withQuantity(8).build());
		ITENS.put("GAL", new Item.Builder().withSku("GAL").withName("Galaxy Tab").withType("Tablet").withQuantity(3).build());
		ITENS.put("IP4", new Item.Builder().withSku("IP4").withName("IPhone 4 C").withType("Cellphone").withQuantity(7).build());
		ITENS.put("IP5", new Item.Builder().withSku("IP5").withName("IPhone 5").withType("Cellphone").withQuantity(3).build());
		ITENS.put("IP6", new Item.Builder().withSku("IP6").withName("IPhone 6 S").withType("Cellphone").withQuantity(10).build());
		ITENS.put("MOX", new Item.Builder().withSku("MOX").withName("Moto X").withType("Cellphone").withQuantity(6).build());
		ITENS.put("MOG", new Item.Builder().withSku("MOG").withName("Moto G").withType("Cellphone").withQuantity(8).build());
		ITENS.put("MXX", new Item.Builder().withSku("MXX").withName("Moto MAXX").withType("Cellphone").withQuantity(2).build());
	}
}
