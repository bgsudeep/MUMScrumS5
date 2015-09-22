package edu.mum.mumscrum.s5.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "release_backlog")
public class Release {

	private int id;
	private String name;
	private String description;
	// private String srumMaster;
	private Date startDate;
	private Date endDate;

	private Set<UserStory> userStories = new HashSet<UserStory>();

	private Set<Sprint> sprints = new HashSet<Sprint>();

	private ProductBacklog productBacklog;
	private Employee employee;

	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="assigned_to", nullable = true)
	public Employee getEmployee() {
		return employee;
	}
	
	@ManyToOne
	@JoinColumn(name = "product_backlog_id", nullable = false)
	public ProductBacklog getProductBacklog() {
		return productBacklog;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setProductBacklog(ProductBacklog productBacklog) {
		this.productBacklog = productBacklog;
	}

	@OneToMany(mappedBy = "releaseBacklog", fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Set<UserStory> getUserStories() {

		return userStories;
	}

	@OneToMany(mappedBy = "releaseBacklog", fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade({ org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Set<Sprint> getSprints() {
		return sprints;
	}

	public void setUserStories(Set<UserStory> userStories) {
		this.userStories = userStories;
	}

	public void setSprints(Set<Sprint> sprints) {
		this.sprints = sprints;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(nullable = false)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	// @Column(nullable = false)
	// public String getSrumMaster() {
	// return srumMaster;
	// }
	// public void setSrumMaster(String srumMaster) {
	// this.srumMaster = srumMaster;
	// }
	@Column(nullable = true)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	@Column(nullable = true)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Release [id=" + id + ", name=" + name + ", sprints=" + sprints + "]";
	}
	

}