package com.stock.ws;

import javax.xml.ws.Endpoint;

public class PublishWebService {

	public static void main(String[] args) {
		
		StockWS serviceStockWS = new StockWS();
		String url = "http://localhost:8080/stockws";
		
		Endpoint.publish(url, serviceStockWS);
	}
}
