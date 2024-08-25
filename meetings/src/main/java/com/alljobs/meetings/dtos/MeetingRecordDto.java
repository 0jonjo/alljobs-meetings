package com.alljobs.meetings.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;

public record MeetingRecordDto(@NotNull Long user_id, @NotNull Long headhunter_id,
    @NotNull LocalDateTime startMeeting, @NotNull LocalDateTime endMeeting, @NotNull String link,
    @NotNull String status, LocalDateTime createdAt, LocalDateTime updatedAt) {
}
