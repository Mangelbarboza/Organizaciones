package Controladora;

import Vista.MenuPrincipal;
import Controladora.controladora;

public class Main {

    public static void main(String[] args) {
    
        // Iniciar interfaz
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        
        // Crear controladora
        controladora controller = new controladora(menu);
       
    }

}