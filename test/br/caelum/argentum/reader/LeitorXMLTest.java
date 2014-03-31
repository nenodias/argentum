/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import br.caelum.argentum.Negocio;

/**
 *
 * @author nenodias
 */
public class LeitorXMLTest {
    

    /**
     * Test of carrega method, of class LeitorXML.
     */
    @Test
    public void carregaXmlComNegocioEmListaUnitaria(){
        String xmlDeTeste = ""
                + "<list>"
                    + "<negocio>"
                        + "<preco>43.5</preco>"
                        + "<quantidade>1000</quantidade>"
                        + "<data>"
                          + "<time>1322233344455</time>"
                        + "</data>"
                    + "</negocio>"
                + "</list>";
        
        LeitorXML leitor = new LeitorXML();
        List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
        assertEquals(1, negocios.size());
        assertEquals(new BigDecimal("43.5"),negocios.get(0).getPreco());
        assertEquals(1000, negocios.get(0).getQuantidade());
    }
    
    @Test
    public void zeroNegocios(){
        String xmlDeTeste = ""
                + "<list>"
                + "</list>";
        
        LeitorXML leitor = new LeitorXML();
        List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
        assertEquals(0, negocios.size());
    }
    
    @Test
    public void maisNegocios(){
        String xmlDeTeste = ""
                + "<list>"
                    + "<negocio>"
                        + "<preco>43.5</preco>"
                        + "<quantidade>1000</quantidade>"
                        + "<data>"
                          + "<time>1322233344455</time>"
                        + "</data>"
                    + "</negocio>"
                    + "<negocio>"
                        + "<preco>42.0</preco>"
                        + "<quantidade>100</quantidade>"
                        + "<data>"
                          + "<time>1322233344455</time>"
                        + "</data>"
                    + "</negocio>"
                    + "<negocio>"
                        + "<preco>13.5</preco>"
                        + "<quantidade>4050</quantidade>"
                        + "<data>"
                          + "<time>1322233344455</time>"
                        + "</data>"
                    + "</negocio>"
                + "</list>";
        
        LeitorXML leitor = new LeitorXML();
        List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
        assertEquals(3, negocios.size());
    }
}
