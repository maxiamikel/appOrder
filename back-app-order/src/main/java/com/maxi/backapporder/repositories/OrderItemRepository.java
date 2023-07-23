package com.maxi.backapporder.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.maxi.backapporder.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

    @Query(nativeQuery = true, value = "SELECT SUM(quantity) FROM order_item WHERE product_fk IN(1,2,3,4) GROUP BY product_fk")
    List<?> orderListValues();
    
     @Query("SELECT SUM(quantity) FROM OrderItem")
    BigDecimal findValorTotalSales();
}
