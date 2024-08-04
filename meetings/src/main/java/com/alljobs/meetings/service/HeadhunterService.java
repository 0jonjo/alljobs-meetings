package com.alljobs.meetings.service;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.alljobs.meetings.models.HeadhunterModel;
import com.alljobs.meetings.repositories.HeadhunterRepository;

import jakarta.transaction.Transactional;

@Service
public class HeadhunterService {

  final HeadhunterRepository HeadhunterRepository;

  public HeadhunterService(HeadhunterRepository HeadhunterRepository) {
    this.HeadhunterRepository = HeadhunterRepository;
  }

  @Transactional
  public HeadhunterModel getHeadhunterById(@PathVariable(value = "id") Long id) {
    return HeadhunterRepository.findById(id).orElse(null);
  }

}
