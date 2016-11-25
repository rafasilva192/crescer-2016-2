/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula_1;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author rafael.silva
 */
public class StringRun {
    public static void main(String[] args) {
        LerEstados();
        DataSistema();
        Scanner input = new Scanner(System.in);
        int numeroVogal = VogalReader(input.nextLine());
        System.out.println(numeroVogal);
        Reverse(input.nextLine());
    }
    public static int VogalReader(String frase){
        int numeroVogal = 0;
        String[] fraseNova = frase.toLowerCase().split("");
        for(int i = 0; i < frase.length(); i++){
            if(fraseNova[i].contains("a") || fraseNova[i].contains("o") || fraseNova[i].contains("e") || fraseNova[i].contains("i") || fraseNova[i].contains("u"))
            {
              numeroVogal++;  
            }
        }
        return numeroVogal;
    }
    
    public static void Reverse(String frase){
    System.out.println(new StringBuilder(frase).reverse().toString());
    }

    private static void LerEstados() {
        Estados[] estados = Estados.values();
        Arrays.sort(estados);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < estados.length; i++){
            if(i == estados.length -1){
               sb.append(estados[i].getNome()).append("."); 
            }
            else sb.append(estados[i].getNome()).append(", "); 
        }
        System.out.println(sb);
    }

    private static void DataSistema() {
    Calendar calendar = Calendar.getInstance();
    System.out.println(calendar.toInstant());
    Scanner input = new Scanner(System.in);
    SimpleDateFormat format = new SimpleDateFormat("EEEE");
    Date data = new Date(input.nextLine());
    System.out.println(format.format(data));
    }
}


    
 
    
    



