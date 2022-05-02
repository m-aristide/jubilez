/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mcorp.jubliez.chants.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;



/**
 *
 * @author aristide
 */
@Table("chant")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Chant implements Serializable {
    @Id
    private Long id;
}
