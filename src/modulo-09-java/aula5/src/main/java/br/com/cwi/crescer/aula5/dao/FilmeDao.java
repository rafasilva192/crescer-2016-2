package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Filme;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class FilmeDao extends AbstractDao<Filme, Long> {

    final EntityManager entityManager;

    public FilmeDao(EntityManager entityManager) {
        super(Filme.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
