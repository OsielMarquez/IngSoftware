package vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
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

public class VentanaInventario extends JFrame {

	private JTextField txtBusqueda;
	private JButton btnBuscar;
	private JButton btnActualizar;
	private JButton btnCerrar;
	
	private JTable tablaInventario;
	private DefaultTableModel modeloTabla;

	public VentanaInventario() {
		setSize(800, 650);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setTitle("Inventario");
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
		JLabel labelTitulo = new JLabel("Control de Inventario");
		labelTitulo.setForeground(Color.WHITE);

		JPanel panelNorte = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 25));
		panelNorte.setBackground(new Color(0, 68, 69));
		panelNorte.setPreferredSize(new Dimension(100, 80));
		panelNorte.add(labelTitulo);

		add(panelNorte, BorderLayout.NORTH);
	}

	private void configurarPanelCentro() {
		JPanel panelCentro = new JPanel(new BorderLayout(0, 15));
		panelCentro.setBackground(new Color(134, 172, 65));
		panelCentro.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));

		// Subpanel de búsqueda superior
		JPanel panelBusqueda = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
		panelBusqueda.setOpaque(false);
		
		panelBusqueda.add(new JLabel("Buscar producto:"));
		txtBusqueda = new JTextField(20);
		panelBusqueda.add(txtBusqueda);
		
		btnBuscar = new JButton("Buscar");
		panelBusqueda.add(btnBuscar);

		panelCentro.add(panelBusqueda, BorderLayout.NORTH);

		// Componente JTable para visualización de registros estructurados
		String[] columnas = {"ID", "Producto", "Categoría", "Stock Actual", "Stock Mínimo", "Estado"};
		modeloTabla = new DefaultTableModel(columnas, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};
		tablaInventario = new JTable(modeloTabla);
		JScrollPane scrollTabla = new JScrollPane(tablaInventario);
		
		panelCentro.add(scrollTabla, BorderLayout.CENTER);
		add(panelCentro, BorderLayout.CENTER);
	}

	private void configurarPanelSur() {
		JPanel panelSur = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 25));
		panelSur.setBackground(new Color(111, 185, 143));
		panelSur.setPreferredSize(new Dimension(100, 80));

		btnActualizar = new JButton("Actualizar Datos");
		btnCerrar = new JButton("Cerrar");

		panelSur.add(btnActualizar);
		panelSur.add(btnCerrar);

		add(panelSur, BorderLayout.SOUTH);
	}

	public void conectarControlador(ActionListener controlador) {
		btnBuscar.addActionListener(controlador);
		btnActualizar.addActionListener(controlador);
		btnCerrar.addActionListener(controlador);
	}

	public String getTextoBusqueda() { return txtBusqueda.getText().trim(); }
	public void setTextoBusqueda(String valor) { txtBusqueda.setText(valor); }

	public DefaultTableModel getModeloTabla() { return modeloTabla; }
	public JTable getTablaInventario() { return tablaInventario; }

	public JButton getBtnBuscar() { return btnBuscar; }
	public JButton getBtnActualizar() { return btnActualizar; }
	public JButton getBtnCerrar() { return btnCerrar; }
}