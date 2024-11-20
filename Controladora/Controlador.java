package Controladora;

import Modelo.*;
import Vista.*;
import java.awt.*;
import javax.swing.*;

public class Controlador {

    private MenuPrincipal menu;
    private logic1 logic1;
    private Logic2 logic2;
    private Logic3 logic3;

    public Controlador(MenuPrincipal menu) {
        this.menu = menu;
        this.logic1 = new logic1(menu);
        this.logic2 = new Logic2(menu);
        this.logic3 = new Logic3();
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
            // Obtener datos del empleado desde el panel de vacaciones
            String salarioMensualTexto = menu.vacacionesPanel.getSalarioMensualField().getText();
            String diasTrabajadosTexto = menu.vacacionesPanel.getDiasTrabajadosField().getText();

            if (salarioMensualTexto.isEmpty() || diasTrabajadosTexto.isEmpty()) {
                throw new NumberFormatException("Los campos están vacíos.");
            }

            double salarioMensual = Double.parseDouble(salarioMensualTexto);
            int diasTrabajados = Integer.parseInt(diasTrabajadosTexto);

            // Crear un objeto Empleado para el cálculo
            Empleado empleado = new Empleado(null, null, null, 0, salarioMensual, salarioMensual, 0, diasTrabajados, 0, false);

            // Usar Logic2 para calcular días y pago de vacaciones
            int diasVacaciones = logic2.calcularDiasVacaciones(empleado);
            double pagoVacaciones = logic2.calcularPagoVacaciones(empleado);

            // Mostrar los resultados en la interfaz
            menu.vacacionesPanel.getResultadoDiasLabel().setText("Días de Vacaciones: " + diasVacaciones);
            menu.vacacionesPanel.getResultadoPagoLabel().setText("Pago de Vacaciones: " + pagoVacaciones);

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(menu, "Por favor, ingrese valores numéricos válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calcularAguinaldo() {
        try {
            // Obtener datos del panel de aguinaldo
            double salarioMensual = Double.parseDouble(menu.aguinaldoPanel.getSalarioMensualField().getText());
            int horasExtrasMensuales = Integer.parseInt(menu.aguinaldoPanel.getHorasExtrasField().getText());
            int diasTrabajados = Integer.parseInt(menu.aguinaldoPanel.getDiasTrabajadosField().getText());

            // Calcular aguinaldo usando Logic3
            double aguinaldoCalculado = logic3.calcularAguinaldo(salarioMensual, horasExtrasMensuales, diasTrabajados);

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
