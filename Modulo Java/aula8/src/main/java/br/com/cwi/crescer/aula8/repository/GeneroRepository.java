/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.repository;

import br.com.cwi.crescer.aula8.entity.Genero;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 *
 * @author rafael.silva
 */
public interface GeneroRepository extends PagingAndSortingRepository<Genero, Long>{
    
}
