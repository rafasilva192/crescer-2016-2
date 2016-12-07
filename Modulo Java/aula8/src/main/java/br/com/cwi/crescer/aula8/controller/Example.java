package br.com.cwi.crescer.aula8.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import br.com.cwi.crescer.aula8.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Carlos H. Nonnemacher
 */
@Controller
public class Example {

    @Autowired
    private PessoaService pessoaService;

    @RequestMapping(value = "/", method = GET)
    String toIndex(Model model, @RequestParam(required = false) String name) {
        model.addAttribute("name", name == null ? "Carlos H. Nonnemacher" : name);
        model.addAttribute("pessoas", pessoaService.findAll());
        return "index";
    }
}




