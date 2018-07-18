package com.sample.kafka.producers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.sample.models.UserData;

@Component
public class Sender {

	private static final Logger LOGGER = LoggerFactory.getLogger(Sender.class);

	@Autowired
	private Source source;

	public void send(UserData payload) {
		LOGGER.info("sending payload='{}'", payload.toString());
		source.output().send(MessageBuilder.withPayload(payload).build());
	}
}
