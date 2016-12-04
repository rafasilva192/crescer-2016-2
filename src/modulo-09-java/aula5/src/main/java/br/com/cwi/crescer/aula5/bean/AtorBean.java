package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.AtorDao;
import br.com.cwi.crescer.aula5.entity.Ator;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class AtorBean extends AbstractBean<Ator, Long, AtorDao> {

    private AtorDao dao;

    @Override
    public AtorDao getDao() {
        if (dao == null) {
            dao = new AtorDao(this.getEntityManager());
        }
        return dao;
    }

}
