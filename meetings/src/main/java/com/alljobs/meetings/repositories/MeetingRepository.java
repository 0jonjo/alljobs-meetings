package com.alljobs.meetings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alljobs.meetings.models.MeetingModel;

import java.util.UUID;

@Repository
public interface MeetingRepository extends JpaRepository<MeetingModel, UUID>{

}
