package com.alljobs.meetings.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.alljobs.meetings.models.UserModel;
import com.alljobs.meetings.repositories.UserRepository;

import jakarta.transaction.Transactional;

@Service
public class UserService {

  final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Transactional
  public UserModel getUserById(@PathVariable(value = "id") Long id) {
    return userRepository.findById(id).orElse(null);
  }

}
