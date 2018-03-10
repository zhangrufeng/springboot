package com.zrf.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zrf.springboot.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
   User findById(int id);
   Long deleteById(int id);
}
