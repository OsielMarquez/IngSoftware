package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaGestionProductos;

public class ControladorGestionProductos implements ActionListener {

    private VentanaGestionProductos vista;

    public ControladorGestionProductos(VentanaGestionProductos vista) {
        this.vista = vista;
        this.vista.conectarControlador(this);
    }

    public void iniciar() {
        this.vista.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vista.getBtnAgregar()) {
            ejecutarAgregar();
        } else if (e.getSource() == vista.getBtnLimpiar()) {
            vista.limpiarFormulario();
        } else if (e.getSource() == vista.getBtnEliminar()) {
            ejecutarEliminar();
        } else if (e.getSource() == vista.getBtnModificar()) {
            ejecutarModificar();
        }
    }

    private void ejecutarAgregar() {
        String codigo = vista.getCodigo();
        String nombre = vista.getNombre();
        String precio = vista.getPrecio();
        String stock = vista.getStock();

        // Validación de campos vacíos
        if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
            return;
        }

        Object[] nuevaFila = {codigo, nombre, precio, stock};
        vista.getModeloTabla().addRow(nuevaFila);
        vista.limpiarFormulario();
    }

    private void ejecutarEliminar() {
        int filaSeleccionada = vista.getTablaProductos().getSelectedRow();
        if (filaSeleccionada >= 0) {
            vista.getModeloTabla().removeRow(filaSeleccionada);
        }
    }

    private void ejecutarModificar() {
        int filaSeleccionada = vista.getTablaProductos().getSelectedRow();
        if (filaSeleccionada >= 0) {
            String codigo = vista.getCodigo();
            String nombre = vista.getNombre();
            String precio = vista.getPrecio();
            String stock = vista.getStock();

            if (codigo.isEmpty() || nombre.isEmpty() || precio.isEmpty() || stock.isEmpty()) {
                return;
            }

            vista.getModeloTabla().setValueAt(codigo, filaSeleccionada, 0);
            vista.getModeloTabla().setValueAt(nombre, filaSeleccionada, 1);
            vista.getModeloTabla().setValueAt(precio, filaSeleccionada, 2);
            vista.getModeloTabla().setValueAt(stock, filaSeleccionada, 3);

            vista.limpiarFormulario();
        }
    }
}
