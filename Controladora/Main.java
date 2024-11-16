package Controladora;

import Vista.MenuPrincipal;
import Controladora.controladora;

@SuppressWarnings("unused") // Esto es para quitar las advertencias de que no se usa una clase

public class Main {

    // Beli feas

    public static void main(String[] args) {

        // Iniciar interfaz
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);

        // Crear controladora

        controladora controller = new controladora(menu);

    }

}