package classes.teste;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import classes.util.FormDeExibicao;
import classes.util.Grupo;
import classes.util.Relatorio;
import classes.util.itens.Item;

public class Teste {

	
	
	public static void main(String[] args){
		
		try{
		UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
	    
	    //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); 
		}
	    catch (ClassNotFoundException | 
	    		InstantiationException | 
	    		IllegalAccessException | 
	    		UnsupportedLookAndFeelException e) {e.printStackTrace();}
		
	Teste teste = new Teste();	
	teste.gerar();	
	}
	
	
	
	public void gerar(){
		
	Rel rel = new 	Rel();
	
	
	
	Grupo grupo = new Grupo();	
	
	grupo.setAlturaDeLinha(10);
	
	grupo.addTexto("texto 1", 0);
	grupo.addTexto("texto 1", 100);
	grupo.addTexto("texto 1", 200);
	grupo.addTexto("texto 1", 600);
	grupo.novaLinha();
	grupo.addTexto("texto 1", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 1", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 1", 0);
	
	grupo.addNovaPagina();
	
	grupo.addTexto("texto 1", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 1", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 1", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 1", 0);
	
	grupo.addNovaPagina();
	
	grupo.addTexto("texto 1", 0);
	
	
	rel.add(grupo);
	
	
	
	for(Item item: grupo.itens){

	System.out.println(item.getX() +" "+item.getY()+" "+item.getAltura());	
	}
	
	
	
	/*
	grupo = new Grupo(false);	
	
	grupo.setAlturaDeLinha(10);
	
	grupo.addTexto("texto 2", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 2", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 2", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 2", 0);
	grupo.novaLinha();
	grupo.addTexto("texto 2", 0);
	
	rel.add(grupo);
	*/
	
	/*
	JDialog dia = new JDialog();
	
	dia.setTitle("teste");
	dia.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	dia.setSize(1000 , 700);
	dia.setLocationRelativeTo(null);
	dia.setLayout(new GridBagLayout());
	dia.setModal(true);
	dia.getRootPane().setBackground(Color.BLACK);  
	
	
	GridBagConstraints cons = new GridBagConstraints();  

	cons.fill = GridBagConstraints.BOTH;
	cons.weighty  = 1;
	cons.weightx = 1;
	cons.insets = new Insets(10, 10, 10, 10);
	
	cons.gridwidth  = 1;	
	dia.add(rel.getPagina(1), cons);
	
	dia.setVisible(true);
	
	rel.imprimir();
	*/
	FormDeExibicao form = new FormDeExibicao(rel);
	form.mostrar();
	
	
	//rel.salvar();
	}
	
	
	
	
	
	
	
	
	
	
	
	public class Rel extends Relatorio{

		
		public Rel(){
			
		super("Guia de Atendimento");	
		}
		
		
		
		
		
		@Override
		public Grupo cabecalho() {
		
		Grupo grupo = new Grupo();	
			
		grupo.setAlturaDeLinha(10);
			
		grupo.addTexto("cabeçalho", 0);
		grupo.addTexto("cabeçalho", 300);
				
		return grupo;
		}

		@Override
		public Grupo rodape() {
		
		Grupo grupo = new Grupo();		
			
		grupo.setAlturaDeLinha(10);
			
		grupo.addTexto("rodape", 0);
		grupo.addTexto("rodape", 300);
					
		return grupo;
		}
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
}
