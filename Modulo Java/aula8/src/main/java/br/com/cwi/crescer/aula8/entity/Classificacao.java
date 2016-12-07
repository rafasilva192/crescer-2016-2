/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula8.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.SEQUENCE;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author rafael.silva
 */
@Entity
@Table(name = "CLASSIFICACAO")
public class Classificacao implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_CLASS")
    @SequenceGenerator(name = "SEQ_CLASS", sequenceName = "SEQ_CLASS", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_CLASS")
    private Long idClass;

    @Basic(optional = false)
    @Column(name = "DS_CLASS")
    private String dsClass;
    
    @Basic(optional = false)
    @Column(name = "DS_IDADE")
    private int dsIdade;

    public Long getIdClass() {
        return idClass;
    }

    public void setIdClass(Long idClass) {
        this.idClass = idClass;
    }

    public String getDsClass() {
        return dsClass;
    }

    public void setDsClass(String dsClass) {
        this.dsClass = dsClass;
    }

    public int getDsIdade() {
        return dsIdade;
    }

    public void setDsIdade(int dsIdade) {
        this.dsIdade = dsIdade;
    }
    
}