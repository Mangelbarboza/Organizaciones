package Controladora;

import Modelo.*;
import Vista.*;

import java.awt.*;
import javax.swing.*;

public class Controlador {

    private MenuPrincipal menu;

    public Controlador(MenuPrincipal menu) {
        this.menu = menu;
        initController();
    }

    private void initController() {
        CardLayout layout = (CardLayout) menu.getContentPane().getLayout();

        menu.botonSalarioNeto.addActionListener(e -> layout.show(menu.getContentPane(), "salarioNeto"));
        menu.botonVacaciones.addActionListener(e -> layout.show(menu.getContentPane(), "vacaciones"));
        menu.botonAguinaldo.addActionListener(e -> layout.show(menu.getContentPane(), "aguinaldo"));
        menu.botonSalir.addActionListener(e -> salirPrograma());

        // Botones de regresar en cada panel
        menu.botonRegresarSalario.addActionListener(e -> layout.show(menu.getContentPane(), "menu"));
        menu.botonRegresarVacaciones.addActionListener(e -> layout.show(menu.getContentPane(), "menu"));
        menu.botonRegresarAguinaldo.addActionListener(e -> layout.show(menu.getContentPane(), "menu"));

        // Acción del botón de calcular vacaciones
        menu.botonCalcularVacaciones.addActionListener(e -> calcularVacaciones());

         // Boton para guardar empleado
         menu.getBotonTerminarContinuar().addActionListener(e -> guardarDatosEmpleado());
    }

    private void calcularVacaciones() {//Nai
        try {
            double salarioMensual = Double.parseDouble(menu.getSalarioMensualField().getText());
            int diasTrabajados = Integer.parseInt(menu.getDiasTrabajadosField().getText());
    
            // Crear el objeto Empleado con los datos del formulario
            Empleado empleado = new Empleado(null, null, null, 0, salarioMensual, 0, diasTrabajados, 0, diasTrabajados, diasTrabajados, false);
    
            // Realizar el cálculo de vacaciones usando Logic2
            int diasVacaciones = Logic2.calcularDiasVacaciones(empleado);
            double pagoVacaciones = Logic2.calcularPagoVaciones(empleado);
    
            // Mostrar los resultados en la interfaz
            menu.getResultadoDiasLabel().setText("Días de Vacaciones: " + diasVacaciones);
            menu.getResultadoPagoLabel().setText("Pago de Vacaciones: " + pagoVacaciones);
    
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(menu, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void guardarDatosEmpleado() {

        System.out.printf("Hola desde boton continuar");
        try {
            // Obtener los datos de los campos de entrada desde MenuPrincipal
            String nombre = menu.getNombreField().getText();
            String cedula = menu.getCedulaField().getText();
            String puesto = menu.getPuestoField().getText();
            double salarioBruto = Double.parseDouble(menu.getSalarioBrutoField().getText());
            int diasTrabajados = Integer.parseInt(menu.getDiasTrabajadosField().getText());

            // Crear instancia de Empleado con los datos ingresados
            Empleado empleado = new Empleado(nombre, cedula, puesto, 0, salarioBruto, salarioBruto, diasTrabajados, 0, 0, diasTrabajados, false);



            JOptionPane.showMessageDialog(menu, "Datos del empleado guardados correctamente.");

            /// Cambiar al panel de menú principal
        CardLayout layout = (CardLayout) menu.getContentPane().getLayout();
        layout.show(menu.getContentPane(), "menu");  // Cambia al menú principal

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(menu, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    

    private void salirPrograma() {
        int confirm = JOptionPane.showConfirmDialog(menu, "¿Está seguro de que desea salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
