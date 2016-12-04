package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.FilmeDao;
import br.com.cwi.crescer.aula5.entity.Filme;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class FilmeBean extends AbstractBean<Filme, Long, FilmeDao> {

    private FilmeDao dao;

    @Override
    public FilmeDao getDao() {
        if (dao == null) {
            dao = new FilmeDao(this.getEntityManager());
        }
        return dao;
    }

}
