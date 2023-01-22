package com.lcwd.HotelService.services;

import java.util.List;

import com.lcwd.HotelService.entities.Hotel;

public interface HotelService {
	
	// create
	
	Hotel create(Hotel hotel);
	
	
	//get all
	
	List<Hotel> getAll();
	
	//get single
	
	Hotel get(String id);

}
