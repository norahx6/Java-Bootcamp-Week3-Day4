package com.example.finalproject.Controller;

import com.example.finalproject.Dto.ApiResponse;
import com.example.finalproject.Model.Hall;
import com.example.finalproject.Model.Order;
import com.example.finalproject.Service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/wedding")
public class OrderController {

    private final OrderService orderService;

    // 1 get all order
    @GetMapping("/order")
    public ResponseEntity<List> getOrder(){
        List<Order>orders=orderService.getOrder();
        return ResponseEntity.status(200).body(orders);
    }

    // 2 add order
    @PostMapping("/order")
    public ResponseEntity<ApiResponse> addOrder(@RequestBody @Valid Order order){
        orderService.addOrder(order);
        return ResponseEntity.status(201).body(new ApiResponse("Order has been added,thank you",201));
    }

    // 3 update order
    @PutMapping("/order/{id}")
    public ResponseEntity<ApiResponse>updateOrder( @RequestBody @Valid Order order ,@PathVariable Integer id){
        orderService.updateOrder(order,id);
        return ResponseEntity.status(201).body(new ApiResponse("Order has been updated,thank you",201));
    }

    // 4 delete order
    @DeleteMapping("/order/{id}")
    public ResponseEntity<ApiResponse>deleteOrder(@PathVariable Integer id){
        orderService.deleteOrder(id);
        return ResponseEntity.status(201).body(new ApiResponse("Order has been deleted,thank you",201));
    }


}// end
