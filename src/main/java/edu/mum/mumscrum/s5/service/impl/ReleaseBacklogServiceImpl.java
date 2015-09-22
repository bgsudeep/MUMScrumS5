package edu.mum.mumscrum.s5.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.ReleaseBacklogDAO;
import edu.mum.mumscrum.s5.entity.Release;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.service.ReleaseBacklogService;

@Service
public class ReleaseBacklogServiceImpl implements ReleaseBacklogService {
	
	@Autowired
	private ReleaseBacklogDAO releaseBacklogDAO;

	@Override
	public void addRelease(Release r) {
		this.releaseBacklogDAO.addRelease(r);
		
	}

	@Override
	public void updateRelease(Release r) {
		this.releaseBacklogDAO.updateRelease(r);
		
	}

	@Override
	public List<Release> listRelease() {
		return this.releaseBacklogDAO.listRelease();
	}

	@Override
	public Release getReleaseById(int id) {
		return this.releaseBacklogDAO.getReleaseById(id);
	}

	@Override
	public void removeRelease(int id) {
		this.releaseBacklogDAO.removeRelease(id);
	}

	@Override
	public Set<UserStory> getAvailableUserStories(Release releaseBacklog) {
		return this.releaseBacklogDAO.getAvailableUserStories(releaseBacklog);
	}

	

}
