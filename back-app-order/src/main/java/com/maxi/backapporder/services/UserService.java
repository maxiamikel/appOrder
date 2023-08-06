package com.maxi.backapporder.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.dtos.UserDtoCreate;
import com.maxi.backapporder.dtos.UserDtoEdit;
import com.maxi.backapporder.entities.User;
import com.maxi.backapporder.repositories.UserRepository;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User findById(Long id){
        return userRepository.findById(id).orElseThrow( () -> new NoSuchElementException("Não foi possivel encontrar o ID["+id+"] informado"));
    }

    public Page<User> findAll(){
        Pageable pageable = PageRequest.of(0, 2);
        return userRepository.findAllUsers(pageable);
    }

    public List<User> findExistsUserEmail(String email){
        List<User> userList = userRepository.findExistsUserEmail(email);
            return userList;
    }

     public List<User> findExistsUserTelephone(String telephone){
        List<User> userList = userRepository.findExistsUserTelephone(telephone);
            return userList;   
    }

    private List<User> findExistsUserCpf(String cpf) {
        List<User> userList = userRepository.findExistsUserCpf(cpf);
            return userList;
        }

    public Long findMaxId(){
        return userRepository.findMaxId();
    }

        public User create(UserDtoCreate obj){
            Long maxId = findMaxId() + 1;
            String matricule = "";
            List<User> userEmail = findExistsUserEmail(obj.getEmail());
            List<User> userTelep = findExistsUserTelephone(obj.getTelephone());
            List<User> userCpf = findExistsUserCpf(obj.getCpf());
            
            if(userCpf.size() > 0){
                throw new NoSuchElementException("O numero de CPF["+obj.getCpf()+"] informado já existe no sistema");
            }

            if(userEmail.size() > 0){
                throw new NoSuchElementException("O email["+obj.getEmail()+"] informado já existe no sistema");
            }

            if(userTelep.size() > 0){
                throw new NoSuchElementException("O numero de Telefone["+obj.getTelephone()+"] informado já existe no sistema");
            }

            if(maxId < 10){
                matricule = "UA-0" + maxId;
            }else{
                matricule = "UA-" + maxId;
            }
            User user = new User(null, obj.getName(),obj.getCpf(), obj.getEmail(), matricule, obj.getTelephone());
            user.setId(null);
            userRepository.save(user);
            return user;
        }


        public void update(Long id, UserDtoEdit obj){
             User user = findById(id);
             if(!user.getCpf().equals(obj.getCpf())){
                throw new NoSuchElementException("Nao é possivel editar os dados dessa conta porque sua credencial nao foi confirmado.");
             }
             user.setEmail(obj.getEmail());
             user.setName(obj.getName());
             user.setTelephone(obj.getTelephone());
             user.setLastEdit(LocalDateTime.now());
             userRepository.update(obj.getCpf());
        }


}
