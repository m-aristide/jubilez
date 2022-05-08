/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.entities.sections;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author aristide
 */
public class SectionFactory {

    public static List<Section> build(String contenu) {

        List<Section> sections = new ArrayList<>();

        if (contenu == null) {
            return sections;
        }

        Gson gson = new Gson();
        try {
            ((List<LinkedTreeMap>) gson.fromJson(contenu, new TypeToken<List<LinkedTreeMap>>() {
            }.getType()))
                    .forEach((LinkedTreeMap item) -> {
                        sections.add((item.get("type").equals("refrain") ? new Refrain(item) : item.get("type").equals("couplet") ? new Couplet(item) : new Coda(item)));
                    });
            Collections.sort(sections);
        } catch (JsonSyntaxException ex) {
        }

        return sections;
    }
}
