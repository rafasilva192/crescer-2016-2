/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Classificacao;
import br.com.cwi.crescer.aula8.repository.ClassificacaoRepository;
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
public class ClassificacaoService {
    
    @Autowired
    ClassificacaoRepository repository;
    
    public Page<Classificacao> findAll(Pageable pgb){
        return repository.findAll(pgb);
    }
    
    public Iterable<Classificacao> findAll(){
        return repository.findAll();
    }
    
    public Classificacao save(Classificacao classificacao){
        return repository.save(classificacao);
    }
    
    public Classificacao findOne(Long id){
        return repository.findOne(id);
    }
}
