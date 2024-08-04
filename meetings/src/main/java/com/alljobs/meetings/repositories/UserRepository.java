package com.alljobs.meetings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alljobs.meetings.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {

}
