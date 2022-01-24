package classes.util;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;





public class FormDeExibicao extends JDialog{

	
private static final long serialVersionUID = 1L;


private Relatorio relatorio;


private int pag_atual;


private JPanel p_relatorio_geral;
private JPanel p_area_relatorio;
private JScrollPane scroll;


private JLabel paginacao;





	public FormDeExibicao(Relatorio relatorio) {
	
	super();
		
	this.setTitle(relatorio.titulo);
	this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	this.setSize(	GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width,
					GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height);
	this.setLocationRelativeTo(null);
	this.setLayout(new GridBagLayout());
	this.setModal(true);
			
	this.relatorio = relatorio;
	
	this.pag_atual = 1;
	
	
		this.addKeyListener(new KeyAdapter(){
		
		public void keyPressed(KeyEvent ek){
					
		
		if(ek.getKeyCode() == KeyEvent.VK_P)
		acaoPrincipal();	
			
		if(ek.getKeyCode() == KeyEvent.VK_S)
		acaoPrincipal();
		
		if(ek.getKeyCode() == KeyEvent.VK_Z)
		aplicarZoom();
		}});
	
	
	this.adicionarComponentes();
	}

	

	
	
	public void mostrar(){
	
	this.addOuvinte(this);	
		
	this.setVisible(true);	
	}
	
	
	
	
	
