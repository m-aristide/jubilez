/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.controlers;

import com.mcorp.jubliez.chant.dtos.ChantDTO;
import com.mcorp.jubliez.chant.entities.Chant;
import com.mcorp.jubliez.chant.metier.ChantMetier;
import com.mcorp.jubliez.chant.repositories.ChantRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

/**
 *
 * @author aristide
 */
@RestController
@RequestMapping(path = "/chants", produces = "application/json")
@CrossOrigin(origins = "*")
public class ChantControler {

    private final ChantMetier metier;

    @Autowired
    public ChantControler(ChantRepository chantRepository) {
        this.metier = new ChantMetier(chantRepository);
    }

    public ChantControler(ChantMetier metier) {
        this.metier = metier;
    }

    @PostMapping()
    public Mono<Chant> create(@Valid @RequestBody Mono<ChantDTO> chant) {
        return metier.enregistrer(chant.map(data -> data.toModel()));
    }

    @GetMapping("/{id}")
    public Mono<Chant> chant(@PathVariable("id") Long id) {
        return metier.chant(id);
    }
    
    /*
    @GetMapping()
    public Flux<Chant> chants() {
        return chantRepository.findAll();
    }
    
    @DeleteMapping("/{id}")
    public Mono<Void> delete(@PathVariable("id") Long id) {
        return chantRepository.deleteById(id);
    }*/
    
}
