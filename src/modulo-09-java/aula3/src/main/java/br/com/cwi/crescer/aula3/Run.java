package br.com.cwi.crescer.aula3;

import br.com.cwi.crescer.aula3.dao.PessoaDao;
import br.com.cwi.crescer.aula3.entity.Filho;
import br.com.cwi.crescer.aula3.entity.Pessoa;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author Carlos H. Nonnemacher
 */
public class Run {

    public static void main(String[] args) {

        final EntityManagerFactory emf = Persistence.createEntityManagerFactory("CRESCER");
        final EntityManager em = emf.createEntityManager();

        final PessoaDao pessoaDao = new PessoaDao(em);

        final Pessoa pessoa = new Pessoa();
//        pessoa.setNmPessoa("Carlos");

        final ArrayList<Filho> filhos = new ArrayList<>();
        pessoa.setFilhos(filhos);
        final Filho filho = new Filho();
        filho.setNmPessoa("teste 1");
        filhos.add(filho);
        
//        for (int i = 0; i < 10; i++) {
//            filhos.add(filho);
//        }
        pessoaDao.insert(pessoa);

        pessoaDao.findByPessoa(pessoa).forEach(p -> System.out.println(p.getNmPessoa()));
        em.close();
        emf.close();

    }

}
