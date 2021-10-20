/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Admin;
import com.rentamaquina.maquinaria.app.repositories.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VALERIA BENITEZ
 */
@Service
public class AdminService {
    @Autowired
    private AdminRepository repository;
    
    
    public List<Admin> getAll(){
        
        return repository.getAll();        
    }
    
    public Optional<Admin> getAdmin(int adminId){
        return repository.getAdmin(adminId);
    }
  
    public Admin save(Admin admin){
        if(admin.getIdAdmin()==null){
            return repository.save(admin);
        }else{
            Optional<Admin> resultado = repository.getAdmin(admin.getIdAdmin());
            if(resultado.isPresent()){
                return admin;
            }else{
                return repository.save(admin);
            }
        }
    }
    
    
    public Admin update(Admin admin){
        if(admin.getIdAdmin() != null){
            Optional<Admin> resultado = repository.getAdmin(admin.getIdAdmin());
            if(resultado.isPresent()){
                if(admin.getName()!=null){
                    resultado.get().setName(admin.getName());
                }
                if(admin.getEmail()!=null){
                    resultado.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    resultado.get().setPassword(admin.getPassword());
                }
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }
    
  
    public boolean deleteAdmin(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            repository.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
   
}
