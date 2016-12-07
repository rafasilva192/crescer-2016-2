package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Carlos H. Nonnemacher
 */
@RestController
@RequestMapping("/rest/pessoa")
public class PessoaRest {

    @Autowired
    PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Pessoa> list(Pageable pgbl) {
        return service.findAll(pgbl);
    }

    @RequestMapping(method = RequestMethod.POST)
    public Pessoa save(@RequestBody Pessoa p) {
        return service.save(p);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public void delete(@RequestBody Pessoa p) {
        service.delete(p.getId());
    }
}
