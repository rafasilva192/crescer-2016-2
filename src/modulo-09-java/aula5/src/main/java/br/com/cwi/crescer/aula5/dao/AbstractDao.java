package br.com.cwi.crescer.aula5.dao;

import br.com.cwi.crescer.aula5.interfaces.ICrud;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaQuery;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 * @param <ID>
 *
 */
public abstract class AbstractDao<T, ID> implements ICrud<T, ID> {

    public abstract EntityManager getEntityManager();

    private final Class<T> clazz;

    public AbstractDao(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public void insert(T t) {
        this.getEntityManager().merge(t);
    }

    @Override
    public void delete(T t) {
        this.getEntityManager().remove(t);
    }

    @Override
    public T find(ID id) {
        return this.getEntityManager().find(clazz, id);
    }

    @Override
    public List<T> findAll() {
        final CriteriaQuery<T> createQuery = this.getEntityManager().getCriteriaBuilder().createQuery(clazz);
        return this.getEntityManager().createQuery(createQuery).getResultList();
    }

}
