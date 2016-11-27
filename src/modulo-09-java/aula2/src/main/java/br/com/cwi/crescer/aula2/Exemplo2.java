package br.com.cwi.crescer.aula2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author Carlos H. Nonnemacher
 */
public class Exemplo2 {

    public static void main(String[] args) throws IOException {

        try (   
            final Reader reader = new FileReader("aula2.txt");
            final BufferedReader bufferReader = new BufferedReader(reader);
        ) {
            
            bufferReader.lines()
                    .forEach(System.out::println);
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
