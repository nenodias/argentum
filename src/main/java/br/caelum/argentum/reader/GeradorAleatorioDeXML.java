/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.reader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import br.caelum.argentum.Negocio;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author nenodias
 */
public class GeradorAleatorioDeXML {
    public static void main(String[] args) throws FileNotFoundException {
        Calendar data = Calendar.getInstance();
        Random random = new Random(123);
        List<Negocio> negocios = new ArrayList<>();
        
        int quantidade = 1000;
        double valor = 40;
        
        for (int dias = 0; dias < 30; dias++) {
            
            int quantidadeNegociosDoDia = random.nextInt(20);
                    
            
            for (int negocio = 0; negocio < quantidadeNegociosDoDia; negocio++) {
                //no maximo sobe ou cai 1 e nao baixa alem de 5
            valor += (random.nextInt(200) - 100) / 100.0;
            if(valor < 5.0){
                valor = 5.0;
            }
            
            //quantidade entre 500 e 1500
            quantidade += 1000 - random.nextInt(500);
            
            Negocio n = new Negocio(String.valueOf(valor),quantidade,data);
            negocios.add(n);
                
            }
            data = (Calendar) data.clone();
            data.add(Calendar.DAY_OF_YEAR,1);
            
        }
        XStream stream = new XStream(new DomDriver());
        stream.processAnnotations(Negocio.class);
        stream.setMode(XStream.NO_REFERENCES);//Tira a referência de Objetos Iguais no XML
        
        PrintStream out = new PrintStream(new File("negocios.xml"));
        out.println(stream.toXML(negocios));
        out.close();
        
    }
    
}
