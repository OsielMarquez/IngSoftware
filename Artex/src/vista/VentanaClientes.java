
package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class VentanaClientes extends JFrame{
	
	CardLayout cardLayout;
	public JPanel panel;
	JPanel panelCentro;
	
	public VentanaClientes() {
		setSize(800, 650);// Ancho y largo, tamaño de la ventana
		setDefaultCloseOperation(EXIT_ON_CLOSE);// Cerrar
		setTitle("clientes");
		setLocationRelativeTo(null);// Establecemos la ventana en el centro
		setResizable(true);// La ventana es redimensionable
		this.setLayout(new BorderLayout(0, 10)); // espacio entre regiones

		iniciar();
	}

	private void iniciar() {
		
		panels();
		otro();
	}

	private void panels() {
		// labels utilizado para el titulo
		JLabel labelTitulo = new JLabel();

		labelTitulo.setText("Catalogo");
		labelTitulo.setForeground(Color.white);// color de la letra

		JPanel panelNorte = new JPanel();// norte,titulo
		JPanel panelSur = new JPanel();// sur
		panelCentro = new JPanel();// centro1
		// colores de los paneles
		

		panelNorte.setBackground(new Color(0, 68, 69));// Color CadetBlue

		panelSur.setBackground(new Color(111, 185, 143));// Panel sur, Color Greenery
		panelCentro.setBackground(new Color( 106,177,135));// centro1 color lagoon

		// el layout del panel uno esta null para poder mover los componentes
		// manualmente
		panelNorte.setLayout(new BorderLayout());// panelNorte es el norte-titulo

//dimensiones de los paneles		
		panelNorte.setPreferredSize(new Dimension(100, 80));

		panelSur.setPreferredSize(new Dimension(100, 80));
		panelCentro.setPreferredSize(new Dimension(100, 100));


//agregar paneles a sus respectivas posiciones

		this.add(panelNorte, BorderLayout.NORTH);
		this.add(panelSur, BorderLayout.SOUTH);
		this.add(panelCentro, BorderLayout.CENTER);
		// panel norte-titulo agregar label y botones
		panelNorte.add(labelTitulo, BorderLayout.WEST);
	}
	private void otro(){
	

				

	}
}
