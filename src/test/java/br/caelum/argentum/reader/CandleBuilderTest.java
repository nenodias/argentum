/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.reader;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import org.junit.Test;

import br.caelum.argentum.Candle;

/**
 *
 * @author nenodias
 */
public class CandleBuilderTest {
    
    /**
     * Test of comAbertura method, of class CandleBuilder.
     */
    @Test(expected=IllegalArgumentException.class)
    public void geracaoDeCandleDeveTerTodosOsDadosNecessarios(){
        CandleBuilder builder = new CandleBuilder()
        .comAbertura(new BigDecimal("40.50"))
        .comFechamento(new BigDecimal("42.30"))
        .comMinimo(new BigDecimal("39.80"))
//        .comMaximo(new BigDecimal("45.0"))
        .comVolume(new BigDecimal("16760.00"))
        .comData(new GregorianCalendar(2012,8, 12, 0, 0, 0));
        Candle candle = builder.geraCandle();
    }
}
