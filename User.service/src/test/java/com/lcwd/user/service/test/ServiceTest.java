package com.lcwd.user.service.test;

import java.util.ArrayList;
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
import com.lcwd.user.service.external.services.RatingService;
import com.lcwd.user.service.repositories.UserRepository;
import com.lcwd.user.service.services.UserserviceImpl;

@SpringBootTest
class UserServiceApplicationTests {

	  @Test
      void contextLoads() {
    	  
      }
      
	  @Autowired
	  private RatingService ratingService;
      @Test
	  void createRating() {
		  Rating rating = Rating.builder().rating(10).userId("").hotelId("").feedback("this is created using fiegn client").build();
		  Rating savedRating = ratingService.createRating(rating);
    	  System.out.println("new rating created");
      }
      
	 }


