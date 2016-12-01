/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;


import br.com.cwi.crescer.Entity.Bean.IdiomaDao;
import br.com.cwi.crescer.Entity.Idioma;
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
public class IdiomaView implements Serializable{
    
    @EJB
    private IdiomaDao idiomaDao;
    private Idioma idioma;
    private List<Idioma> idiomas;
    
     @PostConstruct
    public void init() {
        this.idioma = new Idioma();
        this.idiomas = idiomaDao.findAll();
        this.idiomas.sort((a,b)-> a.getIdIdioma().compareTo(b.getIdIdioma()));
        
    }
    
    public Idioma getIdioma(){
        return idioma;
    }
    
    public List<Idioma> getIdiomas(){
        return idiomas;
    }
    
    public void setIdioma(Idioma idioma){
        idiomaDao.insert(idioma);
    }
    
    public void adicionar() {
        idiomaDao.insert(idioma);
        this.init();
    }
}