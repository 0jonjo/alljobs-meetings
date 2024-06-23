package com.alljobs.meetings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.alljobs.meetings.repositories.MeetingRepository;

@RestController
public class MeetingController {

  @Autowired
  MeetingRepository meetingRepository;

}
