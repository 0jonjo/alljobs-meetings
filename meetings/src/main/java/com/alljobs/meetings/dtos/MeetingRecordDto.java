package com.alljobs.meetings.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

public record MeetingRecordDto(@NotNull Long user_id, @NotNull Long headhunter_id, @JsonProperty("dateTime") String dateTime, @NotNull String link, @NotNull String status) {
}
