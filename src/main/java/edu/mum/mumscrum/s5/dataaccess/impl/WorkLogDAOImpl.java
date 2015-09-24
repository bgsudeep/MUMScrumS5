package edu.mum.mumscrum.s5.dataaccess.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.mumscrum.s5.dataaccess.WorkLogEffortDAO;
import edu.mum.mumscrum.s5.entity.WorkLog;

@Repository
public class WorkLogDAOImpl implements WorkLogEffortDAO {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(WorkLogDAOImpl.class);

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void addWorkLog(WorkLog worklog) {
		entityManager.persist(worklog);
		entityManager.flush();
		LOGGER.info("WorkLog saved successfully, WorkLog Details=" + worklog);
		
	}
}
