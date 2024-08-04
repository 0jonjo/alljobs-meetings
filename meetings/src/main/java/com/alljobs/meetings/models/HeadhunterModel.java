package com.alljobs.meetings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "headhunters")
public class HeadhunterModel {

  @Id
  private Long id;

  public Long getIdHeadhunter(Long id) {
    return id;
  }

}
