package br.com.cwi.crescer.aula1;

/**
 * @author Carlos H. Nonnemacher
 */
public class StringRun {

    public int contaVogais(final String s) {
//        return s.toLowerCase().replaceAll("[^a]", "").length()
//                + s.toLowerCase().replaceAll("[^e]", "").length()
//                + s.toLowerCase().replaceAll("[^i]", "").length()
//                + s.toLowerCase().replaceAll("[^o]", "").length()
//                + s.toLowerCase().replaceAll("[^u]", "").length();
        return s.toLowerCase().length() - s.toLowerCase().replaceAll("[aeiou]", "").length();
    }

    public String inverteString(final String s) {
//        char[] array = new char[s.length()];
//        for (int i = s.length(); i > 0; i--) {
//            array[s.length() - i] = s.toCharArray()[i - 1];
//        }
//        return new String(array);
        // Usando a forma simples.
        return new StringBuilder(s).reverse().toString();
    }

}
