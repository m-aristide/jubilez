/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chants.repositories;

import com.mcorp.jubliez.chants.entities.Chant;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author aristide
 */
@Repository
public interface ChantRepository extends ReactiveCrudRepository<Chant, Long> {

}
