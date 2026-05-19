package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame {

    private JButton boton1;
    private JButton boton2;
    private JButton boton3;
    private JButton boton4;
    private CardLayout cardLayout;

    public VentanaPrincipal() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 650);
        this.setLayout(new BorderLayout(0, 10));
        this.setLocationRelativeTo(null);

        JLabel labelTitulo = new JLabel();
        labelTitulo.setText("Artex");
        labelTitulo.setForeground(Color.white);

        JLabel labelRestoDelTitulo = new JLabel();
        labelRestoDelTitulo.setForeground(new Color(102, 16, 242));
        labelRestoDelTitulo.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 30));

        boton1 = new JButton();
        boton1.setBounds(700, 0, 100, 60);
        boton1.setText("Gestion de productos");
        boton1.setForeground(Color.white);
        boton1.setBackground(new Color(39, 5, 95));

        boton2 = new JButton();
        boton2.setBounds(500, 0, 100, 60);
        boton2.setText("clientes");
        boton2.setForeground(Color.white);
        boton2.setBackground(new Color(39, 5, 95));

        boton3 = new JButton();
        boton3.setBounds(550, 0, 100, 60);
        boton3.setText("Inventario");
        boton3.setForeground(Color.white);
        boton3.setBackground(new Color(39, 5, 95));

        boton4 = new JButton();
        boton4.setBounds(600, 0, 100, 60);
        boton4.setText("temporal");
        boton4.setForeground(Color.white);
        boton4.setBackground(new Color(39, 5, 95));

        JPanel panelNorte = new JPanel();
        JPanel panelSur = new JPanel();
        JPanel panelCentro = new JPanel();
        JPanel panel6 = new JPanel();

        panelNorte.setBackground(new Color(0, 68, 69));
        panelSur.setBackground(new Color(111, 185, 143));
        panelCentro.setBackground(new Color(22, 102, 178));
        panel6.setBackground(new Color(44, 120, 114));

        panelNorte.setLayout(new BorderLayout());
        panelNorte.setPreferredSize(new Dimension(100, 80));
        panelSur.setPreferredSize(new Dimension(100, 80));
        panelCentro.setPreferredSize(new Dimension(100, 100));
        panel6.setPreferredSize(new Dimension(100, 100));

        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);
        this.add(panelCentro, BorderLayout.CENTER);
        // Se omite la adición de panel6 en la misma posición CENTER para evitar solapamiento con panelCentro
        
        panelNorte.add(labelTitulo, BorderLayout.WEST);
        panelNorte.add(labelRestoDelTitulo, BorderLayout.CENTER);

        labelRestoDelTitulo.add(boton1);
        labelRestoDelTitulo.add(boton2);
        labelRestoDelTitulo.add(boton3);
        labelRestoDelTitulo.add(boton4);

        cardLayout = new CardLayout();
        panelCentro.setLayout(cardLayout);
    }

    public void conectarControlador(ActionListener controlador) {
        boton1.addActionListener(controlador);
        boton2.addActionListener(controlador);
        boton3.addActionListener(controlador);
        boton4.addActionListener(controlador);
    }

    public JButton getBtnGestionProductos() { return boton1; }
    public JButton getBtnClientes() { return boton2; }
    public JButton getBtnInventario() { return boton3; }
    public JButton getBtnTemporal() { return boton4; }
}


