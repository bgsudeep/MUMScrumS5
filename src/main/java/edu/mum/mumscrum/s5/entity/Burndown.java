package edu.mum.mumscrum.s5.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="burndown")

public class Burndown {

	private int id;
	private int totalRemainingEffort;
	private int totalPlannedEffort;

	private Sprint sprint;
   
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name = "sprint_id", nullable = false)
	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Column(name="total_remaining_effort",nullable = true)
	public int getTotalRemainingEffort() {
		return totalRemainingEffort;
	}

	public void setTotalRemainingEffort(int totalRemainingEffort) {
		this.totalRemainingEffort = totalRemainingEffort;
	}

	@Column(name="total_planned_effort",nullable = true)
	public int getTotalPlannedEffort() {
		return totalPlannedEffort;
	}

	
	public void setTotalPlannedEffort(int totalPlannedEffort) {
		this.totalPlannedEffort = totalPlannedEffort;
	}

	

	
}