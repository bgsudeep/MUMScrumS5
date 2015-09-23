package edu.mum.mumscrum.s5.service;

import edu.mum.mumscrum.s5.entity.User;

public interface UserService {

	public User getUserById(int id);
	public User getUserByUserName(String username);
	
}
