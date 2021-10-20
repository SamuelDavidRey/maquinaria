/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;

import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.entities.Message;
import com.rentamaquina.maquinaria.app.repositories.crud.MessageCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 *
 * @author VALERIA BENITEZ
 */

@Repository
public class MessageRepository {
    
    @Autowired
    private MessageCrudRepository messageCrudRepository;



 
 public List<Message> getAll(){
     return (List<Message>) messageCrudRepository.findAll();
 }
 
 public Message save(Message message){
        return messageCrudRepository.save(message);
    }
 public Message saveMessage(Message message){
     return messageCrudRepository.save(message);
 } 
  public Optional<Message> getMessage(int messageId){
        return messageCrudRepository.findById(messageId);
    }

    
    public void delete(Message message){
        messageCrudRepository.delete(message);
    }
}
