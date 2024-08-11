package Interfaz;


import java.awt.*;
import java.awt.event.*;
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
	
	private JPanel laminaLetras;
	
	private String [] palabras= {"camarero", "fotografia", "monitor", "bufanda"};
	
	public LaminaAhorcado() {
		
		setLayout(new BorderLayout());
		
		//Lamina para las letras 
		
		laminaLetras=new JPanel();
		
		laminaLetras.setLayout(new GridLayout(3,9,5,5));
		
		CreaBotones("A");
		
		CreaBotones("B");
		
		CreaBotones("C");
		
		CreaBotones("D");
		
		CreaBotones("E");
		
		CreaBotones("F");
		
		CreaBotones("G");
		
		CreaBotones("H");
		
		CreaBotones("I");
		
		CreaBotones("J");
		
		CreaBotones("K");
		
		CreaBotones("L");
		
		CreaBotones("M");
		
		CreaBotones("N");
		
		CreaBotones("Ñ");
		
		CreaBotones("O");
		
		CreaBotones("P");
		
		CreaBotones("Q");
		
		CreaBotones("R");
		
		CreaBotones("S");
		
		CreaBotones("T");
		
		CreaBotones("U");
		
		CreaBotones("V");
		
		CreaBotones("W");
		
		CreaBotones("X");
		
		CreaBotones("Y");
		
		CreaBotones("Z");
		
		add(laminaLetras,BorderLayout.SOUTH);
		
		
		
		
		
	}
	
	public void CreaBotones(String texto) {
		
		JButton boton=new JButton(texto);
		
		laminaLetras.add(boton);
		
	}
	
	private class AccionLetras implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			
			
		}
		
	}
	
	
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
		int indice=1;
		
		String palabraEscogida=palabras[indice];
		
		int longitudPalabra=palabraEscogida.length();
		
		int espacioEntreLetras=20;
		
		int anchoTotal=longitudPalabra*espacioEntreLetras;
		
		int xInicial=(getWidth()-anchoTotal)/2;
		
		int y=getHeight()/2;
		
		
				
				for (int j = 0; j < longitudPalabra; j++) {
					
					int coordenadax1=xInicial+j*espacioEntreLetras;
					
					int coordenadax2=coordenadax1+10;
					
					g.drawLine(coordenadax1, y, coordenadax2, y);
					
					
					
					
					
				}
			
			
		
		
		
	indice++;	
	}
	
}