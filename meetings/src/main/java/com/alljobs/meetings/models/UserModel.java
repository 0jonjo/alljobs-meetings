package com.alljobs.meetings.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class UserModel {

  @Id
  private Long id;

  public Long getIdUser(Long id) {
    return id;
  }

}
