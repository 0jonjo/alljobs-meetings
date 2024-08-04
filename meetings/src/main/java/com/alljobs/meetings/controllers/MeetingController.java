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
import com.alljobs.meetings.service.MeetingService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
public class MeetingController {

    @Autowired
    MeetingRepository meetingRepository;

    final MeetingService meetingService;

    public MeetingController(MeetingService meetingService) {
        this.meetingService = meetingService;
    }

    @GetMapping("/meeting")
    public ResponseEntity<List<MeetingModel>> getAllMeetings() {
        List<MeetingModel> meetingsList = meetingService.getAllMeetings();
        if (!meetingsList.isEmpty()) {
            for (MeetingModel meeting : meetingsList) {
                UUID id = meeting.getIdMeeting();
                meeting.add(linkTo(methodOn(MeetingController.class).getMeetingById(id)).withSelfRel());
            }
        }
        return ResponseEntity.status(HttpStatus.OK).body(meetingsList);
    }

    @GetMapping("/meeting/{id}")
    public ResponseEntity<Object> getMeetingById(@PathVariable(value = "id") UUID id) {
        var meetingModel = meetingService.getMeetingById(id);
        if (meetingModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting not found");
        }
        meetingModel.add(linkTo(methodOn(MeetingController.class).getAllMeetings()).withRel("All Meetings"));
        return ResponseEntity.status(HttpStatus.OK).body(meetingModel);
    }

    @PostMapping("/meeting")
    public ResponseEntity<Object> createMeeting(@Valid @RequestBody MeetingRecordDto meetingRecordDto) {
        var meetingModel = new MeetingModel();
        BeanUtils.copyProperties(meetingRecordDto, meetingModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(meetingService.saveMeeting(meetingModel));
    }

    @PutMapping("/meeting/{id}")
    public ResponseEntity<Object> updateMeeting(@PathVariable(value = "id") UUID id,
            @RequestBody MeetingRecordDto meetingRecordDto) {
        var meetingModel = meetingService.getMeetingById(id);
        if (meetingModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting not found");
        }
        BeanUtils.copyProperties(meetingRecordDto, meetingModel);
        return ResponseEntity.status(HttpStatus.OK).body(meetingService.updateMeeting(meetingModel));
    }

    @DeleteMapping("/meeting/{id}")
    public ResponseEntity<Object> deleteMeeting(@PathVariable(value = "id") UUID id,
            @RequestBody MeetingRecordDto meetingRecordDto) {
        var meetingModel = meetingService.getMeetingById(id);
        if (meetingModel == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Meeting not found");
        }
        meetingRepository.delete(meetingModel);
        return ResponseEntity.status(HttpStatus.OK).body("Meeting deleted successfully");
    }
}
