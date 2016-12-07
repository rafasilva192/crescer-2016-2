package br.com.cwi.crescer.aula8.service;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.repository.PessoaRepository;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * @author Carlos H. Nonnemacher
 */
@Service
public class PessoaService {

    @Autowired
    PessoaRepository repository;

    public List<Pessoa> list() {
        Pessoa p = new Pessoa();
        p.setNome("Carlos H. Nonnemacher");
        p.setNascimento(new Date());
        return Stream.of(p).collect(Collectors.toList());
    }

    public Page<Pessoa> findAll(Pageable pgbl) {
        return repository.findAll(pgbl);
    }

    public Iterable<Pessoa> findAll() {
        return repository.findAll();
    }

    public Pessoa save(Pessoa p) {
        return repository.save(p);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Pessoa findOne(Long id) {
        return repository.findOne(id);
    }

}
