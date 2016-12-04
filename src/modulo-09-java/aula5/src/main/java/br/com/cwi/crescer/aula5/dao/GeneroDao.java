package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Genero;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class GeneroDao extends AbstractDao<Genero, Long> {

    final EntityManager entityManager;

    public GeneroDao(EntityManager entityManager) {
        super(Genero.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
