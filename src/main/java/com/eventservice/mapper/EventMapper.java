package com.eventservice.mapper;

import com.eventservice.db.model.Event;
import com.eventservice.dto.EventDTO;
import org.mapstruct.Mapper;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public abstract class EventMapper implements EntityMapper<EventDTO, Event> {

    @Override
    public Event toEntity(EventDTO dto) {
        if (dto == null) {
            return null;
        }

        Event event = new Event();

        event.setId(dto.getId());
        event.setEvent(dto.getEvent());
        event.setMessage(dto.getMessage());
        event.setFileName(dto.getFileName());
        event.setCreatedTime(BigDecimal.valueOf(dto.getTimestamp()));
        event.setTopic(dto.getTopic());
        return event;
    }

    @Override
    public EventDTO toDto(Event entity) {
        if (entity == null) {
            return null;
        }

        EventDTO eventDTO = new EventDTO();

        eventDTO.setId(entity.getId());
        eventDTO.setEvent(entity.getEvent());
        eventDTO.setMessage(entity.getMessage());
        eventDTO.setFileName(entity.getFileName());
        eventDTO.setTimestamp(entity.getCreatedTime().longValue());
        eventDTO.setTopic(entity.getTopic());

        return eventDTO;
    }
}
