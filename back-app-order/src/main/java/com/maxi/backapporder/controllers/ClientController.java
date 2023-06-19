package com.maxi.backapporder.controllers;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.maxi.backapporder.dtos.ClientDTO;
import com.maxi.backapporder.dtos.ClientOrderJoinDTO;
import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.projections.ClientOrderJoin;
import com.maxi.backapporder.services.ClientService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Client obj = clientService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok().body(clientService.findAll());
    }

    @GetMapping(value = "/name/{name}")
    public ResponseEntity<?> findClientByName(@PathVariable String name) {
        java.util.List<Client> list = clientService.findByName(name);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/new")
    public ResponseEntity<?> create(@Valid @RequestBody ClientDTO obj) {
        Client client = clientService.create(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(client.getId()).toUri();
        return ResponseEntity.created(uri).body(client);
    }

    @PutMapping(value = "/update/{id}")
    public ResponseEntity<?> update(@Valid @PathVariable Long id, @RequestBody ClientDTO obj) {
        Client client = clientService.update(id, obj);
        return ResponseEntity.ok().body(client);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        String msg = "Cadastro deletado com sucesso";
        clientService.delete(id);
        return ResponseEntity.ok().body(msg);
    }


    @GetMapping(value = "/repport/{email}")
    public ResponseEntity<List<ClientOrderJoinDTO>> findAllOrderByClientEmail(@PathVariable String email){
        List<ClientOrderJoin> list = clientService.findAllOrderByClientEmail(email);
        List<ClientOrderJoinDTO> listDTO = list.stream().map( obj -> new ClientOrderJoinDTO(obj)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);
    }

}
