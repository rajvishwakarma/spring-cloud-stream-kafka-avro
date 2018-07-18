package com.sample.controller;

import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sample.models.Sensor;


@RestController
public class DemoController {
	
	@Autowired
	private Source source;

	private Random random = new Random();

	@RequestMapping(value = "/messages", method = RequestMethod.POST)
	public String sendMessage() {
		source.output().send(MessageBuilder.withPayload(randomSensor()).build());
		return "ok, have fun with v1 payload!";
	}

	private Sensor randomSensor() {
		Sensor sensor = new Sensor();
		sensor.setId(UUID.randomUUID().toString() + "-v1");
		sensor.setAcceleration(random.nextFloat() * 10);
		sensor.setVelocity(random.nextFloat() * 100);
		sensor.setTemperature(random.nextFloat() * 50);
		return sensor;
	}
}