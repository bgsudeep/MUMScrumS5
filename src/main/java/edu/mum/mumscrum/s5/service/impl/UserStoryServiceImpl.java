package edu.mum.mumscrum.s5.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.mumscrum.s5.dataaccess.UserStoryDAO;
import edu.mum.mumscrum.s5.entity.UserStory;
import edu.mum.mumscrum.s5.service.UserStoryService;

@Service
public class UserStoryServiceImpl implements UserStoryService {
	
	@Autowired
	private UserStoryDAO userStoryDAO;

	@Override
	public void addUserStory(UserStory us) {
		this.userStoryDAO.addUserStory(us);
	}

	@Override
	public void updateUserStory(UserStory us) {
		this.userStoryDAO.updateUserStory(us);
	}

	@Override
	public List<UserStory> listUserStory() {
		return this.userStoryDAO.listUserStory();
	}

	@Override
	public UserStory getUserStoryById(int id) {
		return this.userStoryDAO.getUserStoryById(id);
	}

	@Override
	public void removeUserStory(int id) {
		this.userStoryDAO.removeUserStory(id);
	}

}
