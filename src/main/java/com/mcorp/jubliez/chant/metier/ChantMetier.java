/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.metier;

import com.mcorp.jubliez.chant.entities.Chant;
import com.mcorp.jubliez.chant.repositories.ChantRepository;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 *
 * @author aristide
 */
@Slf4j
public class ChantMetier {

    private final ChantRepository repository;

    public ChantMetier(ChantRepository repository) {
        this.repository = repository;
    }

    /**
     * enregistrer un chant
     *
     * @param data
     * @return
     */
    public Mono<Chant> enregistrer(Mono<Chant> data) {
        return data
                .map(chant -> {
                    chant.buildContenu();
                    return chant;
                })
                .flatMap(it -> this.repository.save(it));
    }

    public Mono<Chant> chant(Long id) {
        return this.repository.findById(id);
    }

}
