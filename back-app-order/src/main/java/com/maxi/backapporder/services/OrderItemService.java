package com.maxi.backapporder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.repositories.OrderItemRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem findById(Long id) {
        Optional<OrderItem> obj = orderItemRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado"));
    } 

    public List<?> getListItems(){
        List<?> list = new ArrayList<>();
        list = orderItemRepository.orderListValues();
        Integer a = list.indexOf(19);
        System.out.println(a);
        return list;
    }

    
}
