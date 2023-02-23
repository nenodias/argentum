package br.caelum.argentum.reader;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

import br.caelum.argentum.Candle;

public class CandleBuilderTest {

    @Test
    public void geracaoDeCandleDeveTerTodosOsDadosNecessarios() {
        assertThrows(IllegalArgumentException.class, () -> {

            CandleBuilder builder = new CandleBuilder()
                    .comAbertura(new BigDecimal("40.50"))
                    .comFechamento(new BigDecimal("42.30"))
                    .comMinimo(new BigDecimal("39.80"))
//        .comMaximo(new BigDecimal("45.0"))
                    .comVolume(new BigDecimal("16760.00"))
                    .comData(new GregorianCalendar(2012, 8, 12, 0, 0, 0));
            Candle candle = builder.geraCandle();
        });
    }
}
