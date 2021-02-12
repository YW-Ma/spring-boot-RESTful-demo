package com.study.demo.handler.service;

import com.study.demo.entity.User;
import com.study.demo.handler.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserDao userDao;

  public void addUser(User user) {
    userDao.addUser(user);
  }

  public List<User> getAllUsers() {
    return userDao.getAllUsers();
  }
}
