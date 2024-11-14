package Controladora;

import Vista.MenuPrincipal;
import javax.swing.*;

public class controladora {   // Controladora

    private MenuPrincipal menu;

    public controladora(MenuPrincipal menu) {
        this.menu = menu;
        initController();
    }

    private void initController() {
        menu.botonSalarioNeto.addActionListener(e -> mostrarMensaje("Cálculo de Salario Neto seleccionado"));
        menu.botonVacaciones.addActionListener(e -> mostrarMensaje("Cálculo de Vacaciones seleccionado"));
        menu.botonAguinaldo.addActionListener(e -> mostrarMensaje("Cálculo de Aguinaldo seleccionado"));
        menu.botonLiquidacion.addActionListener(e -> mostrarMensaje("Cálculo de Liquidación por Despido seleccionado"));
        menu.botonSalir.addActionListener(e -> salirPrograma());
    }

    private void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(menu, mensaje);
    }

    private void salirPrograma() {
        int confirm = JOptionPane.showConfirmDialog(menu, "¿Está seguro de que desea salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
