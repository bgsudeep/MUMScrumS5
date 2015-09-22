package edu.mum.mumscrum.s5.service;

import java.util.List;
import java.util.Set;

import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.UserStory;


public interface ReleaseBacklogService {
	
	public void addRelease(Release r);
	public void updateRelease(Release r);
	public List<Release> listRelease();
	public Release getReleaseById(int id);
	public void removeRelease(int id);
	public Set<UserStory> getAvailableUserStories(Release releaseBacklog);

}
