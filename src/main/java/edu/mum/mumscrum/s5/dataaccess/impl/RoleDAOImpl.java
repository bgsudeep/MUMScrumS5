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

import edu.mum.mumscrum.s5.dataaccess.RoleDAO;
import edu.mum.mumscrum.s5.entity.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDAOImpl.class);

	@PersistenceContext
	EntityManager entityManager;

	@Override
	@Transactional
	public Role getRoleById(int roleId) {
		Role role = (Role) entityManager.find(Role.class, new Integer(roleId));
		return role;
	}

	@Override
	@Transactional
	public Set<Role> getRoles() {
		List<Role> roleList = entityManager.createQuery("select o from Role o", Role.class).getResultList();

		Set<Role> roleSet = new HashSet<Role>();
		
		for (Role role : roleList) {
			LOGGER.info("Employee List::" + role);
			roleSet.add(role);
		}
		return roleSet;
	}

}
