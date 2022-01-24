package classes.util.itens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;




public class ItemImagem extends Item{

	

public BufferedImage img;	
	



	public ItemImagem(BufferedImage img, int x, int y){
	
	super(x, y, img!=null? img.getHeight():0);	
		
	this.img = img;
		
	this.setTipo(Item.TIPO_IMG);
	}



	
	public void get(Graphics2D g, Font fonte, Color cor){
	
	if(g==null)
	return;
	
	if(this.img==null)
	return;
	
	g.drawImage(this.img, this.getX(), this.getY(),  this.img.getWidth(), this.img.getHeight(), null);
	}
	

	
	
	
}
