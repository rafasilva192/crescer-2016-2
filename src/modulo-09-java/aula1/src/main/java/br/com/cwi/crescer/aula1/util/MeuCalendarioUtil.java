package br.com.cwi.crescer.aula1.util;

import static java.util.Calendar.DAY_OF_WEEK;

import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Carlos H. Nonnemacher
 */
public class MeuCalendarioUtil {

    private static final String ANOS_NESSES_DIAS = "Ano(s) %s, messes %s, dia(s) %s";

    /**
     * Recebe uma data e retorna o dia da semana.
     *
     * @param date
     * @return string
     */
    public String diaSemana(final Date date) {
        if (date == null) {
            return null;
        }

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        switch (calendar.get(DAY_OF_WEEK)) {
            case 1:
                return "Domingo";
            case 2:
                return "Segunda";
            case 3:
                return "Terça";
            case 4:
                return "Quarta";
            case 5:
                return "Quinta";
            case 6:
                return "Sexta";
            case 7:
                return "Sabado";
            default:
                return null;
        }
    }

    /**
     * Recebe uma data e o tempo de vida (Ano(s) %s, messes %s, dia(s) %s)
     *
     * @param date
     * @return string
     */
    public String tempoDecorrido(final Date date) {
        if (date == null) {
            return null;
        }
        final Calendar calendar = Calendar.getInstance();
        long diff = new Date().getTime() - date.getTime();
        calendar.setTime(new Date(diff));

                
                
        return String.format(ANOS_NESSES_DIAS, calendar.get(Calendar.YEAR) - 1970, calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        
        
    }
    public String tempoDecorrido(final LocalDate localDate) {
        final Period between = Period.between(localDate, LocalDate.now());
        return String.format(ANOS_NESSES_DIAS, between.getYears(), between.getMonths(), between.getDays());
    }

}
