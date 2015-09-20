package edu.mum.mumscrum.s5.service;

import java.util.List;

import edu.mum.mumscrum.s5.entity.UserStory;

public interface UserStoryService {
	
	public void addUserStory(UserStory us);
	public void updateUserStory(UserStory us);
	public List<UserStory> listUserStory();
	public UserStory getUserStoryById(int id);
	public void removeUserStory(int id);

}
