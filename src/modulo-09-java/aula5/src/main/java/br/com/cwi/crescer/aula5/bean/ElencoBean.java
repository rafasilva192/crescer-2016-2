package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.ElencoDao;
import br.com.cwi.crescer.aula5.entity.Elenco;
import javax.ejb.Stateless;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class ElencoBean extends AbstractBean<Elenco, Long, ElencoDao> {

    private ElencoDao dao;

    @Override
    public ElencoDao getDao() {
        if (dao == null) {
            dao = new ElencoDao(this.getEntityManager());
        }
        return dao;
    }

}
