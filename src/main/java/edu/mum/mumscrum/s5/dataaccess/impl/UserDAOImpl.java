package edu.mum.mumscrum.s5.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.UserDAO;
import edu.mum.mumscrum.s5.entity.Employee;
import edu.mum.mumscrum.s5.entity.User;

@Repository
public class UserDAOImpl implements UserDAO{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

	
	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public User getUserById(int id) {
		User user = (User) entityManager.find(User.class, new Integer(id));
		LOGGER.info("User loaded successfully, User details=" + user);
		return user;
	}

	@Override
	public User getUserByUserName(String username) {
		List<User> userList = entityManager.createQuery("select o from User o where o.username = " + "'" + username + "'", User.class).getResultList();
		
		return userList.get(0);
	}
	
	
	

}
