package br.caelum.argentum.reader;

import org.junit.jupiter.api.Assertions;

import java.io.StringReader;
import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;

import br.caelum.argentum.Negocio;

public class LeitorXMLTest {

    @Test
    public void carregaXmlComNegocioEmListaUnitaria() {
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
        Assertions.assertEquals(1, negocios.size());
        Assertions.assertEquals(new BigDecimal("43.5"), negocios.get(0).getPreco());
        Assertions.assertEquals(1000, negocios.get(0).getQuantidade());
    }

    @Test
    public void zeroNegocios() {
        String xmlDeTeste = ""
                + "<list>"
                + "</list>";

        LeitorXML leitor = new LeitorXML();
        List<Negocio> negocios = leitor.carrega(new StringReader(xmlDeTeste));
        Assertions.assertEquals(0, negocios.size());
    }

    @Test
    public void maisNegocios() {
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
        Assertions.assertEquals(3, negocios.size());
    }
}
