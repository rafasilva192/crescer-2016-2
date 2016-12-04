package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.GeneroBean;
import br.com.cwi.crescer.aula5.dao.GeneroDao;
import br.com.cwi.crescer.aula5.entity.Genero;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class GeneroMBean extends AbstractMBean<Genero, Long, GeneroDao, GeneroBean> {

    @EJB
    private GeneroBean generoBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }
    
    @Override
    public GeneroBean getBean() {
        return generoBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Genero());
        this.setList(this.getBean().findAll());
    }

}
