package classes.util.itens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;




public class ItemLinhaHorizontal extends Item{

	
private int comprimento;
	
	
	


	public ItemLinhaHorizontal(int x, int y, int comprimento){
		
	super(x, y, 1);
	
	this.comprimento = comprimento<0?0:comprimento;
	
	this.setTipo(Item.TIPO_LINHA);		
	}


	


	public void get(Graphics2D g, Font fonte, Color cor){
	
	if(g==null)
	return;
	
	g.drawLine(this.getX(), this.getY(), this.getX()+this.comprimento, this.getY());
	}
	

	
	
	
	
}
