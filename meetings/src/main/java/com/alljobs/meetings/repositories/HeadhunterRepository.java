package com.alljobs.meetings.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.alljobs.meetings.models.HeadhunterModel;

@Repository
public interface HeadhunterRepository extends JpaRepository<HeadhunterModel, Long> {

}
