/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.ui;

import br.caelum.argentum.Negocio;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;

/**
 *
 * @author nenodias
 */
public class ArgentumUI {
    private JFrame janela;
    private JPanel painelPrincipal;
    private JTable tabela;
	private JPanel painelBotoes;
    
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt","BR"));//Dizendo que a aplicação usará o local padrão do Brasil
        new ArgentumUI().montaTela();
    }
    
    private void montaTela(){
        preparaJanela();
        preparaPainelPrincipal();
        preparaTitulo();
        preparaTabela();
        preparaPainelBotoes();
        preparaBotaoCarregar();
        preparaBotaoSair();
        mostraJanela();
    }

    private void preparaPainelBotoes() {
		painelBotoes = new JPanel(new GridLayout());
		painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);
	}

	private void preparaJanela() {
        janela = new JFrame("Argentum");
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void preparaPainelPrincipal() {
        painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new BorderLayout());
        janela.add(painelPrincipal);
    }

    private void preparaBotaoCarregar() {
        JButton botaoCarregar = new JButton("Carregar XML");
        //Ação do Botão
        botaoCarregar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
             List<Negocio>lista = new EscolhedorDeXML().escolhe();   
             NegociosTableModel ntm = new NegociosTableModel(lista);
             tabela.setModel(ntm);
            }
        });
        //Fim da Ação do Botão
        painelBotoes.add(botaoCarregar);
    }

    private void preparaBotaoSair() {
        JButton botaoSair = new JButton("Sair");
        botaoSair.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                System.exit(0);
            }
         }
        );
        painelBotoes.add(botaoSair);
    }

    private void mostraJanela() {
        janela.pack();
        janela.setSize(540, 540);
        janela.setVisible(true);
    }

    private void preparaTabela() {
        tabela = new JTable();
        
        JScrollPane scroll = new JScrollPane();
        scroll.getViewport().add(tabela);
        painelPrincipal.add(scroll, BorderLayout.CENTER);
    }

    private void preparaTitulo() {
        JLabel titulo = new JLabel("Lista de Negócios", SwingConstants.CENTER);
        titulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painelPrincipal.add(titulo, BorderLayout.NORTH);
    }
}
