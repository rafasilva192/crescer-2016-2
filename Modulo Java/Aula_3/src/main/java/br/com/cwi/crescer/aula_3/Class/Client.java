/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula_3.Class;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static org.hibernate.id.SequenceGenerator.SEQUENCE;

/**
 *
 * @author Rafael
 */
@Entity
@Table(name = "CLIENT")
public class Client implements Serializable{
    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name ="SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
    }
