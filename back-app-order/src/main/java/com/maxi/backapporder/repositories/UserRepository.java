package com.maxi.backapporder.repositories;

import java.util.List;

//import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.maxi.backapporder.entities.User;

public interface UserRepository extends JpaRepository /*PagingAndSortingRepository*/<User, Long>{
    
    @Query("SELECT u FROM User u")
    Page<User> findAllUsers(Pageable pageable);

    @Query("SELECT u FROM User u WHERE UPPER(u.name) LIKE UPPER(?1) ")
    List<User> findByUserName(String name);

    @Query("select u from User u where u.email = :email")
    List<User> findExistsUserEmail(@Param("email") String email);

    @Query("select u from User u where u.cpf = :cpf")
    List<User> findExistsUserCpf(@Param("cpf") String cpf);
    
     @Query("select u from User u where u.telephone = :telephone")
    List<User> findExistsUserTelephone(@Param("telephone") String telephone);

    @Query("SELECT MAX(id) FROM User")
    Long findMaxId();

    @Modifying
    @Query("UPDATE User u SET u.name=name, u.email=email,u.telephone=telephone WHERE u.cpf = ?1")
    //@Query("UPDATE Tutorial t SET t.published=true WHERE t.id=?1")
    void update( String cpf);
}
