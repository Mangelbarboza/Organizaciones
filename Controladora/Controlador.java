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
    private Empleado empleado; // Asegúrate de tener una referencia al empleado

    public Controlador(MenuPrincipal menu) {
        this.menu = menu;
        this.logic1 = new logic1(menu.salarioNetoPanel);
        this.logic2 = new Logic2(menu);
        this.logic3 = new Logic3(menu.aguinaldoPanel.getSalarioMensualFields(),menu.aguinaldoPanel.getResultadoAguinaldoLabel());
        initController();
    }

    private void initController() {
        CardLayout layout = (CardLayout) menu.getContentPane().getLayout();

        // Acciones de los botones del panel de menú
        menu.menuPanel.getBotonSalarioNeto().addActionListener(e -> layout.show(menu.getContentPane(), "salarioNeto"));
        menu.menuPanel.getBotonVacaciones().addActionListener(e -> layout.show(menu.getContentPane(), "vacaciones"));
        menu.menuPanel.getBotonAguinaldo().addActionListener(e -> layout.show(menu.getContentPane(), "aguinaldo"));
        menu.menuPanel.getBotonSalir().addActionListener(e -> salirPrograma());

        // Botón de cálculo en SalarioNetoPanel
        menu.salarioNetoPanel.getBotonCalcular().addActionListener(e -> logic1.calcularSalarioNeto());

        // Botones de regresar en cada panel
        menu.salarioNetoPanel.getBotonVolver().addActionListener(e -> layout.show(menu.getContentPane(), "menu"));
        menu.vacacionesPanel.getBotonRegresarVacaciones().addActionListener(e -> layout.show(menu.getContentPane(), "menu"));
        menu.aguinaldoPanel.getBotonRegresarAguinaldo().addActionListener(e -> layout.show(menu.getContentPane(), "menu"));

        // Acción del botón de calcular vacaciones
        menu.vacacionesPanel.getBotonCalcularVacaciones().addActionListener(e -> calcularVacaciones());

        // Acción del botón de calcular aguinaldo
        menu.aguinaldoPanel.getBotonCalcularAguinaldo().addActionListener(e -> calcularAguinaldo());

        menu.formulario.getBotonGuardarContinuar().addActionListener(e-> validarEmpleado(layout));
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

            // Actualizar los datos del empleado existente
            empleado.setSalarioMensual(salarioMensual);
            empleado.setDiasTrabajados(diasTrabajados);

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

       logic3.actualizarAguinaldo();

    }
    

    private void salirPrograma() {
        int confirm = JOptionPane.showConfirmDialog(menu, "¿Está seguro de que desea salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }

    private void validarEmpleado(CardLayout layout) {
        // Obtener los datos para crear el empleado
        String nombre = menu.formulario.getNombreField().getText();
        String cedula = menu.formulario.getCedulaField().getText();
        String puesto = menu.formulario.getPuestoField().getText();
        double salarioBruto = Double.parseDouble(menu.formulario.getSalarioBrutoField().getText());
        

        // Crear el objeto Empleado
        empleado = new Empleado(nombre, cedula, puesto, salarioBruto, 0, salarioBruto, 0, 0, 0, false);

        System.out.println("Empleado creado: " + empleado.toString());

        // ocultar el formulario y mostrar el menú
        menu.formulario.setVisible(false);

        // Mostrar el menú
        layout.show(menu.getContentPane(), "menu");
    }
}