/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer;

import br.com.cwi.crescer.business.Executor;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MeuWriterUtils {

    public void WriterUtils(Scanner input) {
        String entrada;
        List<String> listParaAppend = new ArrayList<>();
        System.out.println("Digite 'sair' para fechar o programa!");
        while(true){
            entrada = input.nextLine();
            
            if(entrada.equals("sair")) break;
            
            File file = new File(entrada);
            
            if(!file.exists()){
                System.out.println("Arquivo não encontrado!");
                continue;
            }
            
            System.out.println("Digite o que vai ser colocado no arquivo!\nPressione enter para quebrar linha!\ndigite !fiminput para terminar!"); 
            while(true){
                 entrada = input.nextLine();
                if(entrada.equals("!fiminput")) break;
                listParaAppend.add(entrada);
            }
            
                new Executor().executarWriter(file, listParaAppend);
            
        }
        return;
    }
    
}
