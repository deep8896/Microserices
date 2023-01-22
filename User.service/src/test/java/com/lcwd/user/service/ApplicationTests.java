package com.lcwd.user.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserserviceImpl;

@SpringBootTest
class ApplicationTests {
	
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(UserserviceImpl.class);

	@Test
	void contextLoads() {
		
		
	}
	
	}


