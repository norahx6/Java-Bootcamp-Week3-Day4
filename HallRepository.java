package com.example.finalproject.Repository;


import com.example.finalproject.Model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HallRepository extends JpaRepository<Hall,Integer> {

    // find hall by id
    Hall findHallById(Integer id);
    // find hall by name
    Hall findHallByName(String name);
    // find hall by number of guest
    Hall findByNumberOfGuestEquals(Integer numberOfGuest);
    // find list of hall by number of guest
    List<Hall>findByNumberOfGuestGreaterThanEqual(Integer numberOfGuest);
    // find hall by price
    Hall findHallByPriceEquals(Integer price);
    // find list of hall by price
    List<Hall>findHallByPriceGreaterThanEqual(Integer price);




}// end
