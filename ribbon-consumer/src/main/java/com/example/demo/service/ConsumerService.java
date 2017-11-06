package com.example.demo.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Calendar;
import java.util.Date;

/**
 * @author geqiang on 2017/11/6
 */
@Component
public class ConsumerService {
    private final Logger logger = Logger.getLogger(ConsumerService.class);
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "fallback")
    public String consumer() {
        long start = System.currentTimeMillis();
        String response = restTemplate.getForEntity("http://compute-service/add?a=10&b=20", String.class).getBody();
        long end = System.currentTimeMillis();
        logger.info("spend time:" + (end - start));
        return response;
    }

    public String fallback() {
        return "error";
    }
}
