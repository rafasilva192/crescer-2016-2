package br.com.cwi.crescer.aula3.dao;

import static org.hibernate.criterion.MatchMode.ANYWHERE;

import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaDao implements IDao<Pessoa, Long> {
    
    final EntityManager entityManager;

    public PessoaDao(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    
    @Override
    public void insert(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            if (pessoa.getIdPessoa() == null) {
                entityManager.persist(pessoa);
            } else {
                entityManager.merge(pessoa);
            }
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public void delete(Pessoa pessoa) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(pessoa);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
        }
    }

    @Override
    public Pessoa find(Long id) {
        return entityManager.find(Pessoa.class, id);
    }

    @Override
    public List<Pessoa> findAll() {
        return entityManager.createQuery("select p from Pessoa p").getResultList();
    }

    public List<Pessoa> findByNome(String nmPessoa) {
        final Session session = entityManager.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Restrictions.like("nmPessoa", nmPessoa, ANYWHERE));
        return criteria.list();
    }

    public List<Pessoa> findByPessoa(Pessoa pessoa) {
        final Session session = entityManager.unwrap(Session.class);
        final Criteria criteria = session.createCriteria(Pessoa.class);
        criteria.add(Example.create(pessoa));
        return criteria.list();
    }
    
    
    
    
}
