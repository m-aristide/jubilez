/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.controlers;

import com.mcorp.jubliez.chant.ChantTestDatas;
import com.mcorp.jubliez.chant.controlers.ChantControler;
import com.mcorp.jubliez.chant.dtos.ChantDTO;
import com.mcorp.jubliez.chant.entities.Chant;
import com.mcorp.jubliez.chant.metier.ChantMetier;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestMethodOrder;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;

/**
 *
 * @author aristide
 */
//@WebMvcTest(ChantControler.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
//@Transactional
public class ChantControlerCompTest {

    private final ChantMetier metier;

    public ChantControlerCompTest() {
        this.metier = Mockito.mock(ChantMetier.class);
    }

    @Test
    public void test_chant_create_chant_badrequest() {
        when(metier.enregistrer(any())).thenAnswer(ans -> ans.getArgument(0));
        
        WebTestClient testClient = WebTestClient.bindToController(new ChantControler(this.metier)).build();

        testClient.post().uri("/chants")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(Chant.builder().titre("Pater noster").build()), Chant.class)
                .exchange()
                .expectStatus().isBadRequest();
    }

    @Test
    public void test_chant_create_chant() {
        when(metier.enregistrer(any())).thenAnswer(ans -> ans.getArgument(0));
        
        WebTestClient testClient = WebTestClient.bindToController(new ChantControler(this.metier)).build();

        ChantDTO dto = new ChantDTO(ChantTestDatas.getChant().toBuilder().id(null).build());
        
        testClient.post().uri("/chants")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(dto), ChantDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Chant.class)
                .isEqualTo(dto.toModel());
    }
}
