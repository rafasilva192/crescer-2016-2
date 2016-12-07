/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Elenco;
import br.com.cwi.crescer.aula8.entity.Filme;
import br.com.cwi.crescer.aula8.service.ClassificacaoService;
import br.com.cwi.crescer.aula8.service.ElencoService;
import br.com.cwi.crescer.aula8.service.FilmeService;
import br.com.cwi.crescer.aula8.service.GeneroService;
import br.com.cwi.crescer.aula8.service.IdiomaService;
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
 *
 * @author Rafael
 */
@Controller
@RequestMapping("/filme")
public class FilmeController {
    
    @Autowired
    FilmeService service;
    
    @Autowired
    GeneroService genservice;
    
    @Autowired
    ElencoService elencoservice;
    
    @Autowired
    ClassificacaoService classservice;
    
    @Autowired
    IdiomaService idiomaservice;
    
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());
        
        Filme filme = new Filme();
        
        if(id != null){
            filme = service.findOne(id);
            pageable = null;
        }
        if(pageable == null){
            pageable = new PageRequest(0, 10);
        }
        
        model.addAttribute("filme", filme);
        model.addAttribute("filmes", service.findAll(pageable));
        model.addAttribute("generos", genservice.findAll());
        model.addAttribute("elencos", elencoservice.findAll());
        model.addAttribute("classificacoes", classservice.findAll());
        model.addAttribute("idiomas", idiomaservice.findAll());
        
        return "filme";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Filme filme, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            service.save(filme);
            return "redirect:filme";
        }
        return "filme";
    }
    
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Filme> filmes = service.findAll(pageable);
        model.addAttribute("filmes", filmes);
        return "filme";
    }
}


