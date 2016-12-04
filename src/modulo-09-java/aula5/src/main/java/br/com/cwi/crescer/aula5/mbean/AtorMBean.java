package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.AtorBean;
import br.com.cwi.crescer.aula5.dao.AtorDao;
import br.com.cwi.crescer.aula5.entity.Ator;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class AtorMBean extends AbstractMBean<Ator, Long, AtorDao, AtorBean> {

    @EJB
    private AtorBean atorBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }
    
    @Override
    public AtorBean getBean() {
        return atorBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Ator());
        this.setList(this.getBean().findAll());
    }

}
