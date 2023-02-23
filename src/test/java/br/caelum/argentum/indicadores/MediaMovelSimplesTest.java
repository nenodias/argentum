package br.caelum.argentum.indicadores;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.caelum.argentum.SerieTemporal;

public class MediaMovelSimplesTest {

    public MediaMovelSimplesTest() {
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
     * Test of calcula method, of class MediaMovelSimples.
     */
    @Test
    public void testCalcula() {
        assertThrows(NullPointerException.class, () -> {
            System.out.println("calcula");
            int posicao = 0;
            SerieTemporal serie = null;
            MediaMovelSimples instance = new MediaMovelSimples(new IndicadorFechamento());
            BigDecimal expResult = null;
            BigDecimal result = instance.calcula(posicao, serie);
            assertEquals(expResult, result);
            // TODO review the generated test code and remove the default call to fail.
        });
    }

    @Test
    public void sequnciaSimplesDeCandles() {
        BigDecimal constante = new BigDecimal("3", MathContext.DECIMAL32);
        SerieTemporal serie = GeradorDeSerie.criaSerie(new BigDecimal("1"), new BigDecimal("2"), new BigDecimal("3"), new BigDecimal("4"),
                new BigDecimal("3"), new BigDecimal("4"), new BigDecimal("5"), new BigDecimal("4"), new BigDecimal("3"));
        MediaMovelSimples mms = new MediaMovelSimples(new IndicadorFechamento());

        assertEquals(new BigDecimal("2.00", MathContext.DECIMAL32), mms.calcula(2, serie));
        assertEquals(new BigDecimal("3.00", MathContext.DECIMAL32), mms.calcula(3, serie));
        assertEquals(new BigDecimal("3.333333", MathContext.DECIMAL32), mms.calcula(4, serie));
        assertEquals(new BigDecimal("3.666667", MathContext.DECIMAL32), mms.calcula(5, serie));
        assertEquals(new BigDecimal("4.00", MathContext.DECIMAL32), mms.calcula(6, serie));
        assertEquals(new BigDecimal("4.333333", MathContext.DECIMAL32), mms.calcula(7, serie));
        assertEquals(new BigDecimal("4.00", MathContext.DECIMAL32), mms.calcula(8, serie));
    }

}
