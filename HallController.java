package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Hall;
import com.example.finalproject.Service.HallService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wedding")
public class HallController {

    private final HallService hallService;

    // 1 get all halls
    @GetMapping("/get")
    public ResponseEntity<List>getHalls(){
        List<Hall>halls=hallService.getHalls();
        return ResponseEntity.status(200).body(halls);
    }

    // 2 add hall
    @PostMapping("/hall")
    public ResponseEntity<ApiResponse> addHall(@RequestBody @Valid Hall hall){
        hallService.addHall(hall);
        return ResponseEntity.status(201).body(new ApiResponse("Hall has been added,thank you",201));
    }

    // 3 update hall
    @PutMapping("/hall/{id}")
    public ResponseEntity<ApiResponse>updateHall( @RequestBody @Valid Hall hall ,@PathVariable Integer id){
        hallService.updateHall(hall,id);
        return ResponseEntity.status(201).body(new ApiResponse("Hall has been updated,thank you",201));
    }

    // 4 delete hall
    @DeleteMapping("/hall/{id}")
    public ResponseEntity<ApiResponse>deleteHall(@PathVariable Integer id){
        hallService.deleteHall(id);
        return ResponseEntity.status(201).body(new ApiResponse("Hall has been deleted,thank you",201));
    }

    // 5 find hall by id
    @GetMapping("/get/id")
    public ResponseEntity getHallById(@RequestParam Integer id){
        Hall hall = hallService.getHallById(id);
        return ResponseEntity.status(200).body(hall);
    }

    // 6 find hall by name
    @GetMapping("/get/name")
    public ResponseEntity getHallByName(@RequestParam String name){
        Hall hall = hallService.getHallByName(name);
        return ResponseEntity.status(200).body(hall);
    }

    // 7 find hall by number of guest
    @GetMapping("/get/guest")
    public ResponseEntity getNumberOfGuest(@RequestParam Integer numberOfGuest){
        Hall hall = hallService.getNumberOfgGuest(numberOfGuest);
        return ResponseEntity.status(200).body(hall);
    }

    // 8 find list of hall by number of guest
    @GetMapping("/get/guests")
    public ResponseEntity<List<Hall>>getNumberOfGuestGreter(@RequestParam Integer numberOfGuest){
        List<Hall>halls = hallService.findByNumberOfGuestGreaterThanEqual(numberOfGuest);
        return ResponseEntity.status(200).body(halls);
    }

    // 9 find hall by price
    @GetMapping("/get/price")
    public ResponseEntity getHallByPrice(@RequestParam Integer price){
        Hall hall = hallService.getHallByPrice(price);
        return ResponseEntity.status(200).body(hall);
    }

    // 10 find list of hall by price
    @GetMapping("/get/prices")
    public ResponseEntity<List<Hall>>getHallByPriceGreter(@RequestParam Integer price){
        List<Hall>halls= hallService.findHallByPriceGreaterThanEqual(price);
        return ResponseEntity.status(200).body(halls);
    }


}// end
