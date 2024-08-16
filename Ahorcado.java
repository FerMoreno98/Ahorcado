package Interfaz;


import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

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
	
	private String [] palabras= {"camarero", "fotografia"};
	
	private int indice=0;
	
	private JButton boton, contador;
	
	private JLabel palabraConRayas;
	
	private String palabraConRayasSTR;
	
	private int cont=0;
	
	ArrayList<JButton> botones=new ArrayList<>();
	
	public LaminaAhorcado() {
		
		setLayout(new BorderLayout());
		
		//Lamina para las letras 
		
		laminaLetras=new JPanel();
		
		laminaLetras.setLayout(new GridLayout(3,9,5,5));
		
		CreaBotones("a");
		
		CreaBotones("b");
		
		CreaBotones("c");
		
		CreaBotones("d");
		
		CreaBotones("e");
		
		CreaBotones("f");
		
		CreaBotones("g");
		
		CreaBotones("h");
		
		CreaBotones("i");
		
		CreaBotones("j");
		
		CreaBotones("k");
		
		CreaBotones("l");
		
		CreaBotones("m");
		
		CreaBotones("n");
		
		CreaBotones("ñ");
		
		CreaBotones("o");
		
		CreaBotones("p");
		
		CreaBotones("q");
		
		CreaBotones("r");
		
		CreaBotones("s");
		
		CreaBotones("t");
		
		CreaBotones("u");
		
		CreaBotones("v");
		
		CreaBotones("w");
		
		CreaBotones("x");
		
		CreaBotones("y");
		
		CreaBotones("z");
		
		add(laminaLetras,BorderLayout.SOUTH);
		
		palabraEscogida(palabras[indice]);
		
		palabraConRayasSTR=crearRayas(palabras[indice]);
		
		palabraConRayas=new JLabel(palabraConRayasSTR);
		
		palabraConRayas.setFont(new Font("Arial",Font.PLAIN,50));
		
		JPanel laminaPalabra=new JPanel();
		
		add(laminaPalabra,BorderLayout.CENTER);
		
		
		laminaPalabra.add(palabraConRayas);
		
		
		
		
	}
	
	public void CreaBotones(String texto) {
		
		boton=new JButton(texto);
		
		laminaLetras.add(boton);
		
		boton.addActionListener(new AccionLetras());
		
		botones.add(boton);
		
	}
	
	private class AccionLetras implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		
			
			JButton botonPulsado=(JButton)e.getSource();
			
			String letraPulsada=botonPulsado.getText();
			
			boolean letraCorrecta=false;
			
			
			StringBuilder palabraActualizada=new StringBuilder(palabraConRayasSTR);
			
			
			for (int i = 0; i < palabraEscogida(palabras[indice]).length(); i++) {
				
				char c=palabraEscogida(palabras[indice]).charAt(i);
				
				
				if(letraPulsada.equals(String.valueOf(c))) {
					
					botonPulsado.setBackground(Color.green);
					
					botonPulsado.setActionCommand("verde");
					
					palabraActualizada.setCharAt(i, c);
					
					letraCorrecta=true;
					
					
				
				}
				
				
			}
			
			palabraConRayas.setText(palabraActualizada.toString());
			
			palabraConRayasSTR=palabraActualizada.toString();
			
			if(!palabraConRayasSTR.contains("-")) {
				
				JOptionPane.showConfirmDialog(LaminaAhorcado.this, "¿Deseas continuar");
				
			
				
				indice++;
			
				try {
					
				palabraConRayasSTR=crearRayas(palabras[indice]);
				
				}catch(Exception e2) {
					
					JOptionPane.showMessageDialog(LaminaAhorcado.this, "Palabras terminadas");
					
					System.exit(1);
				}
				
				palabraConRayas.setText(palabraConRayasSTR);
				
				boolean verde=botonPulsado.getActionCommand()=="verde";
				
				boolean rojo=botonPulsado.getActionCommand()=="rojo";
				
				Color defaultBackground = UIManager.getColor("Button.background");
				
				for (JButton b:botones) {
					
					if(verde) {
						
						b.setBackground(defaultBackground);
						
					}
					
					if(rojo) {
						
						b.setBackground(defaultBackground);
					}
					
				}
				
			}
			
			
			if(!letraCorrecta) {
				
				botonPulsado.setBackground(Color.red);
				
				botonPulsado.setActionCommand("rojo");
				
				cont++;
				
			}
			
			if (cont==10 && indice!=palabras.length) {
				
				cont=0;
				
				JOptionPane.showConfirmDialog(LaminaAhorcado.this, "¿Desea continuar");
				
				indice++;
				
				boolean verde=botonPulsado.getActionCommand()=="verde";
				
				boolean rojo=botonPulsado.getActionCommand()=="rojo";
				
				Color defaultBackground = UIManager.getColor("Button.background");
				
				for (JButton b:botones) {
					
					if(verde) {
						
						b.setBackground(defaultBackground);
						
					}
					
					if(rojo) {
						
						b.setBackground(defaultBackground);
					}
					
				}
					
				
				try {
				palabraConRayasSTR=crearRayas(palabras[indice]);
				
				palabraConRayas.setText(palabraConRayasSTR);
				
				}catch(ArrayIndexOutOfBoundsException s) {
					
					JOptionPane.showMessageDialog(LaminaAhorcado.this, "Palabras terminadas");
					
					System.exit(1);
					
				}
				
				//crearRayas(palabraEscogida);
			}
			
			
			
		}
			}
		
	
	
	
	/*public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		
	
		
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
			
			
		
		
		
	
	}*/
	
	public String crearRayas(String palabra) {
		
		String nuevaPalabra="";
	
		
		for (int i = 0; i < palabra.length(); i++) {
		
			nuevaPalabra+="-";
			
		}
		
		return nuevaPalabra;
		
	}
	
	public static String palabraEscogida(String palabra) {
		
		String palabraEsc=palabra;
		
		return palabraEsc;
	}
	
}