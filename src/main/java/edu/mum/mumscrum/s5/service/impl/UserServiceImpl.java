package edu.mum.mumscrum.s5.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.UserDAO;
import edu.mum.mumscrum.s5.entity.User;
import edu.mum.mumscrum.s5.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDAO userDAO;

	@Override
	public User getUserById(int id) {
		// TODO Auto-generated method stub
		return this.userDAO.getUserById(id);
	}
}
