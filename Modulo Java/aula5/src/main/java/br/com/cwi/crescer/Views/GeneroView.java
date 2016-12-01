/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Bean.GeneroDao;
import br.com.cwi.crescer.Entity.Filme;
import br.com.cwi.crescer.Entity.Genero;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author rafael.silva
 */
@ManagedBean
@ViewScoped
public class GeneroView implements Serializable{
    
    @EJB
    private GeneroDao generoDao;
    private Genero genero;
    private List<Genero> generos;
    
     @PostConstruct
    public void init() {
        this.genero = new Genero();
        this.generos = generoDao.findAll();
        this.generos.sort((a,b)-> a.getIdGenero().compareTo(b.getIdGenero()));
        
    }
    
    public Genero getGenero(){
        return genero;
    }
    
    public List<Genero> getGeneros(){
        return generos;
    }
    
    public void setGenero(Genero genero){
        generoDao.insert(genero);
    }
    
    public void adicionar() {
        generoDao.insert(genero);
        this.init();
    }
}
