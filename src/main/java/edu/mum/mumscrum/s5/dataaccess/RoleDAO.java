package edu.mum.mumscrum.s5.dataaccess;

import java.util.Set;

import edu.mum.mumscrum.s5.entity.Role;

public interface RoleDAO {

	Role getRoleById(int roleId);

	Set<Role> getRoles();

}
