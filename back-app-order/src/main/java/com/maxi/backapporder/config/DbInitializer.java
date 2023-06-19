package com.maxi.backapporder.config;

import java.time.LocalDate;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.entities.Product;
import com.maxi.backapporder.enums.OrderStatus;
import com.maxi.backapporder.repositories.ClientRepository;
import com.maxi.backapporder.repositories.OrderItemRepository;
import com.maxi.backapporder.repositories.OrderRepository;
import com.maxi.backapporder.repositories.ProductRepository;

@Configuration
public class DbInitializer {

    @Autowired
    private ClientRepository cliRep;

    @Autowired
    private ProductRepository proRep;

    @Autowired
    private OrderRepository ordRep;

    @Autowired
    private OrderItemRepository iteRepo;

    @Bean
    public void initialize(){

        Client cli1 = new Client(null, "Amikel Maxi", "mikel@maxi.com");
        Client cli2 = new Client(null, "Myrlande Louissaint Maxi", "myrlande@maxi.com");
        Client cli3 = new Client(null, "Marie Lucienne Maxi Voltaire", "lucienne@maxi.com");
        Client cli4 = new Client(null, "Benite Maxi", "benite@maxi.com");

        Product pc = new Product(null, "Computer DELL AG987", 7800.00);
        Product cel = new Product(null, "Samsung S20 PRO", 2000.00);

        Order o1 = new Order(null, LocalDate.now(), OrderStatus.PAID, cli2);
        Order o2 = new Order(null, LocalDate.now(), OrderStatus.PAID, cli2);
        Order o3 = new Order(null, LocalDate.now(), OrderStatus.VELIVERED, cli1);

        OrderItem i1 = new OrderItem(null, 1, 1000.0, pc, o1);

        cliRep.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
        proRep.saveAll(Arrays.asList(pc, cel));
        ordRep.saveAll(Arrays.asList(o1,o2,o3));
        iteRepo.saveAll(Arrays.asList(i1));
    }
    
}
