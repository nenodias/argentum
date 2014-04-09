/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.caelum.argentum.ui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.text.MaskFormatter;

import br.caelum.argentum.Candle;
import br.caelum.argentum.Indicador;
import br.caelum.argentum.Negocio;
import br.caelum.argentum.SerieTemporal;
import br.caelum.argentum.grafico.GeradorDeGrafico;
import br.caelum.argentum.indicadores.IndicadorAbertura;
import br.caelum.argentum.indicadores.IndicadorFechamento;
import br.caelum.argentum.reader.CandleFactory;

import java.awt.event.MouseAdapter;

/**
 *
 * @author nenodias
 */
public class ArgentumUI {
    private JFrame janela;
    private JPanel painelPrincipal;
    private JTable tabela;
	private JPanel painelBotoes;
	private JTabbedPane abas;
	private JFormattedTextField campoData;
	private MenuIndicadores menuIndicadores;
    
    public static void main(String[] args) {
        Locale.setDefault(new Locale("pt","BR"));//Dizendo que a aplicação usará o local padrão do Brasil
        new ArgentumUI().montaTela();
    }
    
    private void montaTela(){
        preparaJanela();
        preparaMenu();
        preparaPainelPrincipal();
        preparaAbas();
        preparaTitulo();
        preparaTabela();
        preparaPainelBotoes();
        preparaCampoData();
        preparaBotaoCarregar();
        preparaBotaoSair();
        mostraJanela();
    }

    private void preparaMenu() {
		JMenuBar menuBar = new JMenuBar();
		janela.setJMenuBar(menuBar);
		
		menuIndicadores = new MenuIndicadores(); 
		menuBar.add(menuIndicadores.getMenuBar());
		
		JMenu carregar = new JMenu("Carregar");
		menuBar.add(carregar);
		carregar.addMouseListener(new MouseAdapter(){ 
			@Override
			public void mousePressed(MouseEvent e) {
				carregaDados();
			}
		});
		JMenu sair = new JMenu("Sair"); 
		sair.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				sair();
			}
		});
		menuBar.add(sair);
	}

	private void preparaCampoData() {
    	try {
    		JLabel label = new JLabel("Apenas a partir de:");
		
    		
			MaskFormatter mascara = new MaskFormatter("##/##/####");
			mascara.setPlaceholderCharacter('_');
			campoData = new JFormattedTextField(mascara);
			painelBotoes.add(label);
			painelBotoes.add(campoData);
		} catch (ParseException e) {
			e.printStackTrace();
		} 
	}

	private void preparaAbas() {
		abas = new JTabbedPane();
		abas.addTab("Tabela", null);
		abas.addTab("Gráfico", null);
		painelPrincipal.add(abas);
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
        janela.getContentPane().add(painelPrincipal);
    }

    private void preparaBotaoCarregar() {
        JButton botaoCarregar = new JButton("Carregar XML");
        //Ação do Botão
        botaoCarregar.addActionListener( new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
             carregaDados();
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
            	sair();
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
        scroll.setViewportView(tabela);
//        painelPrincipal.add(scroll, BorderLayout.CENTER);
        abas.setComponentAt(0, scroll);
    }

    private void preparaTitulo() {
        JLabel titulo = new JLabel("Lista de Negócios", SwingConstants.CENTER);
        titulo.setFont(new Font("Verdana", Font.BOLD, 25));
        painelPrincipal.add(titulo, BorderLayout.NORTH);
    }

	private void carregaDados() {
		tabela.clearSelection();
		List<Negocio>lista = new EscolhedorDeXML().escolhe();
		if(campoData.getValue() != null){
			new FiltradorPorData(campoData.getText()).filtra(lista);
		}
		
		ArgentumTableModel ntm = new ArgentumTableModel(lista);
		tabela.setModel(ntm);
		
		CandleFactory fabrica = new CandleFactory();
		List<Candle> candles = fabrica.constroiCandles(lista);
		SerieTemporal serie = new SerieTemporal(candles);
		
		GeradorDeGrafico gerador = new GeradorDeGrafico(serie, 2, serie.getTotal() - 1);
		
		List<Indicador> indicadores = menuIndicadores.getIndicadoresSelecionados();
		for (Indicador indicador : indicadores) {
			gerador.plotaIndicador(indicador);
		}
		abas.setComponentAt(1, gerador.getPanel());
	}
	
	public void sair(){
		System.exit(0);
	}
}
