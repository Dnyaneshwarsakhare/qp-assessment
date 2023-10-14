package com.questionpro.GroceryBooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.questionpro.GroceryBooking.entities.TbGrocery;

@Repository
public interface GroceryBookingRepository extends JpaRepository<TbGrocery, Integer>{
	
}
