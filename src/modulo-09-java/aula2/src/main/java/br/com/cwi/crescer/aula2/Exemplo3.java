package br.com.cwi.crescer.aula2;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author Carlos H. Nonnemacher
 */
public class Exemplo3 {

    public static void main(String[] args) {
        try (
            final Writer writer = new FileWriter("aula2.txt", true);
            final BufferedWriter bufferedWriter = new BufferedWriter(writer);
        ) 
        {
            bufferedWriter.newLine();
            bufferedWriter.append("6 - Estamos indo rapido d+"); 
            bufferedWriter.newLine();
            bufferedWriter.append("7 - o carlos não sabe escrever..."); 
            bufferedWriter.newLine();
            bufferedWriter.flush();
                    
            
            
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
