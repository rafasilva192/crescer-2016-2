package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.IdiomaBean;
import br.com.cwi.crescer.aula5.dao.IdiomaDao;
import br.com.cwi.crescer.aula5.entity.Idioma;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class IdiomaMBean extends AbstractMBean<Idioma, Long, IdiomaDao, IdiomaBean> {

    @EJB
    private IdiomaBean idiomaBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }

    @Override
    public IdiomaBean getBean() {
        return idiomaBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Idioma());
        this.setList(this.getBean().findAll());
    }

}
