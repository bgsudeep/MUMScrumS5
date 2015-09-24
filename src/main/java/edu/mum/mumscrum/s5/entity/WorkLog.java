package edu.mum.mumscrum.s5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "worklog")
public class WorkLog {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private int employeeID;
	private int userStory_Id;
	
	@Column(nullable = true)
	private int actualEffort_Dev;
	
	@Column(nullable = true)
	private int actualEffort_Test;
	private int day;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public int getUserStory_Id() {
		return userStory_Id;
	}
	public void setUserStory_Id(int userStory_Id) {
		this.userStory_Id = userStory_Id;
	}
	public int getActualEffort_Dev() {
		return actualEffort_Dev;
	}
	public void setActualEffort_Dev(int actualEffort_Dev) {
		this.actualEffort_Dev = actualEffort_Dev;
	}
	public int getActualEffort_Test() {
		return actualEffort_Test;
	}
	public void setActualEffort_Test(int actualEffort_Test) {
		this.actualEffort_Test = actualEffort_Test;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	@Override
	public String toString() {
		return "WorkLog [id=" + id + ", employeeID=" + employeeID + ", userStory_Id=" + userStory_Id
				+ ", actualEffort_Dev=" + actualEffort_Dev + ", actualEffort_Test=" + actualEffort_Test + ", day=" + day
				+ "]";
	}

}