package br.com.cwi.crescer.aula4;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;

/**
 * @author Carlos H. Nonnemacher
 */
@Stateless
public class PessoaBean {

    @PersistenceUnit(name = "CRESCER")
    private EntityManager entityManager;
    
    
    
}
