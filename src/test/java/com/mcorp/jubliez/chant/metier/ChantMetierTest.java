/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.metier;

import com.mcorp.jubliez.chant.ChantTestDatas;
import com.mcorp.jubliez.chant.entities.Chant;
import com.mcorp.jubliez.chant.exceptions.NoSectionException;
import com.mcorp.jubliez.chant.repositories.ChantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import reactor.core.publisher.Mono;

/**
 *
 * @author aristide
 */
public class ChantMetierTest {
    
    private final ChantRepository repository;
    
    public ChantMetierTest() {
        this.repository = Mockito.mock(ChantRepository.class);
    }
    
    @Test
    public void test_enregistrer() {
        when(repository.save(any())).thenAnswer(ans -> {
            Chant chant = (Chant) ans.getArgument(0);
            chant.setId(1L);
            return Mono.just(chant);
        });
        Chant expResult = ChantTestDatas.getChant();
        expResult.buildContenu();
        
        ChantMetier metier = new ChantMetier(repository);
        Mono<Chant> data = Mono.just(ChantTestDatas.getChant().toBuilder().id(null).build());
        Chant result = metier.enregistrer(data).block();
        result.buildContenu();
        
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getContenu(), result.getContenu());
        assertEquals(expResult.getCategorie(), result.getCategorie());
        assertEquals(expResult.getLangue(), result.getLangue());
        assertEquals(expResult.getTemps(), result.getTemps());
        assertEquals(expResult.getTitre(), result.getTitre());
    }
    
}
