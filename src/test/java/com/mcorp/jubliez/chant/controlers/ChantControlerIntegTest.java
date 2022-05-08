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
import com.mcorp.jubliez.chant.repositories.ChantRepository;
import java.util.Arrays;
import static org.hamcrest.Matchers.equalTo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.TestMethodOrder;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;
import static org.mockito.Mockito.when;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 *
 * @author aristide
 */
@SpringBootTest
@AutoConfigureWebTestClient
//@Transactional
public class ChantControlerIntegTest {

    @Autowired
    WebTestClient webTestClient;

    /*@Test
    @Order(1)
    public void test_chant() {
        ChantDTO dto = new ChantDTO(ChantTestDatas.getChant().toBuilder().id(null).build());

        webTestClient.post().uri("/chants")
                .accept(MediaType.APPLICATION_JSON)
                .body(Mono.just(dto), ChantDTO.class)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Chant.class)
                .isEqualTo(dto.toModel().toBuilder().id(1L).build());
    }

    
    */
    @Test
    @Order(2)
    public void test_chants() {
        webTestClient.get().uri("/chants/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Chant.class)
                .value(val -> val.getId(), equalTo(1L))
                .value(val -> val.getTitre(), equalTo("Approchons-nous de la table"));
    }

    /*@Test
    @Order(3)
    public void test_chant_delete_id2() {
        WebTestClient testClient = WebTestClient.bindToController(new ChantControler(this.chantRepository)).build();

        testClient.delete().uri("/chants/2")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .isEmpty();

        testClient.get().uri("/chants")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(Chant.class)
                .hasSize(1)
                .isEqualTo(Arrays.asList(Chant.builder().id(1l).titre("Avé Marie").build()));
    }

     */
}
