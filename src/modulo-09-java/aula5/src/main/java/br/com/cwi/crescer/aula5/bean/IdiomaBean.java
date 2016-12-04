package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.IdiomaDao;
import br.com.cwi.crescer.aula5.entity.Idioma;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class IdiomaBean extends AbstractBean<Idioma, Long, IdiomaDao> {

    private IdiomaDao dao;

    @Override
    public IdiomaDao getDao() {
        if (dao == null) {
            dao = new IdiomaDao(this.getEntityManager());
        }
        return dao;
    }

}
