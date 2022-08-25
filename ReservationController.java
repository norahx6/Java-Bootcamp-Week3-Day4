package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Hall;
import com.example.finalproject.Model.Reservation;
import com.example.finalproject.Service.ReservationServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wedding")
public class ReservationController {

    private final ReservationServise reservationServise;

    // 1 get all reservation
    @GetMapping("/order")
    public ResponseEntity<List>getReservation(){
        List<Reservation>reservations=reservationServise.getReservation();
        return ResponseEntity.status(200).body(reservations);
    }

    // 2 add new reservation
    @PostMapping("/order")
    public ResponseEntity<ApiResponse> addReservation(@RequestBody @Valid Reservation reservation){
        reservationServise.addReservation(reservation);
        return ResponseEntity.status(201).body(new ApiResponse("Reservation has been added,thank you",201));
    }

    // 3 update reservation
    @PutMapping("/order/{id}")
    public ResponseEntity<ApiResponse>updateReservation( @RequestBody @Valid Reservation reservation ,@PathVariable Integer id){
        reservationServise.updateReservation(reservation,id);
        return ResponseEntity.status(201).body(new ApiResponse("Reservation has been updated,thank you",201));
    }

    // 4 delete Reservation
    @DeleteMapping("/order/{id}")
    public ResponseEntity<ApiResponse>deleteReservation(@PathVariable Integer id){
        reservationServise.deleteReservation(id);
        return ResponseEntity.status(201).body(new ApiResponse("Reservation has been deleted,thank you",201));
    }

    // 5 find reservation by id
    @GetMapping("order/id")
    public ResponseEntity getById(@RequestParam Integer id){
        Reservation reservation = reservationServise.getById(id);
        return ResponseEntity.status(201).body(reservation);
    }

    // 6 find list of reservation by hall name
    @GetMapping("order/hallname")
    public ResponseEntity<List<Reservation>>getByHallname(@RequestParam String hallName){
        List<Reservation>reservations = reservationServise.getByHallname(hallName);
        return ResponseEntity.status(201).body(reservations);
    }

    // 7 find list of reservation by number of guste
    @GetMapping("/order/guste")
    public ResponseEntity<List<Reservation>>getByNumberOfGuste(@RequestParam Integer numberOfGuste){
        List<Reservation>reservations=reservationServise.getByNumberOfGuste(numberOfGuste);
        return ResponseEntity.status(201).body(reservations);
    }

    // 8 find list of reservation by number of guste greter
    @GetMapping("/order/gustes")
    public ResponseEntity<List<Reservation>>getByNumberOfGusteGreter(@RequestParam Integer numberOfGuste){
        List<Reservation>reservations=reservationServise.getByNumberOfGusteGreter(numberOfGuste);
        return ResponseEntity.status(201).body(reservations);
    }

    // 9 find order by date
    @GetMapping("/order/date")
    public ResponseEntity<List<Reservation>>getByDate(@RequestParam String date){
        List<Reservation>reservations=reservationServise.getByDate(date);
        return ResponseEntity.status(201).body(reservations);
    }

    // 10 find by phone number
    @GetMapping("/order/phone")
    public ResponseEntity getByPhoneNumber(@RequestParam String phoneNumber){
        Reservation reservation= reservationServise.getByPhoneNumber(phoneNumber);
        return ResponseEntity.status(201).body(reservation);
    }



}// end
