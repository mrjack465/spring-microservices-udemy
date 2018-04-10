package com.weinnig.webservices.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDoaService {

	private static List<User> users = new ArrayList<User>();
	
	static {
		users.add(new User(0, "Adam", new Date()));
		users.add(new User(1, "Eve",  new Date()));
		users.add(new User(2, "Jack", new Date()));
		users.add(new User(3, "Jill", new Date()));
	}
	
	public List<User> findAll() {
		return users;
	}
	
	public User findById(int num) {
		if (users.isEmpty() || num > users.size() -1) {
			return null;
		}
		return users.get(num);
	}
	
	public User deleteById(int id) {
		Iterator<User> iterator = users.iterator();
		while(iterator.hasNext()) {
			User user = iterator.next();
			if (user.getId() == id) {
				iterator.remove();
				return user;
			}
		}
		return null;
	}
	
	public User create(User user) {
		int size = users.size();
		user.setId(size);
		users.add(user);
		return user;
	}
	
	public User save(User u) {
		int size = users.size();
		if (u.getId() == null) {
			return this.create(u);
		}
		
		int curIndex = 0;
		int targetIndex = -1;
		for (User user : users) {
			if (user.getId().intValue() == size) {
				targetIndex = curIndex;
				break;
			}
			curIndex++;
		}
		if (targetIndex == -1) {
			users.add(u);
		} else {
			users.set(targetIndex, u);
		}
		return u;
	}
}
