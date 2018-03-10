package com.zrf.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zrf.springboot.dao.UserDao;
import com.zrf.springboot.entity.User;
import com.zrf.springboot.service.UserService;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
	private UserDao userDao;
	@Override
	public List<User> getUserList() {
		return userDao.findAll();
	}

	@Override
	public User findUserById(int id) {
		return userDao.findById(id);
	}

	@Override
	public void save(User user) {
		userDao.save(user);
	}

	@Override
	public void edit(User user) {
		userDao.save(user);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

}
