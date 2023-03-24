package bored.repository;
import java.util.ArrayList;
import java.util.List;

import bored.entity.User;

public class UserRepository {

	private static List<User> userTable = new ArrayList<>(); // user 한명한명이 저장되는곳
	
	public User findByEmail(String email) {
		User result = null;
		for (User user: userTable) {
			if (user.getEmail().equals(email)) {
				result = user;
				break;
			}
		}
		return result;
		
	}
	
	public boolean existsByEmail(String email) {
		boolean result = false;
		for (User user: userTable) {
			if (user.getEmail().equals(email)) {
				result = true;
				break;
			}
		}
		return result;
	}
	
	
	public User save(User user) { // user한명한명을 저장하는 메소드
		userTable.add(user);
		return user;
	}
	
	
}


