package com.eventservice.db.service;

import com.eventservice.db.model.Event;

import java.util.List;

public interface EventService {

    Event save(Event event);

    List<Event> findAll();
}
