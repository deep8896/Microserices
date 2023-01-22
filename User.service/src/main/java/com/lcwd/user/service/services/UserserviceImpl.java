package com.lcwd.user.service.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.service.entities.Hotel;
import com.lcwd.user.service.entities.Rating;
import com.lcwd.user.service.entities.User;
import com.lcwd.user.service.exceptions.ResourceNotFoundException;
import com.lcwd.user.service.external.services.HotelService;
import com.lcwd.user.service.repositories.UserRepository;
@Service
public class UserserviceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private HotelService hotelService;
	
private Logger logger = LoggerFactory.getLogger(UserserviceImpl.class);
	
	@Override
	public User saveUser(User user) {
		
		// generate unique userid
       String randomUserId = UUID.randomUUID().toString();
	   user.setUserId(randomUserId);
       return userRepository.save(user);
	}

	@Override
	public List<User> getAllUser() {
		
		return  userRepository.findAll();
		
	}

/*	
	// get single user
	@Override
	public User getUser(String userId) {
		//get user from database with the help  of user repository
		User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server!!:"+userId));
	    // fetch rating of above user from RATING SERVICE 
		//http://localhost:8083/rating/users/675e9653-4c1e-4645-af50-3e1973a6a835
		ArrayList<Rating> ratingOfUser = restTemplate.getForObject("http://localhost:8083/rating/users/"+user.getUserId(),ArrayList.class);
		 logger.info("{} ",ratingOfUser);
		 user.setRating(ratingOfUser);
		
		return user;
	
	
	}
	*/
	 // get single user
	   @Override 
	   public User getUser(String userId) { 
	   //get user from database with the help  of user repository
	    User user = userRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User with given id is not found on server!!:"+userId)); 
	    // fetch rating of above user from RATING SERVICE 
	   //http://localhost:8083/rating/users/675e9653-4c1e-4645-af50-3e1973a6a835 
	//    Rating[] ratingOfUser = restTemplate.getForObject("http://localhost:8083/rating/users/"+user.getUserId(),Rating[].class);
	    Rating[] ratingOfUser = restTemplate.getForObject("http://RATING-SERVICE/rating/users/"+user.getUserId(),Rating[].class);
	     logger.info("{}",ratingOfUser);
	     
	     List<Rating> ratings = Arrays.stream(ratingOfUser).collect(Collectors.toList());
	     
	     List<Rating> ratingList = ratings.stream().map(rating -> {
	    	 //api call to hotel service to get the hotel
		     //http://localhost:8082/hotels/11f89caa-5b46-4407-8acd-410be037330b
	    	 
//	    	 ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
//	    	 ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//	    	 Hotel hotel = forEntity.getBody();
	    	 Hotel hotel = hotelService.getHotel(rating.getHotelId());
//	    	 logger.info("response status code:  {} ",forEntity.getStatusCode());
	    	
	    	 //set the hotel to rating 
	    	 rating.setHotel(hotel);
		      //return the rating
	    	 return rating;
	     }).collect(Collectors.toList());
	        user.setRating(ratingList); 
	       return user; 
	       } 

}
