package com.study.demo.handler.controller;


import com.study.demo.entity.User;
import com.study.demo.handler.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
  @Autowired
  private UserService userService;

  @RequestMapping(value = "/users", method = RequestMethod.GET)
  public ResponseEntity<Object> getAllUsers() {
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }

  @RequestMapping(value = "/users", method = RequestMethod.POST)
  public ResponseEntity<Object> addUser(@RequestBody final User user) {
    userService.addUser(user);
    return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
  }
}
