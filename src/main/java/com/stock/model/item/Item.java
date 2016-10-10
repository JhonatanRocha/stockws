package com.stock.model.item;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Item {

	private String sku;
	private String name;
	private String type;
	private int quantity;

	Item() {
		super();
	}

	public Item(String sku, String name, String type, int quantity) {
		super();
		this.sku = sku;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
	}

	Item(String sku) {
		this.sku = sku;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	@Override
	public int hashCode() {
		return this.sku.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Item item = (Item)obj;
		return this.sku.equals(item.sku);
	}
	
	@Override
	public String toString() {
		return "Item [sku=" + sku + ", name=" + name + ", type=" + type + ", quantity="
				+ quantity + "]";
	}

	public static class Builder {
		
		private String sku;
		private String name;
		private String type;
		private int quantity;
		
		public Builder withName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder withType(String type) {
			this.type = type;
			return this;
		}
		
		public Builder withSku(String sku) {
			this.sku = sku;
			return this;
		}
		
		public Builder withQuantity(int quantity) {
			this.quantity = quantity;
			return this;
		}
		
		public Item build() {
			return new Item(this.sku,this.name,this.type,this.quantity);
		}
	}
}
