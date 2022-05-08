/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.entities.sections;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.mcorp.jubliez.chant.entities.AbstractChant;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

/**
 *
 * @author aristide
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
    @Type(value = Couplet.class, name = "couplet"),
    @Type(value = Refrain.class, name = "refrain"),
    @Type(value = Coda.class, name = "coda")
})
public abstract class Section implements AbstractChant, Comparable<Section> {

    @NotNull
    private String type;

    @NotNull
    private Integer numero;

    @NotNull
    private String contenu;

    public Section(String type) {
        this.type = type;
    }

    public Section(LinkedTreeMap data) {
        this.type = (String) data.get("type");
        this.numero = ((Double) data.get("numero")).intValue();
        this.contenu = (String) data.get("contenu");
    }

    @Override
    public String content() {
        return this.contenu;
    }

    @Override
    public int compareTo(Section o) {
        return this.numero.compareTo(o.numero);
    }

    @Override
    public String export() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    @Override
    public Long numero() {
        return Long.valueOf(numero);
    }

}
