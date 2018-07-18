package com.sample.kafka.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

import com.sample.models.User;
import com.sample.service.NotificationService;

@Component
public class Receiver {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    private NotificationService notificationService;
    
    @StreamListener(Sink.INPUT)
	public void process(User payload) {
    	notificationService.postNotifications(payload);
    	LOGGER.info("received payload='{}'", payload.toString());
	}
    
//    @StreamListener(Sink.INPUT)
//	public void process(Sensor data) {
//    	LOGGER.info("Data: "+data);
//	}

}
