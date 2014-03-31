/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.reader;

import br.caelum.argentum.Negocio;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.Reader;
import java.util.List;

public class LeitorXML {
    public List<Negocio> carrega(Reader fonte){
        XStream stream = new XStream(new DomDriver());
        stream.alias("negocio", Negocio.class);
        return (List<Negocio>) stream.fromXML(fonte);
    }
}
