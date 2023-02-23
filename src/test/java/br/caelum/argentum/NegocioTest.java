package br.caelum.argentum;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NegocioTest {

    public NegocioTest() {
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
     * Test of getPreco method, of class Negocio.
     */
    @Test
    public void dataDoNegocioEhImutavel() {
        //Se criar um calendar no dia 12
        Calendar c = Calendar.getInstance();
        c.set(Calendar.DAY_OF_MONTH, 12);
        Negocio n = new Negocio("10", 5, c);

        //Ainda que eu tente mudar a data
        n.getData().set(Calendar.DAY_OF_MONTH, 15);
        assertEquals(12, n.getData().get(Calendar.DAY_OF_MONTH));
    }

    @Test
    public void testaOPreco() {
        Calendar c = Calendar.getInstance();
        Negocio n = new Negocio("20", 10, c);
        n.getPreco().add(new BigDecimal("30"));
        assertEquals(new BigDecimal("20"), n.getPreco());
    }

    //   Teste que  deve receber uma exeção
    @Test
    public void naoCriaNegocioComDataNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Negocio("20", 1, null);
        });
    }

    @Test
    public void mesmoMillissegundoEhDoMesmoDia() {
        Calendar agora = Calendar.getInstance();
        Calendar mesmoMomento = (Calendar) agora.clone();

        Negocio negocio = new Negocio("40.0", 100, agora);
        assertTrue(negocio.isMesmoDia(mesmoMomento));
    }

    @Test
    public void mesmoDiaHorasDiferentes() {
        Calendar manha = new GregorianCalendar(2011, 10, 20, 8, 30);
        Calendar tarde = new GregorianCalendar(2011, 10, 20, 15, 30);

        Negocio negocio = new Negocio("40.0", 100, manha);
        assertTrue(negocio.isMesmoDia(tarde));
    }
}
