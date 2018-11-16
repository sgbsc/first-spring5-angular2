package com.bsc;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

	Map<String, User> tokens = new HashMap<>();
	
	public String create(User user) {
		String token = UUID.randomUUID().toString();
		tokens.put(token,  user);
		return token;
	}
	
	public void delete(String token) {
		tokens.remove(token);
	}
	
	public boolean isValid(String token) {
		if(tokens.get(token) != null) {
			return true;
		}
		return false;
	}
}
