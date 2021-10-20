/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.repositories;

import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.entities.Reservation;
import com.rentamaquina.maquinaria.app.repositories.crud.ReservationCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author VALERIA BENITEZ
 */
@Repository
public class ReservationRepository {
        @Autowired
    private ReservationCrudRepository reservationCrudRepository;



 
 public List<Reservation> getAll(){
     return (List<Reservation>) reservationCrudRepository.findAll();
 }
 public Reservation saveReservation(Reservation reservation){
     return reservationCrudRepository.save(reservation);
 } 
 
 public Reservation save(Reservation reservation){
        return reservationCrudRepository.save(reservation);
    }
  public Optional<Reservation> getReservation(int reservationId){
        return reservationCrudRepository.findById(reservationId);
    }

    
    public void delete(Reservation reservation){
        reservationCrudRepository.delete(reservation);
    }

}
