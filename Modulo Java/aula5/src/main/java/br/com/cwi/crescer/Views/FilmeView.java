/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Views;

import br.com.cwi.crescer.Entity.Ator;
import br.com.cwi.crescer.Entity.Bean.AtorDao;
import br.com.cwi.crescer.Entity.Bean.ClassificacaoDao;
import br.com.cwi.crescer.Entity.Bean.ElencoDao;
import br.com.cwi.crescer.Entity.Bean.FilmeDao;
import br.com.cwi.crescer.Entity.Bean.GeneroDao;
import br.com.cwi.crescer.Entity.Bean.IdiomaDao;
import br.com.cwi.crescer.Entity.Classificacao;
import br.com.cwi.crescer.Entity.Elenco;
import br.com.cwi.crescer.Entity.Filme;
import br.com.cwi.crescer.Entity.Genero;
import br.com.cwi.crescer.Entity.Idioma;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class FilmeView implements Serializable {

    @EJB
    private FilmeDao filmeDao;
    @EJB
    private ElencoDao elencoDao;
    @EJB
    private GeneroDao generoDao;
    @EJB
    private IdiomaDao idiomaDao;
    @EJB
    private ClassificacaoDao classificacaoDao;

    private Filme filme;
    private List<Filme> filmes;
    private List<Elenco> elencos;
    private List<Genero> generos;
    private List<Idioma> idiomas;
    private List<Classificacao> classificacoes;

    private Long idElenco;
    private Long idGenero;
    private Long idIdioma;
    private Long idClassificacao;
    private String dataLancamento;

    @PostConstruct
    public void init() {
        this.filme = new Filme();
        limparList();
        this.filmes = filmeDao.findAll();
        this.elencos = elencoDao.findAll();
        this.generos = generoDao.findAll();
        this.idiomas = idiomaDao.findAll();
        this.classificacoes = classificacaoDao.findAll();

        this.filmes.sort((a, b) -> a.getIdFilme().compareTo(b.getIdFilme()));
    }

    public void adicionar() {
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        try {
            this.filme.setDtLancamento(formatter.parse(this.dataLancamento));
        } catch (ParseException ex) {
            Logger.getLogger(FilmeView.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.filme.setElenco(this.elencoDao.find(this.idElenco));
        this.filme.setGenero(this.generoDao.find(this.idGenero));
        this.filme.setIdioma(this.idiomaDao.find(this.idIdioma));
        this.filme.setClassificacao(this.classificacaoDao.find(this.idClassificacao));
        filmeDao.insert(filme);
        this.init();
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }

    public List<Filme> getFilmes() {
        return filmes;
    }

    public void setFilmes(List<Filme> filmes) {
        this.filmes = filmes;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

    public Long getIdElenco() {
        return idElenco;
    }

    public String getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(String dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public void setIdElenco(Long idElenco) {
        this.idElenco = idElenco;
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public Long getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(Long idGenero) {
        this.idGenero = idGenero;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public Long getIdClassificacao() {
        return idClassificacao;
    }

    public void setIdClassificacao(Long idClassificacao) {
        this.idClassificacao = idClassificacao;
    }

    private void limparList() {
        this.idElenco = 0l;
        this.idGenero = 0l;
        this.idIdioma = 0l;
        this.idClassificacao = 0l;
        this.dataLancamento = null;
    }

}
