/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Ator;
import br.com.cwi.crescer.Entity.Bean.AtorDao;
import br.com.cwi.crescer.Entity.Bean.ElencoDao;
import br.com.cwi.crescer.Entity.Elenco;
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
public class AtorView implements Serializable {

    @EJB
    private ElencoDao elencoDao;
    @EJB
    private AtorDao atorDao;

    private Elenco elenco;
    private List<Elenco> elencos;

    private Ator ator;
    private List<Ator> atores;

    private Long idElenco;
    
    @PostConstruct
    public void init() {
        this.ator = new Ator();
        this.atores = atorDao.findAll();
        this.atores.sort((a, b) -> a.getIdAtor().compareTo(b.getIdAtor()));
        this.elencos = elencoDao.findAll();

    }

    public void adicionar() {
        this.ator.setElenco(this.elencoDao.find(this.idElenco));
        atorDao.insert(ator);
        this.init();
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public Ator getAtor() {
        return ator;
    }

    public void setAtor(Ator ator) {
        this.ator = ator;
    }

    public List<Ator> getAtores() {
        return atores;
    }

    public void setAtores(List<Ator> atores) {
        this.atores = atores;
    }

    public Long getIdElenco() {
        return idElenco;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

}
