/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.indicadores;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.math.MathContext;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.caelum.argentum.SerieTemporal;

/**
 *
 * @author nenodias
 */
public class MediaMovelPonderadaTest {
    
    public MediaMovelPonderadaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calcula method, of class MediaMovelSimples.
     */
    
    @Test
    public void sequnciaSimplesDeCandles(){
        BigDecimal constante = new BigDecimal("6", MathContext.DECIMAL32);
        SerieTemporal serie = GeradorDeSerie.criaSerie(new BigDecimal("1"), new BigDecimal("2"),
                new BigDecimal("3"), new BigDecimal("4"), new BigDecimal("5"),new BigDecimal("6"));
        MediaMovelPonderada mms = new MediaMovelPonderada();
        
        assertEquals(new BigDecimal("2.333333", MathContext.DECIMAL32), mms.calcula(2, serie));
        assertEquals(new BigDecimal("3.333333", MathContext.DECIMAL32), mms.calcula(3, serie));
        assertEquals(new BigDecimal("4.333333", MathContext.DECIMAL32), mms.calcula(4, serie));
        assertEquals(new BigDecimal("5.333333", MathContext.DECIMAL32), mms.calcula(5, serie));
    }
    
}
