package edu.mum.mumscrum.s5.service;

import java.util.List;

import edu.mum.mumscrum.s5.entity.Release;


public interface ReleaseBacklogService {
	
	public void addRelease(Release r);
	public void updateRelease(Release r);
	public List<Release> listRelease();
	public Release getReleaseById(int id);
	public void removeRelease(int id);

}
