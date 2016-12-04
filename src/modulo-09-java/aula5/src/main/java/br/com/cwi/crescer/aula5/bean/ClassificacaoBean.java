package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.ClassificacaoDao;
import br.com.cwi.crescer.aula5.entity.Classificacao;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class ClassificacaoBean extends AbstractBean<Classificacao, Long, ClassificacaoDao> {

    private ClassificacaoDao dao;

    @Override
    public ClassificacaoDao getDao() {
        if (dao == null) {
            dao = new ClassificacaoDao(this.getEntityManager());
        }
        return dao;
    }

}
