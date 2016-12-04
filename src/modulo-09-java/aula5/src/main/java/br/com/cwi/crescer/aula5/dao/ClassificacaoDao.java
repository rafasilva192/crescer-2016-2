package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.entity.Classificacao;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class ClassificacaoDao extends AbstractDao<Classificacao, Long>{

    final EntityManager entityManager;

    public ClassificacaoDao(EntityManager entityManager) {
        super(Classificacao.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }
    
}
