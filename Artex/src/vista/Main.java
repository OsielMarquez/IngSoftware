package vista;

import controlador.ControladorPrincipal;

public class Main {
    
    public static void main(String[] args) {
        // Instancia de la interfaz principal
        VentanaPrincipal ventana = new VentanaPrincipal();
        
        // Vinculación con el controlador general de la aplicación
        ControladorPrincipal controlador = new ControladorPrincipal(ventana);
        
        // Despliegue del entorno gráfico
        controlador.iniciar();
    }
}