package br.caelum.argentum.indicadores;

import br.caelum.argentum.Candle;
import br.caelum.argentum.SerieTemporal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

class GeradorDeSerie {

    public static SerieTemporal criaSerie(BigDecimal... valores) {
        List<Candle> candles = new ArrayList<Candle>();
        for (BigDecimal valor : valores) {
            candles.add(new Candle(valor, valor, valor, valor, valor, Calendar.getInstance()));
        }
        return new SerieTemporal(candles);
    }

}
