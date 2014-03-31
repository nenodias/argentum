package br.caelum.argentum;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.caelum.argentum.reader.CandleFactory;

/**
 *
 * @author nenodias
 */
public class CandleFactoryTest {
    
    public CandleFactoryTest() {
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
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
     @Test
     public void sequenciaSimplesDeNegocio() {
         Calendar hoje = Calendar.getInstance();
         
         Negocio negocio1 = new Negocio("40.5",100,hoje);
         Negocio negocio2 = new Negocio("45.0",100,hoje);
         Negocio negocio3 = new Negocio("39.8",100,hoje);
         Negocio negocio4 = new Negocio("42.3",100,hoje);
         
         List<Negocio>negocios = Arrays.asList(negocio1,negocio2,negocio3,negocio4);
         
         CandleFactory fabrica = new CandleFactory();
         Candle candle = fabrica.constroiCandleParaData(hoje, negocios);
         
         //TESTES DO ASSERT
         assertEquals(new BigDecimal("40.5"), candle.getAbertura());
         assertEquals(new BigDecimal("42.3"), candle.getFechamento());
         assertEquals(new BigDecimal("39.8"), candle.getMinimo());
         assertEquals(new BigDecimal("45.0"), candle.getMaximo());
         assertEquals(new BigDecimal("16760.0"), candle.getVolume());
         
     }
     @Test
     public void semNegociosGeraCandleComZeros(){
         Calendar hoje = Calendar.getInstance();
         
         List<Negocio> negocios = new ArrayList<>();
         
         CandleFactory factory = new CandleFactory();
         Candle candle = factory.constroiCandleParaData(hoje, negocios);
         
         assertEquals(new BigDecimal("0"), candle.getVolume());
         assertEquals(new BigDecimal("0"), candle.getAbertura());
         assertEquals(new BigDecimal("0"), candle.getFechamento());
         assertEquals(new BigDecimal("0"), candle.getMaximo());
         assertEquals(new BigDecimal("0"), candle.getMinimo());
     }
     
     @Test
     public void apenasUmNegocioGeraCandleComValoresIguais(){
         Calendar hoje = Calendar.getInstance();
         
         Negocio negocio1 = new Negocio("40.5", 100, hoje);
         
         List<Negocio> negocios = Arrays.asList(negocio1);
         
         CandleFactory factory = new CandleFactory();
         Candle candle = factory.constroiCandleParaData(hoje, negocios);
         
         assertEquals(new BigDecimal("40.5"), candle.getAbertura());
         assertEquals(new BigDecimal("40.5"), candle.getFechamento());
         assertEquals(new BigDecimal("40.5"), candle.getMinimo());
         assertEquals(new BigDecimal("40.5"), candle.getMaximo());
         assertEquals(new BigDecimal("4050.0"), candle.getVolume());
     }
     
     @Test
     public void paraNegociosDeTresDiasDistintosGeraCandles(){
         Calendar hoje = Calendar.getInstance();
         
         Negocio negocio1 = new Negocio("40.5", 100, hoje);
         Negocio negocio2 = new Negocio("45.0", 100, hoje);
         Negocio negocio3 = new Negocio("39.8", 100, hoje);
         Negocio negocio4 = new Negocio("42.3", 100, hoje);
         
         Calendar amanha = (Calendar) hoje.clone();
         amanha.add(Calendar.DAY_OF_MONTH, 1);
         
         Negocio negocio5 = new Negocio("48.8", 100, amanha);
         Negocio negocio6 = new Negocio("49.3", 100, amanha);
         
         Calendar depois = (Calendar) amanha.clone();
         depois.add(Calendar.DAY_OF_MONTH,1);
         
         Negocio negocio7 = new Negocio("51.8", 10, depois);
         Negocio negocio8 = new Negocio("52.3", 100, depois);
         
         List<Negocio> negocios = Arrays.asList(negocio1,negocio2,negocio3,negocio4,
                 negocio5,negocio6,negocio7,negocio8);
         
         CandleFactory fabrica = new CandleFactory();
         List<Candle> candles = fabrica.constroiCandles(negocios);
         
         assertEquals(3, candles.size());
         assertEquals(new BigDecimal("40.5"), candles.get(0).getAbertura());
         assertEquals(new BigDecimal("42.3"), candles.get(0).getFechamento());
         assertEquals(new BigDecimal("48.8"), candles.get(1).getAbertura());
         assertEquals(new BigDecimal("49.3"), candles.get(1).getFechamento());
         assertEquals(new BigDecimal("51.8"), candles.get(2).getAbertura());
         assertEquals(new BigDecimal("52.3"), candles.get(2).getFechamento());
     }
     
     @Test
     public void candlesDeDatasDesordenadas(){
         Calendar hoje = Calendar.getInstance();
         
         Negocio negocio1 = new Negocio("40.5", 100, hoje);
         Negocio negocio2 = new Negocio("45.0", 100, hoje);
         
         Negocio negocio4 = new Negocio("42.3", 100, hoje);
         
         Calendar amanha = (Calendar) hoje.clone();
         amanha.add(Calendar.DAY_OF_MONTH, -1);
         
         
         Negocio negocio5 = new Negocio("48.8", 100, amanha);
         Negocio negocio3 = new Negocio("39.8", 100, hoje);
         
         Calendar depois = (Calendar) amanha.clone();
         depois.add(Calendar.DAY_OF_MONTH,-1);
         
         Negocio negocio7 = new Negocio("51.8", 10, depois);
         Negocio negocio8 = new Negocio("52.3", 100, depois);
         Negocio negocio6 = new Negocio("49.3", 100, amanha);
         
         List<Negocio> negocios = Arrays.asList(negocio1,negocio2,negocio3,negocio4,
                 negocio5,negocio6,negocio7,negocio8);
         
         CandleFactory fabrica = new CandleFactory();
         List<Candle> candles = fabrica.constroiCandles(negocios);
         assertEquals(3, candles.size());
         assertEquals(new BigDecimal("40.5"), candles.get(2).getAbertura());
         assertEquals(new BigDecimal("42.3"), candles.get(2).getFechamento());
         assertEquals(new BigDecimal("48.8"), candles.get(1).getAbertura());
         assertEquals(new BigDecimal("49.3"), candles.get(1).getFechamento());
         assertEquals(new BigDecimal("51.8"), candles.get(0).getAbertura());
         assertEquals(new BigDecimal("52.3"), candles.get(0).getFechamento());
     }
}
