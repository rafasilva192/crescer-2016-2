/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import static javax.persistence.CascadeType.ALL;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author rafael.silva
 */
@Entity
@Table(name = "FILME")
public class Filme implements Serializable {
    
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILME")
    @SequenceGenerator(name = "SEQ_FILME", sequenceName = "SEQ_FILME", allocationSize = 1) 
    @Basic(optional = false)
    @Column(name = "ID_FILME")
    private Long idFilme;
    
    @Basic(optional = false)
    @Column(name = "NM_FILME")
    private String nmFilme;
    
    @Basic(optional = false)
    @Column(name = "NM_DIRETOR")
    private String nmDiretor;
    
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "ID_GENERO")
    private Genero genero;
    
    @Basic(optional = false)
    @Column(name = "DT_LANCAMENTO")
    @Temporal(TemporalType.DATE)
    private Date dtLancamento;
    
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "ID_ELENCO")
    private Elenco elenco;
    
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "ID_CLASSIFICACAO")
    private Classificacao classificacao;
    
    @ManyToOne(cascade = ALL)
    @JoinColumn(name = "ID_IDIOMA")
    private Idioma idioma;

    public Long getIdFilme() {
        return idFilme;
    }

    public void setIdFilme(Long idFilme) {
        this.idFilme = idFilme;
    }

    public String getNmFilme() {
        return nmFilme;
    }

    public void setNmFilme(String nmFilme) {
        this.nmFilme = nmFilme;
    }

    public String getNmDiretor() {
        return nmDiretor;
    }

    public void setNmDiretor(String nmDiretor) {
        this.nmDiretor = nmDiretor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Date getDtLancamento() {
        return dtLancamento;
    }

    public void setDtLancamento(Date dtLancamento) {
        this.dtLancamento = dtLancamento;
    }

    public Elenco getElenco() {
        return elenco;
    }

    public void setElenco(Elenco elenco) {
        this.elenco = elenco;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }
}
