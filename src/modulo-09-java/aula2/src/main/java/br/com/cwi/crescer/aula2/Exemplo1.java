package br.com.cwi.crescer.aula2;

import java.io.File;
import java.util.Arrays;

/**
 * @author Carlos H. Nonnemacher
 */
public class Exemplo1 {

    public static void main(String a[]) {
        try {

            final File file = new File("aula2.txt");
            final boolean b = file.createNewFile();
            if (file.exists()) {
                System.out.println(file.getAbsolutePath());
            }
            final String path = "D:\\crescer-2016-2";

            Arrays.asList(new File(path).
                    listFiles(f -> f.getName().contains(".md"))
            ).forEach(System.out::println);

        } catch (Exception e) {
        }
    }

}
