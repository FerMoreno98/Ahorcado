package Interfaz;


import java.awt.*;

import javax.swing.*;

public class Ahorcado {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MarcoAhorcado m=new MarcoAhorcado();
		
		m.setVisible(true);
		
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}

class MarcoAhorcado extends JFrame{
	
	public MarcoAhorcado() {
		
		Toolkit miPantalla=Toolkit.getDefaultToolkit();
		
		Dimension Tamano=miPantalla.getScreenSize();
		
		int ancho=Tamano.width;
		
		int alto=Tamano.height;
		
		setBounds(ancho/4,alto/4,ancho/2,alto/2);
		
		add(new LaminaAhorcado());
		
		
	}
	
}

class LaminaAhorcado extends JPanel{
	
	public LaminaAhorcado() {
		
		
		
	}
	
}