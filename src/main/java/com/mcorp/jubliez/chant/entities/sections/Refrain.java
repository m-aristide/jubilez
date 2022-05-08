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
public class Refrain extends Section {

    public Refrain() {
        super("refrain");
    }

    public Refrain(LinkedTreeMap item) {
        super(item);
    }
    
    public Refrain(Integer numero, String contenu) {
        super("refrain", numero, contenu);
    }
}
