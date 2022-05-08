/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.entities;

import com.mcorp.jubliez.chant.ChantTestDatas;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aristide
 */
public class ChantTest {
    
    @Test
    public void test_buildSections() {
        Chant chant = new Chant();
        chant.setContenu(ChantTestDatas.getContenu());
        chant.buildSections();
        assertEquals(ChantTestDatas.getSections().size(), chant.getSections().size());
    }
    
    @Test
    public void test_buildContenu() {
        Chant chant = new Chant();
        chant.setSections(ChantTestDatas.getSections());
        chant.buildContenu();
        assertEquals(ChantTestDatas.getContenu(), chant.getContenu());
    }
    
    @Test
    public void test_export() {
        Chant chant = Chant.builder().id(1L).titre("Avec toi nous irons au désert").build();
        chant.setSections(ChantTestDatas.getSections());
        chant.buildContenu();
        String export = chant.export();
        assertEquals(export, ChantTestDatas.export());
    }
    
    
}
