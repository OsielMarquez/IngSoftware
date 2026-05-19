package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import vista.VentanaPrincipal;
import vista.VentanaGestionProductos;
import vista.VentanaInventario;

public class ControladorPrincipal implements ActionListener {

    private VentanaPrincipal vistaPrincipal;
    private VentanaGestionProductos vistaProductos;
    private VentanaInventario vistaInventario;

    public ControladorPrincipal(VentanaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.conectarControlador(this);
    }

    public void iniciar() {
        vistaPrincipal.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaPrincipal.getBtnGestionProductos()) {
            if (vistaProductos == null) {
                vistaProductos = new VentanaGestionProductos();
                new ControladorGestionProductos(vistaProductos);
            }
            vistaProductos.setVisible(true);
            
        } else if (e.getSource() == vistaPrincipal.getBtnInventario()) {
            if (vistaInventario == null) {
                vistaInventario = new VentanaInventario();
            }
            vistaInventario.setVisible(true);
        }
    }
}