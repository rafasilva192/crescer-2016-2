/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer;

import java.util.Scanner;

/**
 *
 * @author Rafael
 */
public class Run {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String entrada;
        boolean sair = false;
        while (true) {
            System.out.println("1 - MeuFileUtils\n2 - MeuReaderUtils\n3 - MeuWriterUtils\n4 - Sair");
            entrada = input.nextLine();
            switch (entrada) {
                case "1":
                    new MeuFileUtils().FileUtils(input);
                    break;
                case "2":
                    new MeuReaderUtils().ReaderUtils(input);
                    break;
                case "3":
                    new MeuWriterUtils().WriterUtils(input);
                    break;
                case "4":
                    sair = true;
                    break;
                default:
                    break;
            }
            if (sair) {
                break;
            }
        }
    }
}
