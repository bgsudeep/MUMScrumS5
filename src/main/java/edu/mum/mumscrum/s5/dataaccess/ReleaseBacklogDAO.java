package edu.mum.mumscrum.s5.dataaccess;

import java.util.List;

import edu.mum.mumscrum.s5.entity.Release;

public interface ReleaseBacklogDAO {
	public void addRelease(Release r);
	public void updateRelease(Release r);
	public List<Release> listRelease();
	public Release getReleaseById(int id);
	public void removeRelease(int id);
}
