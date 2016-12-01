/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Ator;
import br.com.cwi.crescer.Entity.Bean.ClassificacaoDao;
import br.com.cwi.crescer.Entity.Classificacao;
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
public class ClassificacaoView {
    
    @EJB
    private ClassificacaoDao classificacaoDao;
    private Classificacao classificacao;
    private List<Classificacao> classificacoes;
    
     @PostConstruct
    public void init() {
        this.classificacao = new Classificacao();
        this.classificacoes = classificacaoDao.findAll();
        this.classificacoes.sort((a,b)-> a.getIdClass().compareTo(b.getIdClass()));
        
    }
    
    public Classificacao getClassificacao(){
        return classificacao;
    }
    
    public List<Classificacao> getClassificacoes(){
        return classificacoes;
    }
    
    public void setGenero(Classificacao classificacao){
        classificacaoDao.insert(classificacao);
    }
    
    public void adicionar() {
        classificacaoDao.insert(classificacao);
        this.init();
    }
}