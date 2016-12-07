/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Filme;
import br.com.cwi.crescer.aula8.repository.FilmeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author rafael.silva
 */
@Service
public class FilmeService {
    
    @Autowired
    FilmeRepository repository;
    
    public Page<Filme> findAll(Pageable pgb){
        return repository.findAll(pgb);
    }
    
    public Iterable<Filme> findAll(){
        return repository.findAll();
    }
    
    public Filme save(Filme filme){
        return repository.save(filme);
    }
    
    public Filme findOne(Long id){
        return repository.findOne(id);
    }
}