package com.example.finalproject.Service;

import com.example.finalproject.Model.Hall;
import com.example.finalproject.Model.Reservation;
import com.example.finalproject.Repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServise {

    private final ReservationRepository reservationRepository;


    // 1 get all reservation
    public List<Reservation>getReservation(){
        return reservationRepository.findAll();
    }

    // 2 add new Reservation
    public void addReservation(Reservation reservation){
        reservationRepository.save(reservation);
    }

    // 3 update hall
    public void updateReservation(Reservation reservation, Integer id) {
        Reservation oldOrder=reservationRepository.getById(id);
        oldOrder.setHallName(reservation.getHallName());
        oldOrder.setNumberOfGuste(reservation.getNumberOfGuste());
        oldOrder.setDate(reservation.getDate());
        oldOrder.setPhoneNumber(reservation.getPhoneNumber());
        reservationRepository.save(oldOrder);
    }

    // 4 delete hall
    public void deleteReservation(Integer id) {
        Reservation myOrder=reservationRepository.getById(id);
        reservationRepository.delete(myOrder);
    }

    // 5 find reservation by id
    public Reservation getById(Integer id){
        return reservationRepository.findReservationByid(id);
    }

    // 6 find list of reservation by hall name
    public List<Reservation>getByHallname(String hallName){
        return reservationRepository.findReservationByHallName(hallName);
    }

    // 7 find list of reservation by number of guste
    public List<Reservation>getByNumberOfGuste(Integer numberOfGuste){
        return reservationRepository.findByNumberOfGuste(numberOfGuste);
    }

    // 8 find list of reservation by number of guste greter than
    public List<Reservation>getByNumberOfGusteGreter(Integer numberOfGuste){
        return reservationRepository.findByNumberOfGusteGreaterThanEqual(numberOfGuste);
    }

    // 9 find order by date
    public List<Reservation>getByDate(String date){
        return reservationRepository.findReservationByDate(date);
    }

    // 10 find order by phone number
    public Reservation getByPhoneNumber(String phoneNumber){
        return reservationRepository.findReservationByPhoneNumber(phoneNumber);
    }





}//end
