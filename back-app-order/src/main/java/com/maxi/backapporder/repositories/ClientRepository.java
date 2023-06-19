package com.maxi.backapporder.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.projections.ClientOrderJoin;

public interface ClientRepository extends JpaRepository<Client, Long> {

    //@Query("select c.email from Client c where c.email :=email")
    Client findByEmail(String email);

    @Query(nativeQuery = true, value = "select * from clients where nome like %:name%")
    List<Client> findClientByName(@Param("name") String name);

    @Query(nativeQuery = true, value = "SELECT clients.nome,clients.email,orders.order_date, orders.status FROM clients    INNER join orders on clients.id = orders.client_fk where clients.email = :email")
    //SELECT clients.nome,clients.email,orders.order_date, orders.status FROM clients    INNER join orders on clients.id = orders.client_fk WHERE clients.email='myrlande@maxi.com';
    List<ClientOrderJoin> clientOrderJoin(@Param("email") String email) ;
    
}
