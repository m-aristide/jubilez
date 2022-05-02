/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chants.controlers;

import com.mcorp.jubliez.chants.entities.Chant;
import com.mcorp.jubliez.chants.repositories.ChantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author aristide
 */
@RestController
@RequestMapping(path="/chants", produces="application/json")
@CrossOrigin(origins="*")
public class ChantControler {

    private final ChantRepository chantRepository;
    
    @Autowired
    public ChantControler(ChantRepository chantRepository) {
        this.chantRepository = chantRepository;
    }
    
    
    @GetMapping("/{id}")
    public Mono<Chant> chant(@PathVariable("id") Long id) {
        
        return chantRepository.findById(id);
    }
}
