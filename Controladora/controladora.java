package Controladora;

import Vista.MenuPrincipal;
import javax.swing.*;
import java.awt.*;

public class controladora {

    private MenuPrincipal menu;

    public controladora(MenuPrincipal menu) {
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
    }
    

    private void salirPrograma() {
        int confirm = JOptionPane.showConfirmDialog(menu, "¿Está seguro de que desea salir?", "Confirmar Salida", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }
}
