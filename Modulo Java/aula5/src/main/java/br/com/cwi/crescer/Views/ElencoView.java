/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Bean.ElencoDao;
import br.com.cwi.crescer.Entity.Elenco;
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
public class ElencoView {
    
    @EJB
    private ElencoDao elencoDao;
    private Elenco elenco;
    private List<Elenco> elencos;
    
     @PostConstruct
    public void init() {
        this.elenco = new Elenco();
        this.elencos = elencoDao.findAll();
        this.elencos.sort((a,b)-> a.getIdElenco().compareTo(b.getIdElenco()));
        
    }
    
    public Elenco getElenco(){
        return elenco;
    }
    
    public List<Elenco> getElencos(){
        return elencos;
    }
    
    public void setElenco(Elenco elenco){
        elencoDao.insert(elenco);
    }
    
    public void adicionar() {
        elencoDao.insert(elenco);
        this.init();
    }
}