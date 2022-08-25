package com.example.finalproject.Service;

import com.example.finalproject.Model.Hall;
import com.example.finalproject.Repository.HallRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HallService {

    private final HallRepository hallRepository;


    // 1 get all halls
    public List<Hall> getHalls(){

        return hallRepository.findAll();
    }

    // 2 add halls
    public void addHall(Hall hall) {

        hallRepository.save(hall);
    }

    // 3 update hall
    public void updateHall(Hall hall, Integer id) {
        Hall oldHall=hallRepository.getById(id);
        oldHall.setName(hall.getName());
        oldHall.setNumberOfGuest(hall.getNumberOfGuest());
        oldHall.setPrice(hall.getPrice());
        hallRepository.save(oldHall);
    }

    // 4 delete hall
    public void deleteHall(Integer id) {
        Hall myHall=hallRepository.getById(id);
        hallRepository.delete(myHall);
    }

    // 5 find hall by id
    public Hall getHallById(Integer id){
        return hallRepository.findHallById(id);
    }

    // 6 find hall by name
    public Hall getHallByName(String name){
        return hallRepository.findHallByName(name);
    }

    // 7 find hall by number of guest
    public Hall getNumberOfgGuest(Integer numberOfGuest){
        return hallRepository.findByNumberOfGuestEquals(numberOfGuest);
    }

    // 8 find list of hall by number of guest
    public List<Hall>findByNumberOfGuestGreaterThanEqual(Integer numberOfGuest){
        return hallRepository.findByNumberOfGuestGreaterThanEqual(numberOfGuest);
    }

    // 9 find hall by price
    public Hall getHallByPrice(Integer price){
        return hallRepository.findHallByPriceEquals(price);
    }

    // 10 find list of hall by price
    public List<Hall>findHallByPriceGreaterThanEqual(Integer price){
        return hallRepository.findHallByPriceGreaterThanEqual(price);
    }





}// end
