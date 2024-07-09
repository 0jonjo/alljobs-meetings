package com.alljobs.meetings.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;

import com.alljobs.meetings.dtos.MeetingRecordDto;
import com.alljobs.meetings.models.MeetingModel;
import com.alljobs.meetings.repositories.MeetingRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class MeetingController {

  @Autowired
  MeetingRepository meetingRepository;

  @GetMapping("/meeting")
  public ResponseEntity<List<MeetingModel>> getAllMeetings(){
      return ResponseEntity.status(HttpStatus.OK).body(meetingRepository.findAll());
  }

  @GetMapping("/meeting/{id}")
  public ResponseEntity<Object> getMeetingById(@PathVariable(value = "id") UUID id){
      Optional<MeetingModel> meetingO = meetingRepository.findById(id);
      if(meetingO.isEmpty()){
          return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting not found");
      }
        return ResponseEntity.status(HttpStatus.OK).body(meetingO.get());
  }

  @PostMapping("/meeting")
  public ResponseEntity<MeetingModel> saveMeeting(@RequestBody @Valid MeetingRecordDto meetingRecordDto) {
      var meetingModel = new MeetingModel();
      BeanUtils.copyProperties(meetingRecordDto, meetingModel);
      return ResponseEntity.status(HttpStatus.CREATED).body(meetingRepository.save(meetingModel));
  }

  @PutMapping("/meeting/{id}")
    public ResponseEntity<Object> updateMeeting(@PathVariable(value = "id") UUID id, @RequestBody MeetingRecordDto meetingRecordDto){
        Optional<MeetingModel> meetingO = meetingRepository.findById(id);
        if(meetingO.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting not found");
        }
        var meetingModel = meetingO.get();
        BeanUtils.copyProperties(meetingRecordDto, meetingModel);
        return ResponseEntity.status(HttpStatus.OK).body(meetingRepository.save(meetingModel));
    }
}
