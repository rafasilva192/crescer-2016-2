/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer;

import br.com.cwi.crescer.aula_1.MeuStringUtil;
import br.com.cwi.crescer.business.Executor;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MeuReaderUtils {

    public void ReaderUtils(Scanner input) {
        String entrada;
        System.out.println("Digite 'sair' para fechar o programa!");
        while(true){
            entrada = input.nextLine();
            if(entrada.equals("sair")) break;
            if(!entrada.trim().isEmpty()){
                new Executor().executarReader(entrada);
            }
        }
        return;
    }
}
