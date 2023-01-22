package com.lcwd.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.entities.Rating;
import com.lcwd.rating.services.RatingService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	private RatingService ratingService;
	//create rating
	@PostMapping
	public ResponseEntity<Rating> create(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.create(rating));
		
	}
	 //get all
	@GetMapping
	public ResponseEntity<List<Rating>> getRating(){
		return ResponseEntity.ok(ratingService.getRating());
		
	}
	
	 //get all of user
	@GetMapping("/users/{userId}")
		public ResponseEntity<List<Rating>> getRatingByuserId(@PathVariable String userId){
			return ResponseEntity.ok(ratingService.getRatingByUserId(userId));
			
		}
		
		 //get all of hotels
		
		@GetMapping("/hotels/{hotelId}")
		public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
			return ResponseEntity.ok(ratingService.getRatingByHotelId(hotelId));
			
		}
	
	
	
	

}
