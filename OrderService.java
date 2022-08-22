package com.example.finalproject.Service;


import com.example.finalproject.Model.Hall;
import com.example.finalproject.Model.Order;
import com.example.finalproject.Repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;

    // 1 get all order
    public List<Order>getOrder(){

        return orderRepository.findAll();
    }

    // 2 add order
    public void addOrder(Order order) {

        orderRepository.save(order);
    }

    // 3 update hall
    public void updateOrder(Order order, Integer id) {
        Order oldOrder=orderRepository.getById(id);
        oldOrder.setHallName(order.getHallName());
        oldOrder.setNumberOfGuest(order.getNumberOfGuest());
        oldOrder.setDate(order.getDate());
        orderRepository.save(oldOrder);
    }

    // 4 delete hall
    public void deleteOrder(Integer id) {
        Order myOrder=orderRepository.getById(id);
        orderRepository.delete(myOrder);
    }



}// end
