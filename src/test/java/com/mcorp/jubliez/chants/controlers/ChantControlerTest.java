/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chants.controlers;

import com.mcorp.jubliez.chants.entities.Chant;
import com.mcorp.jubliez.chants.repositories.ChantRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 *
 * @author aristide
 */
@SpringBootTest
public class ChantControlerTest {

    @Autowired
    private ChantRepository chantRepository;

    @Test
    public void context() {
        assertNotNull(chantRepository);
    }

    /**
     * Test of chant method, of class ChantControler.
     */
    @Test
    public void testChant() {
        WebTestClient testClient = WebTestClient.bindToController(new ChantControler(this.chantRepository)).build();

        testClient.get().uri("/chants/1")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(Chant.class)
                .isEqualTo(Chant.builder().id(1l).build());
    }

}
