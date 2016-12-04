package br.com.cwi.crescer.aula4;


import java.util.List;
import javax.persistence.EntityManager;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaDao extends AbstractDao<Pessoa, Long> {

    final EntityManager entityManager;

    public PessoaDao(EntityManager entityManager) {
        super(Pessoa.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Pessoa> findAll() {
        return this.getEntityManager().createQuery("select p from Pessoa p").getResultList();
    }
    
    
}
 