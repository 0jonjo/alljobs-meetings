package com.alljobs.meetings.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.alljobs.meetings.models.HeadhunterModel;
import com.alljobs.meetings.models.MeetingModel;
import com.alljobs.meetings.models.UserModel;
import com.alljobs.meetings.repositories.MeetingRepository;
import com.alljobs.meetings.repositories.UserRepository;
import com.alljobs.meetings.repositories.HeadhunterRepository;
import jakarta.transaction.Transactional;

@Service
public class MeetingService {

  final MeetingRepository meetingRepository;
  final UserRepository userRepository;
  final HeadhunterRepository headhunterRepository;

  public MeetingService(MeetingRepository meetingRepository, UserRepository userRepository,
      HeadhunterRepository headhunterRepository) {
    this.meetingRepository = meetingRepository;
    this.userRepository = userRepository;
    this.headhunterRepository = headhunterRepository;
  }

  @Transactional
  public MeetingModel saveMeeting(MeetingModel meetingModel) {
    // Utilizar o UserService para checar se o usuário existe no banco de dados
    long userId = meetingModel.getUser_id();
    var userService = new UserService(userRepository);
    var user = userService.getUserById(userId);
    if (user == null) {
      return null;
    }
    return meetingRepository.save(meetingModel);
  }

  @Transactional
  public MeetingModel updateMeeting(MeetingModel meetingModel) {
    if (meetingModel != null) {
      return meetingRepository.save(meetingModel);
    }
    return null;
  }

  @Transactional
  public void deleteMeeting(@PathVariable(value = "id") UUID id) {
    meetingRepository.deleteById(id);
  }

  @Transactional
  public List<MeetingModel> getAllMeetings() {
    return meetingRepository.findAll();
  }

  @Transactional
  public MeetingModel getMeetingById(@PathVariable(value = "id") UUID id) {
    return meetingRepository.findById(id).orElse(null);
  }

  public UserModel checkUserExist(long userId) {
    var userService = new UserService(userRepository);
    var user = userService.getUserById(userId);
    if (user == null) {
      return null;
    }
    return user;
  }

  public HeadhunterModel checkHeadhunterExist(long headhunterId) {
    var headhunterService = new HeadhunterService(headhunterRepository);
    var headhunter = headhunterService.getHeadhunterById(headhunterId);
    if (headhunter == null) {
      return null;
    }
    return headhunter;
  }
}
