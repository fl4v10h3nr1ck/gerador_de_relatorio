package classes.util.itens;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;


public abstract class Item {

	
private int x;

private int y;

private int altura;


private Font fonte;

private Color cor;


public static final int TIPO_TEXTO=1;
public static final int TIPO_IMG=2;
public static final int TIPO_LINHA=3;
public static final int TIPO_QUEBRA=4;


private int tipo;




	public Item(int x, int y, int altura){
		
	this.setX(x<0?0:x);
		
	this.setY(y<0?0:y);
	
	this.setAltura(altura);
	
	this.setFonte(null);
	
	this.setFonte(null);
	}



	
	
	public void setFonte(Font fonte){this.fonte = fonte;}
	
	public Font getFonte(){return this.fonte;}
	
	public int getX() {	return x;}

	public void setX(int x) {	this.x = x;}

	public int getY() {	return y;}

	public void setY(int y) {	this.y = y;}

	public Color getCor() {	return cor;}

	public void setCor(Color cor) {	this.cor = cor;}

	public int getTipo() {	return tipo;}

	public void setTipo(int tipo) {	this.tipo = tipo;}

	public void setAltura(int altura) {this.altura = altura;}

	public int getAltura() {return this.altura;}
	
	

	public abstract void get(Graphics2D g, Font fonte, Color cor);
	

	
	
}
