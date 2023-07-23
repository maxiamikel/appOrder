package com.maxi.backapporder.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.maxi.backapporder.dtos.ClientDTO;
import com.maxi.backapporder.entities.Client;
import com.maxi.backapporder.projections.ClientOrderJoin;
import com.maxi.backapporder.projections.OrderOrderItemClientJoin;
import com.maxi.backapporder.repositories.ClientRepository;
import com.maxi.backapporder.services.exceptions.DataIntegityViolationException;
import com.maxi.backapporder.services.exceptions.NoSuchElementException;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public Client findById(Long id) {
        Optional<Client> obj = clientRepository.findById(id);
        return obj.orElseThrow(() -> new NoSuchElementException("O codigo [" + id + "] informado não foi encontrado"));
    }

    public Page<Client> findAll() {
        Pageable pageable = PageRequest.of(0, 3, Sort.by("nome").ascending());
        return clientRepository.findAll(pageable);
    }

    public List<Client> listarTodos(){
        return clientRepository.findAllCli();
    }

    private Client findExistsClientEmail(String email) {
        Client obj = clientRepository.findByEmail(email);
        if (obj != null) {
            return obj;
        }
        return null;
    }

    public Client create(ClientDTO obj) {
        Client client = findExistsClientEmail(obj.getEmail());
        if (client == null) {
            Client newClient = new Client(null, obj.getNome(), obj.getEmail());
            newClient = clientRepository.saveAndFlush(newClient);
            return newClient;
        } else {
            throw new DataIntegityViolationException("O email informado já está cadastrado no sistema");
        }
    }

    public Client update(Long id, ClientDTO obj) {
        Client client = findById(id);
        if (client.getEmail().equals(obj.getEmail())) {
            client.setNome(obj.getNome());
            return clientRepository.saveAndFlush(client);
        } else {
            throw new DataIntegityViolationException("O email informado não tem coincidência com o seu cadastro");
        }
    }

    public void delete(Long id) {
        Client obj = findById(id);
        if (obj.getOrders().size() > 0) {
            throw new DataIntegityViolationException(
                    "O cliente não pode ser deletado pois tem " + obj.getOrders().size() + " orders associados");
        } else {
            clientRepository.deleteById(id);
        }
    }

    public List<Client> findByName(String name) {
        List<Client> list = clientRepository.findClientByName(name);
        if (list.size() > 0) {
            return list;
        } else {
            throw new NoSuchElementException("Nao encontramos registro pelo nome ["+name.toUpperCase()+"] informado");
        }
    }

    public List<ClientOrderJoin> findAllOrderByClientEmail(String email) {
        List<ClientOrderJoin> list = clientRepository.clientOrderJoin(email);
        return list;
    }

    public List<OrderOrderItemClientJoin> findOrderOrderItemClientJoin(String email){
        List<?> mail = (List<?>) clientRepository.findByEmail(email);
        if(mail.contains(email)){
            List<OrderOrderItemClientJoin> list = clientRepository.findOrderOrderItemClient(email);
            return list;
        }else{
            return null;
        }
    }

}
