package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.GeneroDao;
import br.com.cwi.crescer.aula5.entity.Genero;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class GeneroBean extends AbstractBean<Genero, Long, GeneroDao> {

    private GeneroDao dao; 

    @Override
    public GeneroDao getDao() {
        if (dao == null) {
            dao = new GeneroDao(this.getEntityManager());
        }
        return dao;
    }

}
