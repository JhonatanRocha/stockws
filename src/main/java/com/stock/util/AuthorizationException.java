package com.stock.util;

import java.util.Calendar;

import javax.xml.ws.WebFault;

@WebFault(name="AuthorizationFault")
public class AuthorizationException extends Exception {

	private static final long serialVersionUID = 1L;

	public AuthorizationException(String message) {
		super(message);
	}
	
	public InfoFault getFaultInfo() {
		return new InfoFault("Invalid Token.", Calendar.getInstance().getTime());
	}
}
