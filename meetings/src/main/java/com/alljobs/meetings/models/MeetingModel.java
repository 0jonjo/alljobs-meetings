package com.alljobs.meetings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "meetings")
public class MeetingModel implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idMeeting;
  private Long user_id;
  private Long headhunter_id;

  public UUID getIdMeeting() {
    return idMeeting;
  }

  public void setIdMeeting(UUID idMeeting) {
    this.idMeeting = idMeeting;
  }

  public Long getUser_id() {
    return user_id;
  }

  public void setUser_id(Long user_id) {
    this.user_id = user_id;
  }

  public Long getHeadhunter_id() {
    return headhunter_id;
  }

  public void setHeadhunter_id(Long headhunter_id) {
    this.headhunter_id = headhunter_id;
  }

}
