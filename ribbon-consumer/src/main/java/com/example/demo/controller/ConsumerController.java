package com.example.demo.controller;

import com.example.demo.service.ConsumerService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author geqiang
 */
@RestController
public class ConsumerController {
	@Autowired
	RestTemplate restTemplate;
	@Autowired
	ConsumerService consumerService;

	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
	}
	@GetMapping("/consumer")
	public String consumer() {
		return consumerService.consumer();
	}
}
