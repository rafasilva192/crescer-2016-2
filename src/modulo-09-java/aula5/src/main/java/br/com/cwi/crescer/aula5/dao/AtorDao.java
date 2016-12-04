package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Ator;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class AtorDao extends AbstractDao<Ator, Long> {

    final EntityManager entityManager;

    public AtorDao(EntityManager entityManager) {
        super(Ator.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
