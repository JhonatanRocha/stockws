package com.stock.ws;

import javax.xml.ws.Endpoint;

public class PublishWebService {

	public static void main(String[] args) {
		
		StockWS serviceStockWS = new StockWS();
		String url = "http://localhost:8080/stockws";
		
		System.out.println("Service is up and running: " + url.concat("?wsdl"));
		
		Endpoint.publish(url, serviceStockWS);
	}
}