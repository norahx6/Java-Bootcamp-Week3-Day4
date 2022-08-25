package com.example.finalproject.Repository;


import com.example.finalproject.Model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    // find order by id
    Reservation findReservationByid(Integer id);

    // find order by hall name
    List<Reservation> findReservationByHallName(String hallName);

    // find order by number of guste
    List<Reservation>findByNumberOfGuste(Integer numberOfGuste);

    // find order by number of guste greter than
    List<Reservation>findByNumberOfGusteGreaterThanEqual(Integer numberOfGuste);

    // find order date
    List<Reservation>findReservationByDate(String date);

    // find by phone number
    Reservation findReservationByPhoneNumber(String phoneNumber);

}// end
