package com.vstu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vstu.dao.UserRepository;
import com.vstu.entity.User;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User save(User user) {
		return userRepository.saveAndFlush(user);
	}

	public User update(User user) {
		return userRepository.save(user);
	}

	public User find(String username) {
		return userRepository.findOneByUsername(username);
	}

	public User find(Long id_user) {
		return userRepository.findOne(id_user);
	}

}
