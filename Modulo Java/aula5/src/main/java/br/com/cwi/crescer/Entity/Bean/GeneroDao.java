/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Entity.Bean;

import br.com.cwi.crescer.Dao.AbstractDao;
import br.com.cwi.crescer.Entity.Filme;
import br.com.cwi.crescer.Entity.Genero;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rafael.silva
 */
@Stateless
public class GeneroDao extends AbstractDao<Genero, Long> {

    @PersistenceContext(unitName = "cinema")
    private EntityManager entityManager;

    public GeneroDao() {
        super(Genero.class);
    }

    public GeneroDao(EntityManager entityManager) {
        super(Genero.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Genero> findAll() {
        return this.getEntityManager().createQuery("select p from Genero p").getResultList();
    }

}
