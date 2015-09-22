package edu.mum.mumscrum.s5.dataaccess.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.ReleaseBacklogDAO;
import edu.mum.mumscrum.s5.entity.ProductBacklog;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.UserStory;

@Repository
public class ReleaseBacklogDAOImpl implements ReleaseBacklogDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(ReleaseBacklogDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional
	public void addRelease(Release r) {
		entityManager.persist(r);
		entityManager.flush();
		LOGGER.info("Release saved successfully, Release Details=" + r);

	}

	@Override
	@Transactional
	public void updateRelease(Release r) {
		LOGGER.info("Release to be updated = " + r);
		entityManager.merge(r);
		LOGGER.info("Release updated successfully, Release Details=" + r);

	}

	@Override
	@Transactional
	public List<Release> listRelease() {
		List<Release> releaseList = entityManager.createQuery("select o from Release o", Release.class).getResultList();

		for (Release r : releaseList) {
			LOGGER.info("userStory List::" + r);
		}
		return releaseList;
	}

	@Override
	@Transactional
	public Release getReleaseById(int id) {
		Release r = (Release) entityManager.find(Release.class, new Integer(id));
		LOGGER.info("Release loaded successfully, Release details=" + r);
		return r;
	}

	@Override
	@Transactional
	public void removeRelease(int id) {
		Release r = getReleaseById(id);

		if (null != r) {
			entityManager.remove(r);
		}
		LOGGER.info("Release deleted successfully, Release details=" + r);

	}

	@Override
	public Set<UserStory> getAvailableUserStories(Release releaseBacklog) {
		Set<UserStory> userStories = releaseBacklog.getUserStories();

		Set<UserStory> availableUserStories = new HashSet<UserStory>();

		for (UserStory userStory : userStories) {

			if (userStory.getSprint() == null) {

				availableUserStories.add(userStory);
			}
		}

		return availableUserStories;
	}
	
	

}
