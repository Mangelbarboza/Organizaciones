package Controladora;

import Vista.MenuPrincipal;

@SuppressWarnings("unused")   // Esto es para quitar las advertencias de que no se usa una clase

public class Main {  

   

    public static void main(String[] args) {
    
        // Iniciar interfaz
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        
        // Crear controladora
      Controlador controller = new Controlador(menu);
       
    }

}