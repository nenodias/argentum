/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.testes;

import br.caelum.argentum.Negocio;
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.Calendar;

/**
 *
 * @author nenodias
 */
public class TestaXml {
    public static void main(String[] args) {
        Negocio negocio = new Negocio("42.3", 1000, Calendar.getInstance());
        
        XStream stream = new XStream(new DomDriver());
        stream.processAnnotations(Negocio.class);//Avisando que irá puxar as anotações da classe
        System.out.println(stream.toXML(negocio));
    }
}
