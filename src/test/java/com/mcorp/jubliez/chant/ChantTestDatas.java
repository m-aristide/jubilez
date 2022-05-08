/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant;

import com.mcorp.jubliez.chant.entities.Chant;
import com.mcorp.jubliez.chant.entities.sections.Coda;
import com.mcorp.jubliez.chant.entities.sections.Couplet;
import com.mcorp.jubliez.chant.entities.sections.Refrain;
import com.mcorp.jubliez.chant.entities.sections.Section;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author aristide
 */
public class ChantTestDatas {
    
    public static Chant getChant() {
        return Chant.builder()
                .id(1L)
                .categorie("Chants d’entrée")
                .titre("Avec toi nous irons au désert")
                .temps("Carême")
                .langue("Français")
                .sections(getSections())
                .build();
    }
    
    public static List<Section> getSections() {
        return Arrays.asList(
                new Refrain(1, "Avec toi"),
                new Couplet(2, "Seigneur"),
                new Coda(3, "Poussés")
        );
    }
    
    public static String getContenu() {
        return "[{\"type\":\"refrain\",\"numero\":1,\"contenu\":\"Avec toi\"},{\"type\":\"couplet\",\"numero\":2,\"contenu\":\"Seigneur\"},{\"type\":\"coda\",\"numero\":3,\"contenu\":\"Poussés\"}]";
    }
    
    public static String export() {
        return "{\"id\":1,\"titre\":\"Avec toi nous irons au désert\",\"sections\":"+getContenu()+"}";
    }
    
}
