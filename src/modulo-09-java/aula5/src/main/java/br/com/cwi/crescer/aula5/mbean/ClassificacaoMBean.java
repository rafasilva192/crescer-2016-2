package br.com.cwi.crescer.aula5.mbean;

import br.com.cwi.crescer.aula5.bean.ClassificacaoBean;
import br.com.cwi.crescer.aula5.dao.ClassificacaoDao;
import br.com.cwi.crescer.aula5.entity.Classificacao;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 * @author Carlos H. Nonnemacher
 */
@ManagedBean
@ViewScoped
public class ClassificacaoMBean extends AbstractMBean<Classificacao, Long, ClassificacaoDao, ClassificacaoBean> {

    @EJB
    private ClassificacaoBean classificacaoBean;

    @PostConstruct
    public void init() {
        this.limpar();
    }
    
    @Override
    public ClassificacaoBean getBean() {
        return classificacaoBean;
    }

    @Override
    public void limpar() {
        this.setEntity(new Classificacao());
        this.setList(this.getBean().findAll());
    }

}
