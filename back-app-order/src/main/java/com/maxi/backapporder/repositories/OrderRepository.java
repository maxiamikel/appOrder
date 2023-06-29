package com.maxi.backapporder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.backapporder.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(nativeQuery = true, value = "select * from orders  inner join order_item  on orders.id = order_item.order_fk where order_item.order_fk= :id")
    List<Order> findTotalOrder(Long id);

}
