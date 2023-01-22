package com.lcwd.user.service.external.services;

import javax.ws.rs.PUT;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.lcwd.user.service.entities.Rating;
@Service 
@FeignClient(name="RATING-SERVICE")
public interface RatingService {

	//GET
	
	
	
	//POST
	@PostMapping("/rating")
	public Rating createRating(Rating value);
	
	
	//PUT
	@PutMapping("/rating/{ratingId}")
	public Rating updateRating(@PathVariable("ratingId")String ratingId,Rating rating);

    @DeleteMapping("/rating/{ratingId}")
   public void deleteRating(@PathVariable String ratingId);

}
