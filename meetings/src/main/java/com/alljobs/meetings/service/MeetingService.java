package com.alljobs.meetings.service;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.alljobs.meetings.models.MeetingModel;
import com.alljobs.meetings.repositories.MeetingRepository;

import jakarta.transaction.Transactional;

@Service
public class MeetingService {

  final MeetingRepository meetingRepository;

  public MeetingService(MeetingRepository meetingRepository) {
    this.meetingRepository = meetingRepository;
  }

  @Transactional
  public MeetingModel saveMeeting(MeetingModel meetingModel) {
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

}
