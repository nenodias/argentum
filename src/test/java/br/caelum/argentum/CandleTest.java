package br.caelum.argentum;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class CandleTest {

    public CandleTest() {
    }

    @BeforeAll
    public static void setUpClass() {
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
    }

    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAbertura method, of class Candle.
     */
    @Test
    public void precoMaximoNaoPodeSerMenorQueMinimo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Candle(new BigDecimal("10")
                    , new BigDecimal("20")
                    , new BigDecimal("20")
                    , new BigDecimal("10")
                    , new BigDecimal("10000")
                    , Calendar.getInstance());
        });
    }

    @Test
    public void dataNaoPodeSerNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Candle(new BigDecimal("10")
                    , new BigDecimal("20")
                    , new BigDecimal("20")
                    , new BigDecimal("30")
                    , new BigDecimal("10000")
                    , null);
        });
    }

    @Test
    public void valoresNegativos() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Candle(new BigDecimal("10")
                    , new BigDecimal("20")
                    , new BigDecimal("10")
                    , new BigDecimal("30")
                    , new BigDecimal("-10000")
                    , Calendar.getInstance());
        });
    }

    @Test
    public void aberturaIgualAoFechamentoEhAlta() {
        Candle candle = new Candle(
                new BigDecimal("10")//Abertura
                , new BigDecimal("10")//Fechamento
                , new BigDecimal("30")//Minimo
                , new BigDecimal("30")//Maximo
                , new BigDecimal("10000")//Volume
                , Calendar.getInstance());
        assertTrue(candle.isAlta());
    }
}
