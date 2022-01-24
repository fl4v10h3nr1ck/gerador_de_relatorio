package classes.util.itens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;




public class ItemTexto extends Item{

	
	
public String valor;
	


	public ItemTexto(String valor, int x, int y, int altura){
		
	super(x, y, altura);
			
	this.valor = valor==null?"":valor;
		
	this.setTipo(Item.TIPO_TEXTO);		
	}



	

	public void get(Graphics2D g, Font fonte, Color cor){
	
	if(g==null)
	return;
	
	Font f = this.getFonte();
	
	if(f==null)
	f = fonte;	
		
	if(f!=null)	
	g.setFont(f);
	
	
	Color c = this.getCor();
	
	if(c==null)
	c = cor;	
		
	if(c!=null)	
	g.setColor(c);
	
	g.drawString(this.valor, this.getX(), this.getY());
	}
	

	
	
	
	
}
