/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Bean.FilmeDao;
import br.com.cwi.crescer.Entity.Filme;
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
public class FilmeView {
    
    @EJB
    private FilmeDao filmeDao;
    private Filme filme;
    private List<Filme> filmes;
    
     @PostConstruct
    public void init() {
        this.filme = new Filme();
        this.filmes = filmeDao.findAll();
        this.filmes.sort((a,b)-> a.getIdFilme().compareTo(b.getIdFilme()));
    }
    
    public Filme getFilme(){
        return filme;
    }
    
    public void setFilme(Filme filme){
        filmeDao.insert(filme);
    }
    
    public void adicionar() {
        filmeDao.insert(filme);
        this.init();
    }
}
