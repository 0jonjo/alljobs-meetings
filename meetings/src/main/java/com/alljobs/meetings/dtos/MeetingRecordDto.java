package com.alljobs.meetings.dtos;

import jakarta.validation.constraints.NotNull;

public record MeetingRecordDto(@NotNull Long user_id,@NotNull Long headhunter_id) {
}
