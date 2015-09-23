package edu.mum.mumscrum.s5.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_story")
public class UserStory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column
	private String title;

	@Column
	private String description;

	@Column
	private double estimatedDevHours;

	@Column
	private double remainingDevHours;

	@Column
	private double estimatedTestHours;

	@Column
	private double remainingTestHours;

	@Column
	private Date createdDate;
	
	@Column
	private Date assignedDate;

	@Column
	private Date completedDate;
	
	@ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "product_backlog_id", nullable = false)
	private ProductBacklog productBacklog;

	@ManyToOne
	@JoinColumn(name = "release_backlog_id", nullable = true)
	private Release releaseBacklog;
	
	@ManyToOne
	@JoinColumn(name = "sprint_id", nullable = true)
	private Sprint sprint;
	
	@ManyToOne
	@JoinColumn(name="assigned_developer", nullable = true)
	private Employee developer;
	public Employee getDeveloper() {
		return developer;
	}
	
	@ManyToOne
	@JoinColumn(name="assigned_tester", nullable = true)
	private Employee tester;
	public Employee getTester() {
		return tester;
	}
	
	public void setDeveloper(Employee developer) {
		this.developer = developer;
	}

	public void setTester(Employee tester) {
		this.tester = tester;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getEstimatedDevHours() {
		return estimatedDevHours;
	}

	public void setEstimatedDevHours(double estimatedDevHours) {
		this.estimatedDevHours = estimatedDevHours;
	}

	public double getRemainingDevHours() {
		return remainingDevHours;
	}

	public void setRemainingDevHours(double remainingDevHours) {
		this.remainingDevHours = remainingDevHours;
	}

	public double getEstimatedTestHours() {
		return estimatedTestHours;
	}

	public void setEstimatedTestHours(double estimatedTestHours) {
		this.estimatedTestHours = estimatedTestHours;
	}

	public double getRemainingTestHours() {
		return remainingTestHours;
	}

	public void setRemainingTestHours(double remainingTestHours) {
		this.remainingTestHours = remainingTestHours;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getAssignedDate() {
		return assignedDate;
	}

	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}

	public Date getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(Date completedDate) {
		this.completedDate = completedDate;
	}

	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	public Release getReleaseBacklog() {
		return releaseBacklog;
	}

	public void setReleaseBacklog(Release releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}

	public Sprint getSprint() {
		return sprint;
	}

	public void setSprint(Sprint sprint) {
		this.sprint = sprint;
	}

	@Override
	public String toString() {
		return "UserStory [id=" + id + ", title=" + title + ", description=" + description + ", estimatedDevHours="
				+ estimatedDevHours + ", remainingDevHours=" + remainingDevHours + ", estimatedTestHours="
				+ estimatedTestHours + ", remainingTestHours=" + remainingTestHours + ", createdDate=" + createdDate
				+ ", assignedDate=" + assignedDate + ", completedDate=" + completedDate + "]";
	}
}
