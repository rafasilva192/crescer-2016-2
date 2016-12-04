package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.ClassificacaoBean;
import br.com.cwi.crescer.aula5.bean.ElencoBean;
import br.com.cwi.crescer.aula5.bean.FilmeBean;
import br.com.cwi.crescer.aula5.bean.GeneroBean;
import br.com.cwi.crescer.aula5.bean.IdiomaBean;
import br.com.cwi.crescer.aula5.dao.FilmeDao;
import br.com.cwi.crescer.aula5.entity.Classificacao;
import br.com.cwi.crescer.aula5.entity.Elenco;
import br.com.cwi.crescer.aula5.entity.Filme;
import br.com.cwi.crescer.aula5.entity.Genero;
import br.com.cwi.crescer.aula5.entity.Idioma;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class FilmeMBean extends AbstractMBean<Filme, Long, FilmeDao, FilmeBean> {

    @EJB
    private FilmeBean filmeBean;

    @EJB
    private GeneroBean generoBean;

    @EJB
    private ClassificacaoBean classificacaoBean;
    
    @EJB
    private ElencoBean elencoBean;
    
    @EJB
    private IdiomaBean idiomaBean;

    private List<Genero> generos;
    private List<Classificacao> classificacoes;
    private List<Elenco> elencos;
    private List<Idioma> idiomas;

    @PostConstruct
    public void init() {
        this.limpar();
    }

    @Override
    public FilmeBean getBean() {
        return filmeBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Filme());
        this.setList(this.getBean().findAll());
        this.setGeneros(this.generoBean.findAll());
        this.setClassificacoes(this.classificacaoBean.findAll());
        this.setElencos(this.elencoBean.findAll());
        this.setIdiomas(this.idiomaBean.findAll());
    }

    @Override
    public void adicionar() {
        super.adicionar(); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Genero> getGeneros() {
        return generos;
    }

    public void setGeneros(List<Genero> generos) {
        this.generos = generos;
    }

    public List<Classificacao> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<Classificacao> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public List<Idioma> getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(List<Idioma> idiomas) {
        this.idiomas = idiomas;
    }

    public List<Elenco> getElencos() {
        return elencos;
    }

    public void setElencos(List<Elenco> elencos) {
        this.elencos = elencos;
    }

}
