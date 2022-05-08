/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.entities;

import com.google.gson.Gson;
import com.mcorp.jubliez.chant.entities.sections.Section;
import com.mcorp.jubliez.chant.entities.sections.SectionFactory;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.annotation.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.relational.core.mapping.Table;

/**
 *
 * @author aristide
 */
@Table("chant")
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class Chant implements AbstractChant, Serializable {

    @Id
    private Long id;

    private String titre;

    private String contenu;

    private String categorie;

    private String langue;

    private String temps;

    private List<Section> sections;

    /**
     * ce code permet de construire les sections à partir du contenu
     */
    public void buildSections() {
        this.sections = SectionFactory.build(this.contenu);
    }

    /**
     * ce code transforme la liste des sections en un text stocké en base de
     * données
     */
    public void buildContenu() {
        // to json
        Gson gson = new Gson();
        this.contenu = gson.toJson(sections);
    }

    @Override
    public String export() {
        Gson gson = new Gson();
        return gson.toJson(this.toBuilder().contenu(null).build());
    }

    @Override
    public Long numero() {
        return id;
    }

    @Override
    public String content() {
        return this.contenu;
    }
}
