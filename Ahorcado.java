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
	
	private int indice=0;
	
	private String palabraEscogida=palabras[indice];
	
	private JButton boton;
	
	private JLabel palabraConRayas;
	
	private String palabraConRayasSTR=crearRayas(palabras[indice]);
	
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
		
	}
	
	private class AccionLetras implements ActionListener{
		
		

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			JButton botonPulsado=(JButton)e.getSource();
			
			String letraPulsada=botonPulsado.getText();
			
			boolean letraCorrecta=false;
			
			
			StringBuilder palabraActualizada=new StringBuilder(palabraConRayasSTR);
			
			
			for (int i = 0; i < palabraEscogida.length(); i++) {
				
				char c=palabraEscogida.charAt(i);
				
				
				if(letraPulsada.equals(String.valueOf(c))) {
					
					botonPulsado.setBackground(Color.green);
					
					palabraActualizada.setCharAt(i, c);
					
					letraCorrecta=true;
					
					break;
				
				}
				
				
			}
			
			palabraConRayas.setText(palabraActualizada.toString());
			
			
			
			
			if(!letraCorrecta) {
				
				botonPulsado.setBackground(Color.red);
				
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
	
}