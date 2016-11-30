package br.com.cwi.crescer.aula4;

import static javax.persistence.GenerationType.SEQUENCE;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "FILHO")
public class Filho implements Serializable {

    @Id
    @GeneratedValue(strategy = SEQUENCE, generator = "SEQ_FILHO")
    @SequenceGenerator(name = "SEQ_FILHO", sequenceName = "SEQ_FILHO", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_FILHO")
    private Long idPessoa;

    @Basic(optional = false)
    @Column(name = "NM_FILHO")
    private String nmPessoa;

    @ManyToOne
    private Pessoa pessoa;

    public Long getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(Long idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNmPessoa() {
        return nmPessoa;
    }

    public void setNmPessoa(String nmPessoa) {
        this.nmPessoa = nmPessoa;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }

}
