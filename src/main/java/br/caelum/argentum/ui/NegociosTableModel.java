/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.ui;

import br.caelum.argentum.Negocio;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author nenodias
 */
public class NegociosTableModel extends AbstractTableModel{
    private final List<Negocio> negocios;
    
    public NegociosTableModel(List<Negocio> negocios){
       this.negocios = negocios; 
    }

    @Override
    public int getRowCount() {
        return negocios.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columIndex) {
        Negocio n = negocios.get(rowIndex);
        
        switch(columIndex){
            case 0:
//                Locale brasil = new Locale("pt","BR");
//                NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance(brasil);
                NumberFormat formatadorMoeda = NumberFormat.getCurrencyInstance();
                return formatadorMoeda.format(n.getPreco().doubleValue());
            case 1:
                return n.getQuantidade();
            case 2:
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                return sdf.format(n.getData().getTime());
        }
        
        return "";
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "Preço";
            case 1:
                return "Quantidade";
            case 2:
                return "Data";
        }
        return "";
    }
}
