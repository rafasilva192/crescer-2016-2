package br.com.cwi.crescer.aula8.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Carlos H. Nonnemacher
 */
@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PESSOA")
    @SequenceGenerator(name = "SEQ_PESSOA", sequenceName = "SEQ_PESSOA", allocationSize = 1)
    @Basic(optional = false)
    @Column(name = "ID_PESSOA")
    private Long id;

    @Size(min = 1, max = 255, message = "DEU MERDA NO CAMPO {0}")
    @Basic(optional = false)
    @Column(name = "NM_PESSOA")
    private String nome;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(value = TemporalType.DATE)
    @Basic(optional = false)
    @Column(name = "DT_NASCIMENTO_PESSOA")
    private Date nascimento;

    @NotNull
    @Min(value = 1)
    @Max(value = 200)
    @Column(name = "IDADE_PESSOA")
    private Long idade;

    @NotNull
    @Min(value = 1)
    @Max(value = 200)
    @Column(name = "vl_PESSOA")
    private BigDecimal vlPessoa;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public Long getIdade() {
        return idade;
    }

    public void setIdade(Long idade) {
        this.idade = idade;
    }

    public BigDecimal getVlPessoa() {
        return vlPessoa;
    }

    public void setVlPessoa(BigDecimal vlPessoa) {
        this.vlPessoa = vlPessoa;
    }

    
}
