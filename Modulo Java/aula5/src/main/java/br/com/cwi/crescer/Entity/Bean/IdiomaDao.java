/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Entity.Bean;

import br.com.cwi.crescer.Dao.AbstractDao;
import br.com.cwi.crescer.Entity.Idioma;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rafael.silva
 */
@Stateless
public class IdiomaDao extends AbstractDao<Idioma, Long> {

    @PersistenceContext(unitName = "cinema")
    private EntityManager entityManager;

    public IdiomaDao() {
        super(Idioma.class);
    }

    public IdiomaDao(EntityManager entityManager) {
        super(Idioma.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Idioma> findAll() {
        return this.getEntityManager().createQuery("select p from Idioma p").getResultList();
    }

}
