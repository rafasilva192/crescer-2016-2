package br.com.cwi.crescer.aula1.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Carlos H. Nonnemacher
 */
public final class Parcelator {

    private static final String PATTERN = "dd/MM/yyyy";
    private static final DateFormat DATE_FORMAT = new SimpleDateFormat(PATTERN);
    private static final NumberFormat NUMBER_FORMAT = NumberFormat.getCurrencyInstance();

    private final BigDecimal valor;
    private final int parcelas;
    private final double juros;
    private final Date vencimento;

    private Parcelator(BigDecimal valor, int parcelas, double juros, Date vencimento) {
        this.valor = valor;
        this.parcelas = parcelas;
        this.juros = juros;
        this.vencimento = vencimento;
    }

    public static Parcelator novoParcelamento(final BigDecimal valor, final int parcelas, final double juros, final Date vencimento) {
        return new Parcelator(valor, parcelas, juros, vencimento);
    }

    public Map<String, String> calcular() {

        final BigDecimal qtdParcelas = BigDecimal.valueOf(parcelas);
        final BigDecimal vlTotal = valor.multiply(BigDecimal.valueOf(juros).divide(BigDecimal.valueOf(100)).add(BigDecimal.ONE));
        final BigDecimal vlParcela = vlTotal.divide(qtdParcelas, 2, RoundingMode.HALF_UP);

        // Calcula se existe resto na soma das parcelas.
        BigDecimal vlResto = vlParcela.multiply(qtdParcelas).subtract(vlTotal);

        final Map<String, String> map = new LinkedHashMap<>();

        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(vencimento);

        for (int i = 0; i < parcelas; i++) {
            map.put(DATE_FORMAT.format(calendar.getTime()), NUMBER_FORMAT.format(vlParcela.subtract(vlResto)));
            vlResto = BigDecimal.ZERO;
            calendar.add(Calendar.MONTH, 1);
        }
        return map;
    }

}
