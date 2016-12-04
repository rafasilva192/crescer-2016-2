package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Elenco;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class ElencoDao extends AbstractDao<Elenco, Long> {

    final EntityManager entityManager;

    public ElencoDao(EntityManager entityManager) {
        super(Elenco.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
