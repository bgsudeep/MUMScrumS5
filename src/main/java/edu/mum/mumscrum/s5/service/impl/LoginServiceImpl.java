package edu.mum.mumscrum.s5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.mumscrum.s5.dataaccess.LoginDAO;
import edu.mum.mumscrum.s5.entity.User;
import edu.mum.mumscrum.s5.service.LoginService;

public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDAO loginDAO;
	
	public void setLoginDAO(LoginDAO loginDAO) {
		this.loginDAO = loginDAO;
	}

	@Override
	public boolean login(User user) {
		return this.loginDAO.login(user);
	}

	@Override
	public void logout() {
		this.loginDAO.logout();
		
	}

}
