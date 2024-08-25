package com.alljobs.meetings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "available_times")
public class AvailableTimeModel {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long referenceID;
  private String referenceType;
  private Integer dayOfWeek;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private LocalTime startTimeRange;
  private LocalTime endTimeRange;

  // Getters and Setters
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getReferenceID() {
    return referenceID;
  }

  public void setReferenceID(Long referenceID) {
    this.referenceID = referenceID;
  }

  public String getReferenceType() {
    return referenceType;
  }

  public void setReferenceType(String referenceType) {
    this.referenceType = referenceType;
  }

  public Integer getDayOfWeek() {
    return dayOfWeek;
  }

  public void setDayOfWeek(Integer dayOfWeek) {
    this.dayOfWeek = dayOfWeek;
  }

  public LocalTime getStartTimeRange() {
    return startTimeRange;
  }

  public void setStartTimeRange(LocalTime startTimeRange) {
    this.startTimeRange = startTimeRange;
  }

  public LocalTime getEndTimeRange() {
    return endTimeRange;
  }

  public void setEndTimeRange(LocalTime endTimeRange) {
    this.endTimeRange = endTimeRange;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }
}