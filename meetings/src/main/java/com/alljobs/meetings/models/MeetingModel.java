package com.alljobs.meetings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDateTime;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "meetings")
public class MeetingModel extends RepresentationModel<MeetingModel> implements Serializable {
  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private UUID idMeeting;
  private Long user_id;
  private Long headhunter_id;
  private LocalDateTime dateTime;
  private String link;
  private String status;

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

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  public LocalDateTime getDateTime() {
    return dateTime;
  }

  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS")
  public void setDateTime(LocalDateTime dateTime) {
    this.dateTime = dateTime;
  }

  public String getLink() {
    return link;
  }

  public void setLink(String link) {
    this.link = link;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
