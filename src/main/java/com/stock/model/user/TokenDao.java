package com.stock.model.user;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;


public class TokenDao {

	private static Map<TokenUser, User> USERS = new LinkedHashMap<>();

	public TokenDao() {
		populateUsersOnMap();
	}
	
	public boolean isValid(TokenUser user) {
		return USERS.containsKey(user);
	}
	
	private void populateUsersOnMap() {
		USERS.put(new TokenUser("AAA", parseDate("31/12/2015")), new User.Builder().withName("Nico").withLogin("nico").withPassword("pass").build());
		USERS.put(new TokenUser("BBB", parseDate("31/12/2015")), new User.Builder().withName("Flavio").withLogin("flavio").withPassword("pass").build());
		USERS.put(new TokenUser("CCC", parseDate("31/12/2015")), new User.Builder().withName("Fabio").withLogin("fabio").withPassword("pass").build());
		USERS.put(new TokenUser("DDD", parseDate("31/12/2015")), new User.Builder().withName("Romulo").withLogin("Romulo").withPassword("pass").build());
	}

	private Date parseDate(String dateAsString) {
		try {
			return new SimpleDateFormat("dd/MM/yyyy").parse(dateAsString);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}
}
