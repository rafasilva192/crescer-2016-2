/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.cwi.crescer.aula_1;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author Rafael
 */
public class MeuCalendarioUtil {
    
    public static void main(String[] args){
        System.out.println("Bem vindo ao Aplicativo MeuCalendarioUtil");
        System.out.println("Digite o numero do método para utilizar ele");
        System.out.println("1 - Dia da semana de uma data");
        System.out.println("2 - Informar tempo decorrido de uma data até hoje");
        System.out.println("3 - Calcular parcelas");
        Scanner input = new Scanner(System.in);
        switch(input.nextLine()){
            case "1":
                System.out.println("Digite a data");
                Date data = new Date(input.nextLine());
                DiaSemana(data);
                break;
            case "2":
                System.out.println("Digite a data");
                Date dataInformada = new Date(input.nextLine());
                ContarTempo(dataInformada);
                break;
            case "3":
                Parcelator();
                break; 
            default:
                break;
        }
    }
    private static void DiaSemana(Date data) {
    SimpleDateFormat format = new SimpleDateFormat("EEEE");
    System.out.println(format.format(data));
    }

    private static void ContarTempo(Date dataInformada) {
        Date date = new Date();
        StringBuilder difference = getDateDiff(dataInformada, date);
        System.out.println(difference);
    }
    
    private static StringBuilder getDateDiff(Date date1, Date date2) {
    long diffInMillies = date2.getTime() - date1.getTime();
    long Dias = TimeUnit.DAYS.convert(diffInMillies,TimeUnit.MILLISECONDS);
    long Meses = Dias / 30;
    long Anos = Meses / 12;
    String AnoString = Objects.toString(Anos, null);
    String MesString = Objects.toString(Meses%12, null);
    String DiaString = Objects.toString(Dias%30, null);
    return new StringBuilder(AnoString).append(" anos, ").append(MesString).append(" meses e ").append(DiaString).append(" dias.");
}

    private static void Parcelator() {
        Scanner input = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();
        System.out.println("Digite o valor");
        int valorParcela = Integer.parseInt(input.nextLine());
        System.out.println("Digite os juros de parcela");
        int jurosParcela = Integer.parseInt(input.nextLine());
        System.out.println("Digite a quantidade de parcelas");
        int quantidadeParcela = Integer.parseInt(input.nextLine());
        System.out.println("Digite a data do 1° vencimento");
        Date dataInformada = new Date(input.nextLine());
        DecimalFormat df = new DecimalFormat("#.00");
        int valorFinal = valorParcela + (valorParcela*(jurosParcela/100));
        calendar.setTime(dataInformada);
        SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
        
        for(int i = 0; i < quantidadeParcela; i++){
            
            String formatted = format1.format(calendar.getTime());
            System.out.println(new StringBuilder(formatted).append(" - R$ ").append(df.format(valorFinal)));
            calendar.add(Calendar.MONTH, 1);
        }
    }
}
