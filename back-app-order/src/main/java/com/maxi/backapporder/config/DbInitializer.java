package com.maxi.backapporder.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.entities.Product;
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

        Product pc = new Product(null, "Computer DELL AG987",25, 7800.00);
        Product cel = new Product(null, "Samsung S20 PRO",12, 2000.00);
        Product mouse = new Product(null, "Samsung Light ",10, 120.00);

        Order o1 = new Order(null,cli2);
        Order o2 = new Order(null,cli2);
        Order o3 = new Order(null,cli1);

        OrderItem i1 = new OrderItem(null, 1, 1000.0, pc, o1);
        OrderItem i2 = new OrderItem(null, 3, 500.45, pc, o1);
        OrderItem i3 = new OrderItem(null, 1, 500.45, pc, o3);
        OrderItem i4 = new OrderItem(null, 6, 2500.05, cel, o3);
        OrderItem i5 = new OrderItem(null, 2, 2500.05, cel, o3);
        OrderItem i6 = new OrderItem(null, 1, 2500.05, cel, o3);  
        OrderItem i7 = new OrderItem(null, 3, 2500.05, cel, o3);
        OrderItem i8 = new OrderItem(null, 10, 2500.05, mouse, o1);

        cliRep.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
        proRep.saveAll(Arrays.asList(pc, cel,mouse));
        ordRep.saveAll(Arrays.asList(o1,o2,o3));
        iteRepo.saveAll(Arrays.asList(i1,i2,i3,i4,i5,i6,i7,i8));
    }
    
}
