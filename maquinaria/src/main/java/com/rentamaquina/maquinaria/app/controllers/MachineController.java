/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.controllers;


import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.entities.Machine;
import com.rentamaquina.maquinaria.app.services.MachineService;
import com.rentamaquina.maquinaria.app.services.MachineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author samuel
 */
@RestController
@RequestMapping("Machine")
public class MachineController {
     @Autowired
    private MachineService service;
    
    @GetMapping("/all")
    public List<Machine> getMachines(){
        return service.getAll();
    }
   @PostMapping("/save")
   @ResponseStatus(HttpStatus.CREATED)
   public Machine save(@RequestBody Machine machine){
       return service.save(machine);
   }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Machine update(@RequestBody Machine machine){
       return service.update(machine);
   } 
  @DeleteMapping("/delete/{id}")
    public boolean delete(@PathVariable("id") int machineId) {
        return service.deleteMachine(machineId);
    }

    
}

