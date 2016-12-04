package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Idioma;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class IdiomaDao extends AbstractDao<Idioma, Long> {

    final EntityManager entityManager;

    public IdiomaDao(EntityManager entityManager) {
        super(Idioma.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
