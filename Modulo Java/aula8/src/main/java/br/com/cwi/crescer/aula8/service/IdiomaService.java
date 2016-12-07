/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Idioma;
import br.com.cwi.crescer.aula8.repository.IdiomaRepository;
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
public class IdiomaService {
    
    @Autowired
    IdiomaRepository repository;
    
    public Page<Idioma> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Idioma> findAll() {
        return repository.findAll();
    }
    
    public Idioma save(Idioma idioma){
        return repository.save(idioma);
    }
    
    public Idioma findOne(Long id){
        return repository.findOne(id);
    }
}
