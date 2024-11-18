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

    }
    private void calcularVacaciones() {//Nai
        try {
            double salarioMensual = Double.parseDouble(menu.getSalarioMensualField().getText());
            int diasTrabajados = Integer.parseInt(menu.getDiasTrabajadosField().getText());
    
            // Crear el objeto Empleado con los datos del formulario
            Empleado empleado = new Empleado(null, null, null, null, 0, salarioMensual, 0, diasTrabajados, 0, diasTrabajados, false);
    
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
    

    private void salirPrograma() {
        int confirm = JOptionPane.showConfirmDialog(menu, "¿Está seguro de que desea salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
