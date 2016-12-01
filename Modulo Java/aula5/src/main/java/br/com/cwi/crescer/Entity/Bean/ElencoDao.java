/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Entity.Bean;

import br.com.cwi.crescer.Dao.AbstractDao;
import br.com.cwi.crescer.Entity.Classificacao;
import br.com.cwi.crescer.Entity.Elenco;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rafael.silva
 */
@Stateless
public class ElencoDao extends AbstractDao<Elenco, Long> {

    @PersistenceContext(unitName = "cinema")
    private EntityManager entityManager;

    public ElencoDao() {
        super(Elenco.class);
    }

    public ElencoDao(EntityManager entityManager) {
        super(Elenco.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Elenco> findAll() {
        return this.getEntityManager().createQuery("select p from Elenco p").getResultList();
    }
}
