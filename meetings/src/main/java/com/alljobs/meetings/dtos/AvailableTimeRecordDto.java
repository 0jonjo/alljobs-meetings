package com.alljobs.meetings.dtos;

import java.time.LocalDateTime;
import java.time.LocalTime;
import jakarta.validation.constraints.NotNull;

public record AvailableTimeRecordDto(@NotNull Long id, @NotNull Long referenceID, @NotNull String referenceType,
    @NotNull Integer dayOfWeek, @NotNull LocalDateTime createdAt, @NotNull LocalDateTime updatedAt,
    @NotNull LocalTime startTimeRange, @NotNull LocalTime endTimeRange) {
}
