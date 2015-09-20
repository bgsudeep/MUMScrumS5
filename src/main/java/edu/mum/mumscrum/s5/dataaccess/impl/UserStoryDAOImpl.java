package edu.mum.mumscrum.s5.dataaccess.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.UserStoryDAO;
import edu.mum.mumscrum.s5.entity.UserStory;

@Repository
public class UserStoryDAOImpl implements UserStoryDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserStoryDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addUserStory(UserStory us) {
		entityManager.persist(us);
		entityManager.flush();
		LOGGER.info("UserStory saved successfully, UserStory Details=" + us);
	}

	@Override
	@Transactional
	public void updateUserStory(UserStory us) {
		LOGGER.info("UserStory to be updated = " + us);
		entityManager.merge(us);
		LOGGER.info("UserStory updated successfully, UserStory Details=" + us);
	}

	@Override
	@Transactional
	public List<UserStory> listUserStory() {
		List<UserStory> userStoryList = entityManager.createQuery("select o from userStory o", UserStory.class)
				.getResultList();

		for (UserStory us : userStoryList) {
			LOGGER.info("userStory List::" + us);
		}
		return userStoryList;
	}

	@Override
	@Transactional
	public UserStory getUserStoryById(int id) {
		UserStory us = (UserStory) entityManager.find(UserStory.class, new Integer(id));
		LOGGER.info("UserStory loaded successfully, UserStory details=" + us);
		return us;
	}

	@Override
	@Transactional
	public void removeUserStory(int id) {
		UserStory us = getUserStoryById(id);
		
		if(null != us) {
			entityManager.remove(us);
		}
		LOGGER.info("UserStory deleted successfully, userStory details=" + us);
	}

}
