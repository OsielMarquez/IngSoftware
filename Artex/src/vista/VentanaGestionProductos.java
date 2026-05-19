package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class VentanaGestionProductos extends JFrame {
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JTextField txtPrecio;
	private JTextField txtStock;
	
	private JButton btnAgregar;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnLimpiar;
	
	private JTable tablaProductos;
	private DefaultTableModel modeloTabla;

	public VentanaGestionProductos() {
		setSize(800, 650);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Gestión de Productos");
		setLocationRelativeTo(null);
		setResizable(true);
		setLayout(new BorderLayout(0, 10));

		iniciar();
	}

	private void iniciar() {
		configurarPanelNorte();
		configurarPanelCentro();
		configurarPanelSur();
	}

	private void configurarPanelNorte() {
		JLabel labelTitulo = new JLabel("Gestión de Inventario de Productos");
		labelTitulo.setForeground(Color.WHITE);

		JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
		panelNorte.setBackground(new Color(0, 68, 69));
		panelNorte.setPreferredSize(new Dimension(100, 80));
		panelNorte.add(labelTitulo);

		add(panelNorte, BorderLayout.NORTH);
	}

	private void configurarPanelCentro() {
		JPanel panelCentro = new JPanel(new BorderLayout(0, 15));
		panelCentro.setBackground(new Color(161, 214, 226));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		JPanel panelFormulario = new JPanel(new GridLayout(2, 4, 10, 10));
		panelFormulario.setBackground(new Color(161, 214, 226));
		
		panelFormulario.add(new JLabel("Código:"));
		txtCodigo = new JTextField();
		panelFormulario.add(txtCodigo);

		panelFormulario.add(new JLabel("Nombre:"));
		txtNombre = new JTextField();
		panelFormulario.add(txtNombre);

		panelFormulario.add(new JLabel("Precio:"));
		txtPrecio = new JTextField();
		panelFormulario.add(txtPrecio);

		panelFormulario.add(new JLabel("Stock:"));
		txtStock = new JTextField();
		panelFormulario.add(txtStock);

		panelCentro.add(panelFormulario, BorderLayout.NORTH);

		String[] columnas = {"Código", "Nombre", "Precio", "Stock"};
		modeloTabla = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaProductos = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaProductos);
		
		panelCentro.add(scrollTabla, BorderLayout.CENTER);
		add(panelCentro, BorderLayout.CENTER);
	}

	private void configurarPanelSur() {
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 25));
		panelSur.setBackground(new Color(111, 185, 143));
		panelSur.setPreferredSize(new Dimension(100, 80));

		btnAgregar = new JButton("Agregar");
		btnModificar = new JButton("Modificar");
		btnEliminar = new JButton("Eliminar");
		btnLimpiar = new JButton("Limpiar");

		panelSur.add(btnAgregar);
		panelSur.add(btnModificar);
		panelSur.add(btnEliminar);
		panelSur.add(btnLimpiar);

		add(panelSur, BorderLayout.SOUTH);
	}

	public void conectarControlador(ActionListener controlador) {
		btnAgregar.addActionListener(controlador);
		btnModificar.addActionListener(controlador);
		btnEliminar.addActionListener(controlador);
		btnLimpiar.addActionListener(controlador);
	}

	public String getCodigo() { return txtCodigo.getText().trim(); }
	public String getNombre() { return txtNombre.getText().trim(); }
	public String getPrecio() { return txtPrecio.getText().trim(); }
	public String getStock() { return txtStock.getText().trim(); }

	public void setCodigo(String valor) { txtCodigo.setText(valor); }
	public void setNombre(String valor) { txtNombre.setText(valor); }
	public void setPrecio(String valor) { txtPrecio.setText(valor); }
	public void setStock(String valor) { txtStock.setText(valor); }

	public DefaultTableModel getModeloTabla() { return modeloTabla; }
	public JTable getTablaProductos() { return tablaProductos; }

	// Getters requeridos por el controlador para validación de eventos
	public JButton getBtnAgregar() { return btnAgregar; }
	public JButton getBtnModificar() { return btnModificar; }
	public JButton getBtnEliminar() { return btnEliminar; }
	public JButton getBtnLimpiar() { return btnLimpiar; }
	
	public void limpiarFormulario() {
		txtCodigo.setText("");
		txtNombre.setText("");
		txtPrecio.setText("");
		txtStock.setText("");
	}
}