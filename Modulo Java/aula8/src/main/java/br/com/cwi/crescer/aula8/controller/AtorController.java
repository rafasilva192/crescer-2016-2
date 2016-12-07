/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.controller;

import br.com.cwi.crescer.aula8.entity.Ator;
import br.com.cwi.crescer.aula8.service.AtorService;
import br.com.cwi.crescer.aula8.service.ElencoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Rafael
 */
@Controller
@RequestMapping("/ator")
public class AtorController {
    
    @Autowired
    AtorService service;
    @Autowired
    ElencoService elencoservice;
    
    private long idElenco;
    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model, @RequestParam(required = false) Long id, Pageable p){
        Pageable pageable = new PageRequest(p.getPageNumber(), 5, p.getSort());
        
        Ator ator = new Ator();
        
        if(id != null){
            ator = service.findOne(id);
            pageable = null;
        }
        if(pageable == null){
            pageable = new PageRequest(0, 10);
        }
        
        model.addAttribute("ator", ator);
        model.addAttribute("atores", service.findAll(pageable));
        model.addAttribute("elencos", elencoservice.findAll());
        model.addAttribute("idElenco", idElenco);
        return "ator";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public String save(@Valid Ator ator, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            ator.setElenco(elencoservice.findOne(idElenco));
            service.save(ator);
            return "redirect:ator";
        }
        return "redirect:ator";
    }
    
    @RequestMapping(value = "/listAll", method = RequestMethod.GET)
    public String listAll(Model model, Pageable pageable) {
        Page<Ator> atores = service.findAll(pageable);
        model.addAttribute("atores", atores);
        return "ator";
    }
    
    
}