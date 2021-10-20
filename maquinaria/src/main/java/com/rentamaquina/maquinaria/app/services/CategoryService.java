/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rentamaquina.maquinaria.app.services;

import com.rentamaquina.maquinaria.app.entities.Category;
import com.rentamaquina.maquinaria.app.entities.Category;
import com.rentamaquina.maquinaria.app.repositories.CategoryRepository;
import com.rentamaquina.maquinaria.app.repositories.CategoryRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author VALERIA BENITEZ
 */
@Service
public class CategoryService {
     @Autowired
    private CategoryRepository repository;
    
    
    public List<Category> getAll(){
        
        return repository.getAll();        
    }
    
    public Optional<Category> getCategory(int categoryId){
        return repository.getCategory(categoryId);
    }
  
    public Category save(Category category){
        if(category.getId()==null){
            return repository.save(category);
        }else{
            Optional<Category> resultado = repository.getCategory(category.getId());
            if(resultado.isPresent()){
                return category;
            }else{
                return repository.save(category);
            }
        }
    }
    
    
    public Category update(Category category){
        if(category.getId() != null){
            Optional<Category> resultado = repository.getCategory(category.getId());
            if(resultado.isPresent()){
                if(category.getName()!=null){
                    resultado.get().setName(category.getName());
                }
                if(category.getDescription()!=null){
                    resultado.get().setDescription(category.getDescription());
                }
                
                repository.save(resultado.get());
                return resultado.get();
            }else{
                return category;
            }
        }else{
            return category;
        }
    }
    
  
    public boolean deleteCategory(int categoryId) {
        Boolean aBoolean = getCategory(categoryId).map(category -> {
            repository.delete(category);
            return true;
        }).orElse(false);
        return aBoolean;
    }



}

