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
public class Couplet extends Section {

    public Couplet() {
        super("couplet");
    }

    public Couplet(LinkedTreeMap item) {
        super(item);
    }
    
    public Couplet(Integer numero, String contenu) {
        super("couplet", numero, contenu);
    }

}
