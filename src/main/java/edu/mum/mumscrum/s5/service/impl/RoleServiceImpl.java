package edu.mum.mumscrum.s5.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.RoleDAO;
import edu.mum.mumscrum.s5.entity.Role;
import edu.mum.mumscrum.s5.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	private RoleDAO roleDAO;

	@Override
	public Role getRoleById(int roleId) {
		// TODO Auto-generated method stub
		return this.roleDAO.getRoleById(roleId);
	}

	@Override
	public Set<Role> getRoles() {
		// TODO Auto-generated method stub
		return this.roleDAO.getRoles();
	}

}
