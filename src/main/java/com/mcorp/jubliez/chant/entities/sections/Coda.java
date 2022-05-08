/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chant.entities.sections;

import com.google.gson.internal.LinkedTreeMap;

/**
 *
 * @author aristide
 */
public class Coda extends Section {

    public Coda() {
        super("coda");
    }

    public Coda(LinkedTreeMap item) {
        super(item);
    }

    public Coda(Integer numero, String contenu) {
        super("coda", numero, contenu);
    }
    
}
