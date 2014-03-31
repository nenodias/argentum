/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.ui;

import br.caelum.argentum.Negocio;
import br.caelum.argentum.reader.LeitorXML;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author nenodias
 */
public class EscolhedorDeXML {
    public List<Negocio> escolhe(){
        try{
            JFileChooser chooser = new JFileChooser();
            int retorno = chooser.showOpenDialog(null);
            
            if(retorno == JFileChooser.APPROVE_OPTION){
                FileReader reader = new FileReader(chooser.getSelectedFile());
                return new LeitorXML().carrega(reader);
//                List<Negocio> negocios = new LeitorXML().carrega(reader);
                
//                Negocio primeiroNegocio = negocios.get(0);
//                String mensagem = "Primeiro negócio: "+primeiroNegocio.getPreco();
//                JOptionPane.showMessageDialog(null, mensagem);
            }
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
