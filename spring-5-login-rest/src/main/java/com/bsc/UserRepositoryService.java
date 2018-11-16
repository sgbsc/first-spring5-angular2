package com.bsc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

//lets pretend this service is a repository
@Service
public class UserRepositoryService {

	List<User> users;
	
	public UserRepositoryService() {
		this.users = new ArrayList<>();
		this.users.add(new User(1,"Mario","secret"));
		this.users.add(new User(2,"Ralf","secret1"));
		this.users.add(new User(3,"John","secret2"));
	}
	
	public boolean isAuthorized(User user) {
		for (User u: users) {
			if(u.getUsername().equals(user.getUsername()) &&
			   u.getPassword().equals(user.getPassword())) {
				return true;	
			}
		}
		return false;
	}
}
