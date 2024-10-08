package com.alljobs.meetings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alljobs.meetings.models.AvailableTimeModel;

@Repository
public interface AvaliableTimeRepository extends JpaRepository<AvailableTimeModel, Long> {

}
