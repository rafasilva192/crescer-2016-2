/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.Entity;

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
@Table(name = "IDIOMA")
public class Idioma implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_IDIOMA")
    @SequenceGenerator(name = "SEQ_IDIOMA", sequenceName = "SEQ_IDIOMA", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_IDIOMA")
    private Long idIdioma;

    @Basic(optional = false)
    @Column(name = "NM_IDIOMA")
    private String nmIdioma;   

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long idIdioma) {
        this.idIdioma = idIdioma;
    }

    public String getNmIdioma() {
        return nmIdioma;
    }

    public void setNmIdioma(String nmIdioma) {
        this.nmIdioma = nmIdioma;
    }
    
}
