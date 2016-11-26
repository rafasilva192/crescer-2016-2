/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.business;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.event.ListSelectionEvent;

public class Executor {

    private List<String> lista;

    //String acoes possive[]
    public String executarFile(String comando) {
        Executavel executavel = new Executavel(comando);
        Scanner input = new Scanner(System.in);
        boolean retornoAcao;
        String action = executavel.getAction();

        switch (action) {
            case "mk":
                retornoAcao = executavel.CriarArquivo(executavel.getFile());
                if (retornoAcao) {
                    return "Comando executado com sucesso!";
                } else {
                    return "Não foi possível criar um aquivo!";
                }
            case "rm":
                retornoAcao = executavel.RemoverArquivo(executavel.getFile());
                if (retornoAcao) {
                    return "Arquivo removido com sucesso!";
                } else {
                    return "Arquivo inválido!";
                }
            case "ls":
                lista = executavel.CaminhoArquivo(executavel.getFile());
                lista.forEach((arq) -> {
                    System.out.println(arq);
                });
                return "";
            case "mv":
                File diretorio = new File(input.nextLine());
                retornoAcao = executavel.MoverArquivo(executavel.getFile(), diretorio);
                if (retornoAcao) {
                    return "Arquivo movido com sucesso!";
                } else {
                    return "Arquivo inválido!";
                }
            default:
                return "Comando Invalido!";
        }
    }

    public void executarReader(String entrada) {

        lista = new Executavel().LerArquivo(new File(entrada));
        if (lista != null) {
            lista.forEach((arq) -> {
                System.out.println(arq);
            });
        }
    }

    public void executarWriter(File file, List<String> listParaAppend) {
        System.out.println(new Executavel().editarArquivo(file, listParaAppend));
    }
}
