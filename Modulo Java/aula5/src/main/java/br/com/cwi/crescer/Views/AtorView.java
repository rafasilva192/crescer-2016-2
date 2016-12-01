/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Ator;
import br.com.cwi.crescer.Entity.Bean.AtorDao;
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
public class AtorView {
    
    @EJB
    private AtorDao atorDao;
    private Ator ator;
    private List<Ator> atores;
    
     @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorDao.findAll();
        this.atores.sort((a,b)-> a.getIdAtor().compareTo(b.getIdAtor()));
        
    }
    
    public Ator getAtor(){
        return ator;
    }
    
    public List<Ator> getAtores(){
        return atores;
    }
    
    public void setGenero(Ator ator){
        atorDao.insert(ator);
    }
    
    public void adicionar() {
        atorDao.insert(ator);
        this.init();
    }
}