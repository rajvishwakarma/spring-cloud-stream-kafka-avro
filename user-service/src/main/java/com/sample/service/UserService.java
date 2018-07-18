package com.sample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.datastax.driver.core.utils.UUIDs;
import com.sample.kafka.producers.Sender;
import com.sample.models.User;
import com.sample.models.UserData;
import com.sample.repo.UserRepo;

@Service
public class UserService implements IUserService {
	
	@Autowired
    private Sender sender;
	
	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User postUsers(User user) {
		user.setId(UUIDs.timeBased());
		user.setIsActive(true);
		User createdUser = userRepo.save(user);
        sender.send(buildUserData(createdUser));
        return createdUser;
	}
	
	public UserData buildUserData(User user){
		return new UserData(user.getId().toString(), user.getName(), user.getEmail());
	}
	
}