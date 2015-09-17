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
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;

@Entity
@Table(name = "release_backlog")
public class Release {

	private Long id;
	private String name;
	private String description;
	// private String srumMaster;
	private Date startDate;
	private Date endDate;

	private Set<UserStory> userStories = new HashSet<UserStory>();

	private Set<Sprint> sprints = new HashSet<Sprint>();

	private ProductBacklog productBacklog;

	@ManyToOne
	@JoinColumn(name = "product_backlog_id", nullable = false)
	public ProductBacklog getProductBacklog() {
		return productBacklog;
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
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

}