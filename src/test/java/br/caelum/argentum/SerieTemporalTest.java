/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author nenodias
 */
public class SerieTemporalTest {
    
    public SerieTemporalTest() {
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
     * Test of getCandle method, of class SerieTemporal.
     */
    @Test(expected = IllegalArgumentException.class)
    public void naoPodeReceberUmaListaNula(){
      SerieTemporal serie = new SerieTemporal(null);
    }
}
