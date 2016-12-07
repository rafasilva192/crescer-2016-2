package br.com.cwi.crescer.aula8.dto;

import java.util.Date;

/**
 * @author Carlos H. Nonnemacher
 */
public class PessoaDto {

    String nome;
    Date nascimento;

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

}
