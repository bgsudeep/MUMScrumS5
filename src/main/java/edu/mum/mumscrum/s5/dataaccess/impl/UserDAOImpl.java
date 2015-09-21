package edu.mum.mumscrum.s5.dataaccess.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.UserDAO;
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

}