/*
package vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class VentanaPrincipal extends JFrame implements ActionListener{
 
        JButton boton1,boton2,boton3,boton4;
        CardLayout cardLayout;
    	VentanaInventario ventana1 = new VentanaInventario();
    	VentanaClientes ventanaCata1 = new VentanaClientes();
    	VentanaGestionProductos ventanaRecom1 = new VentanaGestionProductos();
    	
    //constructor
    public VentanaPrincipal(){ 
	        //generalidades del frame      
                this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 650);
		this.setLayout(new BorderLayout(0,10)); //espacio entre regiones
		
               this.setLocationRelativeTo(null); //aparece el frame en el centro
                //imagenes e iconos utilizados instanciados como labels
               //ImageIcon imgnTitulo = new ImageIcon("iconoTitulo(1).png");
                
                //labels utilizado para el titulo
                JLabel labelTitulo = new JLabel();
                labelTitulo.setText("Artex");
                labelTitulo.setForeground(Color.white);//color de la letra
                //
                JLabel labelRestoDelTitulo = new JLabel();//parte del titulo donde se mueven los botones
                labelRestoDelTitulo.setForeground(new Color(102,16,242));
                labelRestoDelTitulo.setLayout(new FlowLayout(FlowLayout.TRAILING, 10, 30));//trailing es para que los componentes en este layout abrazen el lado derecho de la pantalla
               // labelTitulo.setFont(new("Open Sans")); //cambiar fuente,checar fuentes existentes

               //terminar de instanciar los botones dentro del constructor
                
                
                
             
               boton1 = new JButton();
               boton1.setBounds(700, 0, 100, 60);
               boton1.setText("Gestion de productos");
   
               ActionListener ventanaRec = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						crearVentanaRecomendados();
					}
				};

				boton1.addActionListener(ventanaRec);
               
               boton1.setForeground(Color.white);
               boton1.setBackground(new Color(39,5,95));
               
               boton2 = new JButton();
               boton2.setBounds(500, 0, 100, 60);
               boton2.setText("clientes");
               
               ActionListener ventanaCat = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						crearVentanaCatalogo();
					}
				};

				boton2.addActionListener(ventanaCat);
               
               boton2.setForeground(Color.white);
               boton2.setBackground(new Color(39,5,95));
               
               //Boton3
               boton3 = new JButton();
               boton3.setBounds(550, 0, 100, 60);
               boton3.setText("Inventario"); //

               ActionListener oyenteDeAccion = new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						crearVentanaInventario();
					}
				};

				boton3.addActionListener(oyenteDeAccion);
               boton3.setForeground(Color.white);
               boton3.setBackground(new Color(39,5,95));
               
               //Boton4
               boton4 = new JButton();
               boton4.setBounds(600, 0, 100, 60);
               boton4.setText("temporal");
               boton4.addActionListener(this);
               boton4.setForeground(Color.white);
               boton4.setBackground(new Color(39,5,95));
            
                //paneles para las 5 posiciones del Gridbag
		JPanel panelNorte = new JPanel();//norte,titulo
		//JPanel panel2 = new JPanel();//oeste
		//JPanel panel3 = new JPanel();//este
		JPanel panelSur = new JPanel();//sur
		JPanel panelCentro = new JPanel();//centro1
                JPanel panel6 = new JPanel();//centro2
                
		//colores de los paneles
		//panelNorte.setBackground(new Color(39,5,95));
		panelNorte.setBackground(new Color(0, 68, 69));// Color CadetBlue
		//panel2.setBackground(new Color(22,102,178));
		//panel3.setBackground(Color.lightGray);
		panelSur.setBackground(new Color(111, 185, 143));//Panel sur, Color Greenery
		panelCentro.setBackground(new Color(22,102,178));//centro1
		//panel6.setBackground(new Color(0,0,0)); 
		panel6.setBackground(new Color(44, 120, 114)); //Color Rain
		
		
                //el layout del panel uno esta null para poder mover los componentes manualmente
		panelNorte.setLayout(new BorderLayout());//panelNorte es el norte-titulo
                
		//dimensiones de los paneles		
		panelNorte.setPreferredSize(new Dimension(100,80));
		//panel2.setPreferredSize(new Dimension(150,100));
		//panel3.setPreferredSize(new Dimension(150,100));
		panelSur.setPreferredSize(new Dimension(100,80));
		panelCentro.setPreferredSize(new Dimension(100,100));
		panel6.setPreferredSize(new Dimension(100,100));
		//sub paneles andentro del panel 5 "centro"
/*
		JPanel panel6 = new JPanel();
		JPanel panel7 = new JPanel();
		JPanel panel8 = new JPanel();
		JPanel panel9 = new JPanel();
		JPanel panelNorte0 = new JPanel();
		//colores de los sub paneles 
                
		panel6.setBackground(Color.black);
		panel7.setBackground(Color.darkGray);
		panel8.setBackground(Color.gray);
		panel9.setBackground(Color.lightGray);
		panelNorte0.setBackground(Color.white);
		
		panelCentro.setLayout(new BorderLayout());
				
		panel6.setPreferredSize(new Dimension(50,50));
		panel7.setPreferredSize(new Dimension(50,50));
		panel8.setPreferredSize(new Dimension(50,50));
		panel9.setPreferredSize(new Dimension(50,50));
		panelNorte0.setPreferredSize(new Dimension(50,50));
	        
		panelCentro.add(panel6,BorderLayout.NORTH);
		panelCentro.add(panel7,BorderLayout.SOUTH);
		panelCentro.add(panel8,BorderLayout.WEST);
		panelCentro.add(panel9,BorderLayout.EAST);
		panelCentro.add(panelNorte0,BorderLayout.CENTER);
		//agregar paneles a sus respectivas posiciones
	
		this.add(panelNorte,BorderLayout.NORTH);
		//this.add(panel2,BorderLayout.WEST);
		//this.add(panel3,BorderLayout.EAST);
		this.add(panelSur,BorderLayout.SOUTH);
		this.add(panelCentro,BorderLayout.CENTER);
                this.add(panel6,BorderLayout.CENTER);
                //panel norte-titulo agregar label y botones
                panelNorte.add(labelTitulo,BorderLayout.WEST);
                panelNorte.add(labelRestoDelTitulo,BorderLayout.CENTER);

               // panelNorte.add(boton1,BorderLayout.EAST);
               // panelNorte.add(boton2,BorderLayout.EAST);
               // panelNorte.add(boton3,BorderLayout.EAST);
                //panelNorte.add(boton4,BorderLayout.EAST);
                labelRestoDelTitulo.add(boton1);
                labelRestoDelTitulo.add(boton2);
                labelRestoDelTitulo.add(boton3);
                labelRestoDelTitulo.add(boton4);
                
                cardLayout = new CardLayout();
                panelCentro.setLayout(cardLayout);
                
               // panel6 p6 = new panel6();
                
       
               //se hace visible al final cuando ya todo esta cargado
               this.setVisible(true);
    }
    
    private void crearVentanaInventario() {
    
		ventana1.setVisible(true);//Hacemos visible la ventana1

    }
    
    private void crearVentanaCatalogo() {
    	ventanaCata1.setVisible(true);
    }
    
    private void crearVentanaRecomendados() {
    	ventanaRecom1.setVisible(true);
    }
    
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==boton1){
        
        }
        if(e.getSource()==boton2){
         // ProjectoGrid.DISPOSE_ON_CLOSE();  
          //instancia el nuevo frame  
        }
        if(e.getSource()==boton3){
         // ProjectoGrid.DISPOSE_ON_CLOSE();  
    //instancia el nuevo frame  
        }
        if(e.getSource()==boton4){
         // ProjectoGrid.DISPOSE_ON_CLOSE();  
       //instancia el nuevo frame  
        }
      }

   
}
*/

