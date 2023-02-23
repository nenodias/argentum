package br.caelum.argentum;

import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


public class SerieTemporalTest {

    public SerieTemporalTest() {
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
     * Test of getCandle method, of class SerieTemporal.
     */
    @Test
    public void naoPodeReceberUmaListaNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            SerieTemporal serie = new SerieTemporal(null);
        });
    }
}
