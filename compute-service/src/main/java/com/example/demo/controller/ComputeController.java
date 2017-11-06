package com.example.demo.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ComputeController {
	private final Logger logger = Logger.getLogger(ComputeController.class);
	@Autowired
	private DiscoveryClient client;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public Integer add(@RequestParam Integer a, @RequestParam Integer b) throws Exception {
		ServiceInstance instance = client.getLocalServiceInstance();
		int sleepTime=new Random().nextInt(3000);
		Thread.sleep(sleepTime);
		Integer r = a + b;
		logger.info("/add, host:" + instance.getHost() + ", service_id:" + instance.getServiceId() + ", result:" + r);
		return r;
	}
}
