/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Calendar;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author nenodias
 */
public class CandleTest {
    
    public CandleTest() {
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
     * Test of getAbertura method, of class Candle.
     */
    @Test(expected=IllegalArgumentException.class)
    public void precoMaximoNaoPodeSerMenorQueMinimo(){
        new Candle(new BigDecimal("10")
                , new BigDecimal("20")
                , new BigDecimal("20")
                , new BigDecimal("10")
                , new BigDecimal("10000")
                , Calendar.getInstance());
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void dataNaoPodeSerNula(){
        new Candle(new BigDecimal("10")
                , new BigDecimal("20")
                , new BigDecimal("20")
                , new BigDecimal("30")
                , new BigDecimal("10000")
                , null);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void valoresNegativos(){
        new Candle(new BigDecimal("10")
                , new BigDecimal("20")
                , new BigDecimal("10")
                , new BigDecimal("30")
                , new BigDecimal("-10000")
                , Calendar.getInstance());
    }
    
    @Test
    public void aberturaIgualAoFechamentoEhAlta(){
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
