/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.dtos;

import com.mcorp.jubliez.chant.entities.Chant;
import com.mcorp.jubliez.chant.entities.sections.Section;
import java.io.Serializable;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author aristide
 */
@Data
@NoArgsConstructor
public class ChantDTO implements Serializable {

    private Long id;

    @NotBlank(message = "Titre obligatoire")
    private String titre;

    private String contenu;

    private List<Section> sections;

    @NotNull(message = "Catégorie obligatoire")
    private String categorie;

    @NotNull(message = "langue obligatoire")
    private String langue;

    private String temps;

    public ChantDTO(Chant chant) {
        this.id = chant.getId();
        this.titre = chant.getTitre();
        this.contenu = chant.getContenu();
        this.sections = chant.getSections();
        this.categorie = chant.getCategorie();
        this.langue = chant.getLangue();
        this.temps = chant.getTemps();
    }

    public Chant toModel() {
        return Chant.builder()
                .id(id)
                .categorie(categorie)
                .titre(titre)
                .contenu(contenu)
                .temps(temps)
                .langue(langue)
                .sections(sections)
                .build();
    }

}
