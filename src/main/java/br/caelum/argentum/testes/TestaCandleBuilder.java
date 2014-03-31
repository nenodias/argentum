/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.testes;

import br.caelum.argentum.Candle;
import br.caelum.argentum.reader.CandleBuilder;
import java.math.BigDecimal;
import java.util.GregorianCalendar;

/**
 *
 * @author nenodias
 */
public class TestaCandleBuilder {
    public static void main(String[] args) {
        //Duas Formas essa
        CandleBuilder builder = new CandleBuilder()
        .comAbertura(new BigDecimal("40.50"))
        .comFechamento(new BigDecimal("42.30"))
        .comMinimo(new BigDecimal("39.80"))
        .comMaximo(new BigDecimal("45.0"))
        .comVolume(new BigDecimal("16760.00"))
        .comData(new GregorianCalendar(2012,8, 12, 0, 0, 0));
        Candle candle = builder.geraCandle();
        //Esta
//         CandleBuilder builder = new CandleBuilder();
//         builder.comAbertura(new BigDecimal("40.50"));
//         builder.comFechamento(new BigDecimal("42.30"));
//         builder.comMinimo(new BigDecimal("39.80"));
//         builder.comMaximo(new BigDecimal("45.0"));
//         builder.comVolume(new BigDecimal("16760.00"));
//         builder.comData(new GregorianCalendar(2012,8, 12, 0, 0, 0));
//         Candle candle = builder.geraCandle();

        
        System.out.println (candle);
    }
}
