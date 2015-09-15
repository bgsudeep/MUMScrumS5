package edu.mum.mumscrum.s5.service;

import edu.mum.mumscrum.s5.entity.User;

public interface LoginService {
	
	public boolean login(User user);
	public void logout();

}
