package edu.mum.mumscrum.s5.entity;

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
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "sprint")
public class Sprint {
	
	private Long id;

	private String title;

	private String description;

	private Release releaseBacklog;

	private Set<UserStory> userStories = new HashSet<UserStory>();

	private Set<Burndown> burndownlists = new HashSet<Burndown>();

	@OneToMany(mappedBy = "sprint", fetch = FetchType.EAGER)
	@Cascade({ CascadeType.ALL })
	public Set<Burndown> getBurndownlists() {
		return burndownlists;
	}

	@ManyToOne
	@JoinColumn(name = "release_id", nullable = false)
	public Release getReleaseBacklog() {
		return releaseBacklog;
	}

	public void setReleaseBacklog(Release releaseBacklog) {
		this.releaseBacklog = releaseBacklog;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	@OneToMany(mappedBy = "sprint", fetch = FetchType.EAGER, orphanRemoval = false)
	@Cascade({ org.hibernate.annotations.CascadeType.PERSIST,
			org.hibernate.annotations.CascadeType.MERGE,
			org.hibernate.annotations.CascadeType.SAVE_UPDATE })
	public Set<UserStory> getUserStories() {

		return userStories;
	}

	@Column
	public String getTitle() {
		return title;
	}

	@Column
	public String getDescription() {
		return description;
	}

	public void setId(Long id) {

		this.id = id;
	}

	public void setUserStories(Set<UserStory> userStories) {

		this.userStories = userStories;
	}

	public void addUserStory(UserStory userStory) {
		this.userStories.add(userStory);
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setBurndownlists(Set<Burndown> burndownlists) {
		this.burndownlists = burndownlists;
	}

}