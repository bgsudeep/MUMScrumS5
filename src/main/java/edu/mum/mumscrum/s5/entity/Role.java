package edu.mum.mumscrum.s5.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name="role")
public class Role {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String role;
	
	@ManyToMany
	@JoinTable(name = "user_role", joinColumns = { @JoinColumn(name = "role_id", referencedColumnName = "id") }, inverseJoinColumns = { @JoinColumn(name = "user_id", referencedColumnName = "id") })
//	@Cascade({
//			org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private List<User> userRoles = new ArrayList<User>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<User> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<User> userRoles) {
		this.userRoles = userRoles;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", role=" + role + ", userRoles=" + userRoles + "]";
	}
	
	
}
