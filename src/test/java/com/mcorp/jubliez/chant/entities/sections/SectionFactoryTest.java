/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.entities.sections;

import com.google.gson.JsonSyntaxException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aristide
 */
public class SectionFactoryTest {

    @Test
    public void test_build_contenu_null() {
        String contenu = null;
        List<Section> result = SectionFactory.build(contenu);
        assertTrue(result.isEmpty());
    }

    @Test
    public void test_build_contenu_not_json() {
        String contenu = "simple string not json";
        List<Section> result = SectionFactory.build(contenu);
        assertTrue(result.isEmpty());
    }

    @Test
    public void test_build_contenu_normal_content() {
        String contenu = "[{\"type\": \"refrain\",\"numero\": 1,\"contenu\": \"Avec toi\"},{\"type\": \"couplet\",\"numero\": 2,\"contenu\": \"Seigneur\"},{\"type\": \"coda\",\"numero\": 3,\"contenu\": \"Poussés\"}]";
        List<Section> result = SectionFactory.build(contenu);
        assertEquals(3, result.size());
        
        assertEquals(Refrain.class, result.get(0).getClass());
        assertEquals("refrain", result.get(0).getType());
        assertEquals(1, result.get(0).getNumero());
        assertEquals("Avec toi", result.get(0).getContenu());
        
        assertEquals(Couplet.class, result.get(1).getClass());
        assertEquals("couplet", result.get(1).getType());
        assertEquals(2, result.get(1).getNumero());
        assertEquals("Seigneur", result.get(1).getContenu());
        
        assertEquals(Coda.class, result.get(2).getClass());
        assertEquals("coda", result.get(2).getType());
        assertEquals(3, result.get(2).getNumero());
        assertEquals("Poussés", result.get(2).getContenu());
    }

    @Test
    public void test_build_contenu_normal_content_sort() {
        String contenu = "[{\"type\": \"refrain\",\"numero\": 3,\"contenu\": \"Avec toi nous irons au désert\"},{\"type\": \"couplet\",\"numero\": 2,\"contenu\": \"Seigneur, avec toi nous irons au désert\"},{\"type\": \"coda\",\"numero\": 1,\"contenu\": \"Poussés comme toi par l’Esprit\"}]";
        List<Section> result = SectionFactory.build(contenu);
        assertEquals(3, result.size());
        assertEquals("coda", result.get(0).getType());
        assertEquals("couplet", result.get(1).getType());
        assertEquals("refrain", result.get(2).getType());
    }

}
