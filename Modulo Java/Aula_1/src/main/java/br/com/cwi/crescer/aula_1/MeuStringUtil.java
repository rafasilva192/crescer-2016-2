/* Deve possuir um metodo que valide se String é vazia.
 * Deve possuir um metodo que conte o nº de vogais da String (a,e,i,o,u).
 * Deve possuir um metodo que inverta uma String.
 * Deve possuir um metodo que identifique um palíndromo.("ovo", "Ame a ema", "A sogra má e amargosa")
 * Criar um metodo main, que informe os recursos disponíveis ao usuário.
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula_1;

import java.text.Normalizer;
import java.util.Scanner;

/**
 *
 * @author rafael.silva
 */
public class MeuStringUtil {
    
    
    public static void main(String[] args){
        System.out.println("Bem vindo ao Aplicativo MeuStringUtil");
        System.out.println("Digite o numero do método para utilizar ele");
        System.out.println("1 - Validar String vazia");
        System.out.println("2 - Contar vogais duma palavra");
        System.out.println("3 - Reverter palavra");
        System.out.println("4 - Identificar palíndromo");
        Scanner input = new Scanner(System.in);
        switch(input.nextLine()){
            case "1":
                System.out.println("Digite a string para validar");
                ValidarString(input.nextLine());
                
            case "2":
                System.out.println("Digite a palavra para contar as vogais");
                ContarVogais(input.nextLine());  
                
            case "3":
                System.out.println("Digite a palavra para reverter");
                System.out.println(ReverterString(input.nextLine()));
            case "4":
                System.out.println("Digite um palíndromo");
                IdentificarPalindromo(input.nextLine());
            default:
                break;
        }
    }
    
    public static String ReverterString(String palavra){
    return new StringBuilder(palavra).reverse().toString();
    }
    
    public static void ContarVogais(String palavra){
        int numeroVogal = 0;
        String[] palavraArray = palavra.toLowerCase().split("");
        for(int i = 0; i < palavra.length(); i++){
            if(palavraArray[i].contains("a") || palavraArray[i].contains("o") || palavraArray[i].contains("e") || palavraArray[i].contains("i") || palavraArray[i].contains("u"))
            {
              numeroVogal++;  
            }
        }
        System.out.println(numeroVogal);
    }
    
    public static void ValidarString(String validar){
        if(validar.isEmpty()){
            System.out.println("String não é valida pois está vazia");
        }
        else System.out.println("String é valida");
    
}

    private static void IdentificarPalindromo(String frase) {
        String fraseLimpa = frase.toLowerCase().replaceAll("\\s", "");
        fraseLimpa = removerAcentos(fraseLimpa);
        String fraseRevertida = ReverterString(fraseLimpa);
        if(fraseLimpa.equals(fraseRevertida)){
            System.out.println("É um palíndromo");
        }
        else{
            System.out.println("Não é um palíndromo");
        }
    }
    
    private static String removerAcentos(String str) {
    return Normalizer.normalize(str, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
}
}
