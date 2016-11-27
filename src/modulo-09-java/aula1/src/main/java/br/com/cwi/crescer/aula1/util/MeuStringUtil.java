package br.com.cwi.crescer.aula1.util;

import static java.text.Normalizer.Form.NFD;

import java.text.Normalizer;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuStringUtil {

    private static final String MARKS = "\\p{InCombiningDiacriticalMarks}+";
    private static final String VOGAIS = "[aeiou]";

    private String normalizer(final String string) {
        return Normalizer.normalize(string, NFD).replaceAll(MARKS, "");
    }

    /**
     * Recebe uma string e conta quantas vogais existem nela.
     *
     * @param string
     * @return int
     */
    public int contaVogais(final String string) {
        final String stringLower = string.toLowerCase();
        return stringLower.length() - stringLower.replaceAll(VOGAIS, "").length();
    }

    /**
     * Recebe uma string e a inverte.
     *
     * @param string
     * @return string
     */
    public String inverteString(final String string) {
        return new StringBuilder(string).reverse().toString();
    }

    /**
     * Recebe uma string e valida se a mesma está nula ou em branco.
     *
     * @param string
     * @return true or false
     */
    public boolean isEmpty(final String string) {
        return string == null || string.trim().isEmpty();
    }

    /**
     * Recebe uma string e verifica se a mesma é um palindromo.
     *
     * @param string
     * @return true or false
     */
    public boolean isPalindromo(final String string) {
        if (!isEmpty(string)) {
            final String stringNormalizer = normalizer(string).replaceAll("\\s", "");
            return stringNormalizer.equalsIgnoreCase(inverteString(stringNormalizer));
        }
        return false;
    }

}
