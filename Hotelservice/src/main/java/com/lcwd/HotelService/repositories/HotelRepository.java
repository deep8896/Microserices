package com.lcwd.HotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lcwd.HotelService.entities.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, String> {

}
