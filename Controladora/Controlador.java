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

        // Acciones de los botones del panel de menú
        menu.menuPanel.getBotonSalarioNeto().addActionListener(e -> layout.show(menu.getContentPane(), "salarioNeto"));
        menu.menuPanel.getBotonVacaciones().addActionListener(e -> layout.show(menu.getContentPane(), "vacaciones"));
        menu.menuPanel.getBotonAguinaldo().addActionListener(e -> layout.show(menu.getContentPane(), "aguinaldo"));
        menu.menuPanel.getBotonSalir().addActionListener(e -> salirPrograma());

        // Botones de regresar en cada panel
        menu.salarioNetoPanel.getBotonRegresarSalario().addActionListener(e -> layout.show(menu.getContentPane(), "menu"));
        menu.vacacionesPanel.getBotonRegresarVacaciones().addActionListener(e -> layout.show(menu.getContentPane(), "menu"));
        menu.aguinaldoPanel.getBotonRegresarAguinaldo().addActionListener(e -> layout.show(menu.getContentPane(), "menu"));

        // Acción del botón de calcular vacaciones
        menu.vacacionesPanel.getBotonCalcularVacaciones().addActionListener(e -> calcularVacaciones());

        // Acción del botón de calcular aguinaldo
        menu.aguinaldoPanel.getBotonCalcularAguinaldo().addActionListener(e -> calcularAguinaldo());
    }

   private void calcularVacaciones() {
    try {
        // Verificar que el campo de salario no esté vacío
        String salarioMensualTexto = menu.vacacionesPanel.getSalarioMensualField().getText();
        if (salarioMensualTexto.isEmpty()) {
            throw new NumberFormatException("El campo de Salario Mensual está vacío.");
        }

        // Convertir el salario mensual a double
        double salarioMensual = Double.parseDouble(salarioMensualTexto);

        // Asegurarse de que el campo de días trabajados está disponible y no vacío
        String diasTrabajadosTexto = menu.vacacionesPanel.getDiasTrabajadosField().getText();
        if (diasTrabajadosTexto.isEmpty()) {
            throw new NumberFormatException("El campo de Días Trabajados está vacío.");
        }

        // Convertir los días trabajados a int
        int diasTrabajados = Integer.parseInt(diasTrabajadosTexto);

        // Crear el objeto Empleado con los datos del formulario
        Empleado empleado = new Empleado(null, null, null, diasTrabajados, salarioMensual, salarioMensual, diasTrabajados, diasTrabajados, diasTrabajados, false);

        // Realizar el cálculo de vacaciones usando Logic2
        int diasVacaciones = Logic2.calcularDiasVacaciones(empleado);
        double pagoVacaciones = Logic2.calcularPagoVaciones(empleado);

        // Mostrar los resultados en la interfaz
        menu.vacacionesPanel.getResultadoDiasLabel().setText("Días de Vacaciones: " + diasVacaciones);
        menu.vacacionesPanel.getResultadoPagoLabel().setText("Pago de Vacaciones: " + pagoVacaciones);

    } catch (NumberFormatException ex) {
        JOptionPane.showMessageDialog(menu, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
    }
}


    private void calcularAguinaldo() {
        try {
            double salarioMensual = Double.parseDouble(menu.aguinaldoPanel.getSalarioMensualField().getText());
            int horasExtrasMensuales = Integer.parseInt(menu.aguinaldoPanel.getHorasExtrasField().getText());
            int diasTrabajados = Integer.parseInt(menu.aguinaldoPanel.getDiasTrabajadosField().getText());

            double aguinaldoCalculado = Logic3.calcularAguinaldo(salarioMensual, horasExtrasMensuales, diasTrabajados);

            menu.aguinaldoPanel.getResultadoAguinaldoLabel().setText("Aguinaldo Calculado: ₡" + aguinaldoCalculado);

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
