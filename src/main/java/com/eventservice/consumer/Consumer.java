package com.eventservice.consumer;

import com.eventservice.EventProcessor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class Consumer {
    private final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    private final EventProcessor eventProcessor;

    @KafkaListener(topics = "${notification.topic}", groupId = "group_id")
    public void processMessageEvent(String jsonProcessingEvent) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", jsonProcessingEvent));

        eventProcessor.processEvent(jsonProcessingEvent);
    }
}
