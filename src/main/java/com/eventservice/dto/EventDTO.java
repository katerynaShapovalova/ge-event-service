package com.eventservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class EventDTO {

    private Long id;

    private String event;

    private String message;

    private String fileName;

    private Long timestamp;

    private String topic;
}
