/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula_2;

import br.com.cwi.crescer.aula_1.MeuStringUtil;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class MeuFileUtils {

    static boolean comandoCompleto;
    static String entrada;
    static File file;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        do {
            entrada = input.nextLine();
            if (MeuStringUtil.ValidarString(entrada)) {
                String[] entradaSplit = entrada.split(" ");
                comandoCompleto = entradaSplit[0].length() > 1;
                if (entradaSplit[0].equals("mk") && comandoCompleto) {
                    CriarArquivo(entradaSplit[1]);
                } else if (entradaSplit[0].equals("rm") && comandoCompleto) {
                    RemoverArquivo(entradaSplit[1]);
                } else if (entradaSplit[0].equals("ls")) {
                    if (comandoCompleto) {
                        System.out.println(CaminhoArquivo(entradaSplit[1]));
                    } else {
                        CaminhoArquivo(null);
                    }
                }
            }
        } while (true);
    }

    public static String CaminhoArquivo(String arquivo) {
        
        if(arquivo != null){
            file = new File(arquivo);
            if(file.exists()) return file.getAbsolutePath();
        }
        return "NADA";
    }

    public static boolean RemoverArquivo(String arquivo) {
        file = new File(arquivo);
        try {
            if (file.exists() && arquivo.contains(".")) {
                return Files.deleteIfExists(file.toPath());
            }
        } catch (Exception se) {
        }

        return false;
    }

    public static boolean CriarArquivo(String arquivo) {
        try {
            file = new File(arquivo);
            if (!file.exists() && !arquivo.contains(".")) {
                return new File(arquivo).mkdir();
            } else if (!file.exists()) {
                return new File(arquivo).createNewFile();
            }

        } catch (Exception se) {
        }
        return false;
    }
}
