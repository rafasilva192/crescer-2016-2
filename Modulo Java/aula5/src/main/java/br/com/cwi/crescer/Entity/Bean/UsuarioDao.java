/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Entity.Bean;

import br.com.cwi.crescer.Dao.AbstractDao;
import br.com.cwi.crescer.Entity.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rafael.silva
 */
@Stateless
public class UsuarioDao extends AbstractDao<Usuario, Long> {

    @PersistenceContext(unitName = "cinema")
    private EntityManager entityManager;

    public UsuarioDao() {
        super(Usuario.class);
    }

    public UsuarioDao(EntityManager entityManager) {
        super(Usuario.class);
        this.entityManager = entityManager;
    }

    @Override
    public EntityManager getEntityManager() {
        return entityManager;
    }

    @Override
    public List<Usuario> findAll() {
        return this.getEntityManager().createQuery("select p from Usuario p").getResultList();
    }

}
