package edu.mum.mumscrum.s5.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity 
@Table(name="user")

public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="enabled")
	private boolean enabled;
	
	@Transient
	private String roleID;
	
	@OneToOne
	@JoinTable(name="employee_user", joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
		inverseJoinColumns={@JoinColumn(name="employee_id", referencedColumnName="id")})
	@Cascade({org.hibernate.annotations.CascadeType.ALL})
	private Employee employee;
	
	@OneToOne
	@JoinTable(name="user_role", joinColumns={@JoinColumn(name="user_id", referencedColumnName="id")},
			inverseJoinColumns={@JoinColumn(name="role_id", referencedColumnName="id")})
	@Cascade({ org.hibernate.annotations.CascadeType.MERGE,
		org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	private Role role;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getRoleID() {
		return roleID;
	}
	public void setRoleID(String roleID) {
		this.roleID = roleID;
	}

	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
