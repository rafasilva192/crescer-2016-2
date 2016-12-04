package br.com.cwi.crescer.aula4;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * @author carloshenrique
 */
public class PessoaDaoTest extends AbstractDaoTest {

	private PessoaDao pessoaDao;

	@Before
	public void setBefore() {
		this.pessoaDao = new PessoaDao(this.getEntityManager());
		final Pessoa pessoa = new Pessoa();
		pessoa.setNmPessoa(Pessoa.class.getName());
		this.pessoaDao.insert(pessoa);
	}

	/**
	 * Test of findAll method, of class PessoaDao.
	 */
	@Test
	public void testFindAll() {
		assertTrue(this.pessoaDao.findAll().stream().anyMatch(pessoa -> pessoa.getNmPessoa().equals(Pessoa.class.getName())));
	}

}
