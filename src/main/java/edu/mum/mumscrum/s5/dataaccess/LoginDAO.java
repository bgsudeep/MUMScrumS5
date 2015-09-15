package edu.mum.mumscrum.s5.dataaccess;

import edu.mum.mumscrum.s5.entity.User;

public interface LoginDAO {
	public boolean login(User user);
	public void logout();

}
