package com.maxi.backapporder.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.dtos.OrderItemDTO;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.entities.Product;
import com.maxi.backapporder.repositories.OrderItemRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderService orderService;

    public OrderItem findById(Long id) {
        Optional<OrderItem> obj = orderItemRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado"));
    } 

    public List<?> getListItems(){
        List<?> list = new ArrayList<>();
        list = orderItemRepository.orderListValues();
        return list;
    }

    public Integer veririfyStock(Long id, Integer qty){
        
        productService.findById(id);

        Integer dispoProduct = productService.findProductStock(id);

        Integer totalSelleded = orderItemRepository.findTotalItemOrder(id);
        if(totalSelleded == null){
            totalSelleded =0;
        }
        Integer stock = dispoProduct - totalSelleded;
        if(stock >= qty){
            return dispoProduct-totalSelleded;
        }else{
            throw new NoSuchElementException("Não temos esse ["+qty+"] disponivel, tem  ["+ dispoProduct +"] disponivel em estoque");
        }
    } 

    public Integer findTotalItemOrder(Long id){
        Integer total = orderItemRepository.findTotalItemOrder(id);
        return total;
    }

    public OrderItem create(OrderItemDTO obj){
        Product product = productService.findById(obj.getProduct().getId());
        Integer stock = productService.findProductStock(product.getId());
        Order order = orderService.findById(obj.getOrder().getId());
        OrderItem newOrderItem = new OrderItem(null, obj.getQuantity(), product, order);
        this.veririfyStock(product.getId(), obj.getQuantity());
        productService.stockUpdate((stock - obj.getQuantity()), product.getId());
        orderItemRepository.saveAndFlush(newOrderItem);
        //orderService.updateTotalOrderPrice(order.getId());
        return newOrderItem;
    }
}
