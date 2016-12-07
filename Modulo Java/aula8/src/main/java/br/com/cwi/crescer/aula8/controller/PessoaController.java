package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Pessoa;
import br.com.cwi.crescer.aula8.service.PessoaService;
import java.util.Date;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaService service;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p) {
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());

        Pessoa pessoa = new Pessoa();
        if (id != null) {
            pessoa = service.findOne(id);
            pageable = null;
        }
        if (pageable == null) {
            pageable = new PageRequest(0, 10);
        }
        model.addAttribute("pessoa", pessoa);
        model.addAttribute("pessoas", service.findAll(pageable));
        return "pessoa";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Pessoa pessoa, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            if (pessoa.getNascimento() == null) {
                pessoa.setNascimento(new Date());
            }
            service.save(pessoa);
            return "redirect:pessoa";
        }
        return "pessoa";
    }

    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Pessoa> pessoas = service.findAll(pageable);
        model.addAttribute("pessoas", pessoas);
        return "pessoa";
    }

}
