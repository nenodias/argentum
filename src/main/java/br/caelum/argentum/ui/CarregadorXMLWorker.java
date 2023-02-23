package br.caelum.argentum.ui;

import java.util.List;

import javax.swing.JTable;
import javax.swing.SwingWorker;

import br.caelum.argentum.Negocio;

public class CarregadorXMLWorker extends SwingWorker<List<Negocio>, Void> {

    private JTable tabela;

    public CarregadorXMLWorker(JTable tabela) {
        this.tabela = tabela;
    }

    @Override
    protected List<Negocio> doInBackground() throws Exception {
        return new EscolhedorDeXML().escolhe();
    }

}
