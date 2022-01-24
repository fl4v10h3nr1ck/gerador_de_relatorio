package classes.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import classes.util.itens.Item;
import classes.util.itens.ItemImagem;
import classes.util.itens.ItemLinhaHorizontal;
import classes.util.itens.ItemNovaPagina;
import classes.util.itens.ItemTexto;





public class Grupo {

	
public List<Item> itens;	
	
public boolean pode_ser_quebrado;

private int altura_linha;

private int cursor_y;



	public Grupo(){
		
	this(true);	
	}




	
	public Grupo(boolean pode_ser_quebrado){
		
	itens	= new ArrayList<Item>();
	
	this.pode_ser_quebrado = pode_ser_quebrado;
	
	this.setAlturaDeLinha(12);
	
	this.cursor_y =0;
	}



	
	public void setAlturaDeLinha(int altura){this.altura_linha= altura<5?5:altura;}
	
	
	
	
	public int getAlturaDaLinha(){return this.altura_linha;}
	
	

	
/*******************************************************************************************/	
	

	
	public void novaLinha(){
	
		if(this.itens.size()==0){
		
		this.cursor_y += this.getAlturaDaLinha();
		return;
		}
	
	Item item = this.itens.get(this.itens.size()-1);
			
	this.cursor_y += item.getAltura();
	}
	
	
	
	
	
	
	public int getAltura(){
		
	int altura = 0;	
		for(Item item: this.itens){
		
		if((item.getAltura()+item.getY())>altura)
		altura = item.getAltura()+item.getY();
		}	
		
	return altura;
	}

	
	
	
	
/*******************************************************************************************/	
	
	
	
	public void addTexto(String texto, int x){this.addTexto(texto, x, null, null);	}
	
	public void addTexto(String texto, int x, Font fonte){this.addTexto(texto, x, fonte, null);	}
				
	public void addTexto(String texto, int x, Color cor){this.addTexto(texto, x, null, cor);}		
				
	public void addTexto(String texto, int x, Font fonte, Color cor){
	
	ItemTexto	item  = new ItemTexto(texto, x, this.cursor_y, this.getAlturaDaLinha());	
	
	item.setFonte(fonte);
	item.setCor(cor);
	
	this.itens.add(item);		
	}
	
	
	
	public void addImagem(BufferedImage img, int x){
		
	this.itens.add(new ItemImagem(img, x, this.cursor_y));		
	}
	
	

	public void addLinhaHorizontal(int x, int comprimento){	
	
	this.itens.add(new ItemLinhaHorizontal(x, this.cursor_y, comprimento));
	}
	
	
	
	public void addNovaPagina(){
	
	this.itens.add(new ItemNovaPagina());
	
	this.cursor_y = 0;
	}
		
	
	
	

}
