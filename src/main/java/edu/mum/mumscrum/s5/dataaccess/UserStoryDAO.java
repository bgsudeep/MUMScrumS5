package edu.mum.mumscrum.s5.dataaccess;

import java.util.List;

import edu.mum.mumscrum.s5.entity.UserStory;

public interface UserStoryDAO {
	public void addUserStory(UserStory us);
	public void updateUserStory(UserStory us);
	public List<UserStory> listUserStory();
	public UserStory getUserStoryById(int id);
	public void removeUserStory(int id);
}
