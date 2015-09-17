package edu.mum.mumscrum.s5.service;

import java.util.Set;

import edu.mum.mumscrum.s5.entity.Role;

public interface RoleService {
	public Role getRoleById(int roleId);
	public Set<Role> getRoles();

}
