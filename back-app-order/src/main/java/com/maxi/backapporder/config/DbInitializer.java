package com.maxi.backapporder.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.entities.Order;
import com.maxi.backapporder.entities.OrderItem;
import com.maxi.backapporder.entities.Product;
import com.maxi.backapporder.entities.User;
import com.maxi.backapporder.repositories.ClientRepository;
import com.maxi.backapporder.repositories.OrderItemRepository;
import com.maxi.backapporder.repositories.OrderRepository;
import com.maxi.backapporder.repositories.ProductRepository;
import com.maxi.backapporder.repositories.UserRepository;

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

    @Autowired
    private UserRepository userRepository;

    //@Bean
    public void initialize(){

        Client cli1 = new Client(null, "Amikel Maxi", "mikel@maxi.com");
        Client cli2 = new Client(null, "Myrlande Louissaint Maxi", "myrlande@maxi.com");
        Client cli3 = new Client(null, "Marie Lucienne Maxi Voltaire", "lucienne@maxi.com");
        Client cli4 = new Client(null, "Benite Maxi", "benite@maxi.com");

        Product pc = new Product(null, "Computer DELL AG987",25, 1000.00);
        Product cel = new Product(null, "Samsung S20 PRO",13, 500.0);
        Product mouse = new Product(null, "Samsung Light ",10, 120.0);

        Order o1 = new Order(null,cli2);
        Order o2 = new Order(null,cli2);
        Order o3 = new Order(null,cli1);

        OrderItem i1 = new OrderItem(null, 1, pc, o1);
        OrderItem i2 = new OrderItem(null, 3, pc, o1);
        OrderItem i3 = new OrderItem(null, 1, pc, o3);
        OrderItem i4 = new OrderItem(null, 6, cel, o3);
        OrderItem i5 = new OrderItem(null, 2, cel, o2);
        OrderItem i6 = new OrderItem(null, 1, cel, o2);  
        OrderItem i7 = new OrderItem(null, 3, cel, o3);
        OrderItem i8 = new OrderItem(null, 2, mouse, o1);

        User u1 = new User(null, "Amikel Maxi","900.922.333-12", "amikel@maxi.com","UA-003", "44657678");
        User u2 = new User(null, "Myrlande Louissaint Maxi","900.922.333-02", "amikel@maxi.com", "UA-002", "44657678");
        User u3 = new User(null, "Jean Alberne Maxi","900.922.333-13", "amikel@maxi.com", "UA-001","4657678");

        
        cliRep.saveAll(Arrays.asList(cli1,cli2,cli3,cli4));
        proRep.saveAll(Arrays.asList(pc, cel,mouse));
        ordRep.saveAll(Arrays.asList(o1,o2,o3));
        iteRepo.saveAll(Arrays.asList(i1,i2,i3,i4,i5,i6,i7,i8));
        userRepository.saveAll(Arrays.asList(u1,u2,u3));
    }
    
}
