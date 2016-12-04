package br.com.cwi.crescer.aula5.bean;

import br.com.cwi.crescer.aula5.dao.AbstractDao;
import br.com.cwi.crescer.aula5.interfaces.ICrud;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Carlos H. Nonnemacher
 * @param <T>
 * @param <ID>
 * @param <DAO>
 */
public abstract class AbstractBean<T, ID, DAO extends AbstractDao<T, ID>> implements ICrud<T, ID> {

    @PersistenceContext(unitName = "crescer")
    private EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }

    public abstract DAO getDao();

    @Override
    public void insert(T t) {
        this.getDao().insert(t);
    }

    @Override
    public void delete(T t) {
      this.getDao().delete(t);
    }

    @Override
    public List<T> findAll() {
        return this.getDao().findAll();
    }

    @Override
    public T find(ID id) {
        return this.getDao().find(id);
    }
    
}