	public void adicionarComponentes() {	
		
		
	GridBagConstraints cons = new GridBagConstraints();  

	cons.fill = GridBagConstraints.BOTH;
	cons.weighty  = 1;
	cons.gridwidth  = GridBagConstraints.REMAINDER;	
	cons.weightx = 1;
	cons.insets = new Insets(0, 0, 0, 0);
	JPanel p_fundo = new JPanel(new GridBagLayout());
	p_fundo.setBackground(new Color(233, 235, 238));
	this.add(p_fundo, cons);
	
	cons.fill = GridBagConstraints.HORIZONTAL;
	cons.weighty  = 0;
	cons.insets = new Insets(0, 0, 5, 0);
	JPanel p_opcoes = new JPanel(new GridBagLayout());
	p_opcoes.setBackground(new Color(38, 46, 57));
	p_fundo.add(p_opcoes, cons);
	
	cons.fill = GridBagConstraints.NONE;
	cons.weightx  = 0;
	cons.gridwidth  = 1;	
	cons.insets = new Insets(2, 10, 2, 10);
	JButton bt_imprimir = new JButton(new ImageIcon(getClass().getResource("/icons/impressora.png")));
	bt_imprimir.setToolTipText("Imprimir relatório (atalho tecla \"p\")");
	p_opcoes.add(bt_imprimir, cons);
	
	JButton bt_pdf = new JButton(new ImageIcon(getClass().getResource("/icons/pdf.png")));
	bt_pdf.setToolTipText("Salvar relatório em PDF (atalho tecla \"s\")");
	p_opcoes.add(bt_pdf, cons);
	
	JButton bt_zoom = new JButton(new ImageIcon(getClass().getResource("/icons/zoom.png")));
	bt_zoom.setToolTipText("Aumentar/reduzir dimensões do relatório (atalho tecla \"z\")");
	p_opcoes.add(bt_zoom, cons);
	
	
	
	cons.fill = GridBagConstraints.HORIZONTAL;
	cons.gridwidth  = GridBagConstraints.REMAINDER;
	cons.weightx  = 1;
	p_opcoes.add(new JLabel(""), cons);
	
	
	cons.fill = GridBagConstraints.BOTH;
	cons.insets = new Insets(0, 0, 0, 0);
	cons.weighty  = 1;
	this.p_relatorio_geral = new JPanel(null);
	p_relatorio_geral.setBackground(new Color(233, 235, 238));
	p_fundo.add(p_relatorio_geral, cons);
	
	
	this.p_area_relatorio = new JPanel(new GridBagLayout());
	this.p_area_relatorio.setBackground(Color.WHITE);
	this.p_area_relatorio.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));

	this.scroll = new JScrollPane(this.p_area_relatorio);

	p_relatorio_geral.add(scroll);		
	
	
	cons.fill = GridBagConstraints.HORIZONTAL;
	cons.weighty  = 0;
	cons.weightx = 1;
	cons.insets = new Insets(5, 0, 0, 0);
	JPanel painel_paginacao = new JPanel(new GridBagLayout());
	painel_paginacao.setBackground(new Color(38, 46, 57));
	p_fundo.add(painel_paginacao, cons);	
	
	

	cons.fill = GridBagConstraints.NONE;
	cons.gridwidth = 1;
	cons.weighty  = 0;
	cons.weightx = 0;
	cons.insets = new Insets(2, 2, 2, 2);
	JButton bt_prev = new JButton(new ImageIcon(getClass().getResource("/icons/anterior.png")));
	bt_prev.setToolTipText("Página Anterior (atalho tecla \"seta para esquerda\")");
	painel_paginacao.add(bt_prev, cons);
	
	JButton bt_pri_page = new JButton(new ImageIcon(getClass().getResource("/icons/primeira_pag.png")));
	bt_pri_page.setToolTipText("Primeira Página (atalho tecla \"seta para cima\")");
	painel_paginacao.add(bt_pri_page, cons);
	
	
	cons.insets = new Insets(2, 10, 2, 10);
	painel_paginacao.add(paginacao = new JLabel(""), cons);
	paginacao.setForeground(Color.white);
	
	cons.insets = new Insets(2, 2, 2, 2);
	JButton bt_utl_page = new JButton(new ImageIcon(getClass().getResource("/icons/ultima_pag.png")));
	bt_utl_page.setToolTipText("Última Página (atalho tecla \"seta para baixo\")");
	painel_paginacao.add(bt_utl_page, cons);
	
	cons.gridwidth  = GridBagConstraints.REMAINDER;	
	JButton bt_next = new JButton(new ImageIcon(getClass().getResource("/icons/proximo.png")));
	bt_next.setToolTipText("Próxima Página (atalho tecla \"seta para direita\")");
	painel_paginacao.add(bt_next, cons);

	
	
	
		bt_prev.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
		    	
		paginaAnterior();
		}});
	
		
		
		bt_pri_page.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
			    	
		primeiraPagina();
		}});

		
		
		bt_utl_page.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
			    	
		ultimaPagina();
		}});

		
		
		bt_next.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
			    	
		proximaPagina();	
		}});
		

		
		bt_imprimir.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
		
		acaoPrincipal();
		}});
	
				

		bt_pdf.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
		
		salvar();
		}});
	
		
		
		bt_zoom.addActionListener( new ActionListener(){
		@Override
		public void actionPerformed( ActionEvent event ){
			
		aplicarZoom();
		}});
		
			

		p_area_relatorio.addMouseListener(new MouseAdapter(){	
		@Override
		public void mouseClicked( MouseEvent event ){
			
		aplicarZoom();	
		}});		
		
		
		
	this.atualizaPagina();
	
	this.aplicarZoom();
	}

	
	
	
	public void salvar() {
		
	if(relatorio.salvar())
	JOptionPane.showMessageDialog(null, "Relatório salvo com sucesso.", "SUCESSO", JOptionPane.INFORMATION_MESSAGE);	
	}		

	
	
	public void acaoPrincipal() {
	
	if(!this.relatorio.imprimir())
	JOptionPane.showMessageDialog(null, "Um erro ocorreu ao enviar o relatório para impressão.", "ERRO", JOptionPane.ERROR_MESSAGE);	
	}

	
	
	
	private void atualizaPagina(){
		
	this.p_area_relatorio.removeAll();	
	this.p_area_relatorio.repaint();
		
	GridBagConstraints cons = new GridBagConstraints();  

	cons.fill = GridBagConstraints.BOTH;
	cons.gridwidth  = GridBagConstraints.REMAINDER;	
	cons.weighty  = 1;
	cons.weightx = 1;
	cons.insets = new Insets(0, 0, 0, 0);
			
	this.p_area_relatorio.add(this.relatorio.getPagina(this.pag_atual), cons);
	this.p_area_relatorio.revalidate();
		
	this.paginacao.setText(String.format("Mostrando página %d de %d", this.pag_atual, this.relatorio.getNumeroDePaginas()));	
	}
	
	
	
	

	private void proximaPagina(){
		
	if(this.pag_atual< relatorio.getNumeroDePaginas())	
	this.pag_atual++;	
	
	this.atualizaPagina();
	}
	


	
	private void paginaAnterior(){
	
	if(this.pag_atual>1)
	this.pag_atual--;
	else
	this.pag_atual=1;
	
	this.atualizaPagina();
	}
		
	
	
	
	private void primeiraPagina(){
		
	this.pag_atual = 1;
	this.atualizaPagina();
	}
			
	
	
	
	private void ultimaPagina(){
		
	this.pag_atual = relatorio.getNumeroDePaginas();
	this.atualizaPagina();
	}
			
		
	
	
	private void aplicarZoom(){
	
	double maior_escala = 1.5;	
	double menor_escala = 0.7;
		
	if(this.relatorio.getEscala()!=maior_escala)		
	this.relatorio.setEscala(maior_escala);	
	else
	this.relatorio.setEscala(menor_escala);	
	
	System.out.println("escala "+this.relatorio.getEscala());
	
	int altura_total = this.getHeight();
	int comprimento_total = this.getWidth();
	
	System.out.println("altura total "+altura_total);
	System.out.println("comprimento total "+comprimento_total);
	
	
	int comprimento_scroll = (int)(this.relatorio.getComprimentoTotal()*this.relatorio.getEscala())+30;
	int altura_scroll = altura_total-115;
	
	if(comprimento_scroll>=comprimento_total-20)
	comprimento_total -=100;
	
	System.out.println("comprimento_scroll "+comprimento_scroll);
	System.out.println("altura_scroll "+altura_scroll);
	
	this.scroll.setSize(comprimento_scroll, altura_scroll);
	this.scroll.setLocation((int)((comprimento_total - comprimento_scroll)/2), 0);
	
	
	
	this.p_area_relatorio.setPreferredSize(new Dimension((int)(this.relatorio.getComprimentoTotal()*this.relatorio.getEscala()), (int)(this.relatorio.getAlturaTotal()*this.relatorio.getEscala())));
	
			
	this.p_area_relatorio.revalidate();
	this.p_area_relatorio.repaint();
	
	this.p_relatorio_geral.revalidate();	
	this.p_relatorio_geral.repaint();
	}	




 	private void addOuvinte(Container container) {  
		
 	for (Component c : container.getComponents())       
 	addOuvinte((Container)c); 
 			
 	container.addKeyListener(new KeyAdapter(){
		
		public void keyPressed(KeyEvent ek){
					
		
		if(ek.getKeyCode() == KeyEvent.VK_P)
		acaoPrincipal();	
			
		if(ek.getKeyCode() == KeyEvent.VK_S)
		salvar();
		
		if(ek.getKeyCode() == KeyEvent.VK_Z)
		aplicarZoom();
		
		if(ek.getKeyCode() == KeyEvent.VK_LEFT)
		paginaAnterior();
			
		if(ek.getKeyCode() == KeyEvent.VK_RIGHT)
		proximaPagina();
		
		if(ek.getKeyCode() == KeyEvent.VK_UP)
		primeiraPagina();
				
		if(ek.getKeyCode() == KeyEvent.VK_DOWN)
		ultimaPagina();
			
		
		}});
 	} 
 
 	
 	
 	
}
