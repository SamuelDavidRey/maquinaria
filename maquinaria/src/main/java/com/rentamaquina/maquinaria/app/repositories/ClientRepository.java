/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;

import com.rentamaquina.maquinaria.app.entities.Client;
import com.rentamaquina.maquinaria.app.repositories.crud.ClientCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VALERIA BENITEZ
 */
@Repository
public class ClientRepository{
     @Autowired
    private ClientCrudRepository clientCrudRepository;
    
    
    public List<Client> getAll(){
        return (List<Client>) clientCrudRepository.findAll();
    }
    
   public Client saveClient(Client client){
     return clientCrudRepository.save(client);
 } 
    public Client save(Client client){
        return clientCrudRepository.save(client);
    }
    public Optional<Client> getClient(int clientId){
        return clientCrudRepository.findById(clientId);
    }

    
    public void delete(Client client){
        clientCrudRepository.delete(client);
    }

    

}
