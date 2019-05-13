package com.eventservice;

import com.eventservice.db.service.EventService;
import com.eventservice.dto.EventDTO;
import com.eventservice.mapper.EventMapper;
import lombok.RequiredArgsConstructor;
import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class EventProcessor {
    private static final Logger LOGGER = LoggerFactory.getLogger(EventProcessor.class);

    private final EventService eventService;
    private final EventMapper eventMapper;

    public void processEvent(String jsonProcessingEvent) {

        EventDTO eventMessage = null;

        try {
            eventMessage = new ObjectMapper().readValue(jsonProcessingEvent, EventDTO.class);
        } catch (IOException e) {
            LOGGER.info(String.format("Error during deserializing: %s", e.getMessage()));
        }

        if (eventMessage == null) {
            LOGGER.info("processed eventMessage is null");
        } else {
            eventService.save(eventMapper.toEntity(eventMessage));


        }
    }
}
