/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Entity.Bean;

import br.com.cwi.crescer.Dao.AbstractDao;
import br.com.cwi.crescer.Entity.Ator;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author rafael.silva
 */
@Stateless
public class AtorDao extends AbstractDao<Ator, Long>{
    @PersistenceContext(unitName = "cinema")
    private EntityManager entityManager;

    public AtorDao() {
        super(Ator.class);
    }
    
    public AtorDao(EntityManager entityManager) {
        super(Ator.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
         return entityManager;
    }

    @Override
    public List<Ator> findAll() {
        return this.getEntityManager().createQuery("select p from Ator p").getResultList();
    }
    
}
