package Vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {

    public MenuPrincipal() {
        setTitle("Menú Principal");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Fondo color beige claro
        getContentPane().setBackground(new Color(245, 222, 179));

        // Panel para los botones con margen interno
        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotones.setBackground(new Color(245, 222, 179));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40)); // Márgenes alrededor del panel

        // Crear botones con estilo y margen
        JButton boton1 = crearBoton("Opción 1");
        JButton boton2 = crearBoton("Opción 2");
        JButton boton3 = crearBoton("Opción 3");
        JButton boton4 = crearBoton("Opción 4");
        JButton boton5 = crearBoton("Opción 5");

        // Añadir ActionListeners para cada botón
        boton1.addActionListener(e -> abrirVentana(new VentanaOpcion("Opción 1")));
        boton2.addActionListener(e -> abrirVentana(new VentanaOpcion("Opción 2")));
        boton3.addActionListener(e -> abrirVentana(new VentanaOpcion("Opción 3")));
        boton4.addActionListener(e -> abrirVentana(new VentanaOpcion("Opción 4")));
        boton5.addActionListener(e -> abrirVentana(new VentanaOpcion("Opción 5")));

        // Agregar botones al panel
        panelBotones.add(boton1);
        panelBotones.add(boton2);
        panelBotones.add(boton3);
        panelBotones.add(boton4);
        panelBotones.add(boton5);

        // Añadir el panel de botones al JFrame principal
        add(panelBotones, BorderLayout.CENTER);
    }

    // Método para crear un botón con estilo minimalista y colores café oscuro
    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false); // Quitar borde al hacer clic
        boton.setBackground(new Color(139, 69, 19)); // Color café oscuro
        boton.setForeground(Color.WHITE); // Texto blanco
        boton.setFont(new Font("SansSerif", Font.PLAIN, 16)); // Fuente moderna
        boton.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10)); // Margen interno
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR)); // Cambiar cursor al pasar sobre el botón
        boton.setOpaque(true);
        return boton;
    }

    // Método para abrir una ventana específica y ocultar el menú principal
    private void abrirVentana(JFrame ventana) {
        ventana.setVisible(true);
        this.setVisible(false);
    }
}

// Clase VentanaOpcion para crear una ventana secundaria que permite regresar al
// menú
class VentanaOpcion extends JFrame {

    public VentanaOpcion(String titulo) {
        setTitle(titulo);
        setSize(300, 200);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(245, 222, 179)); // Fondo beige claro

        JLabel label = new JLabel("Estás en " + titulo, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.PLAIN, 18)); // Fuente moderna
        label.setForeground(new Color(80, 80, 80)); // Texto en gris oscuro
        add(label, BorderLayout.CENTER);

        JButton botonRegresar = new JButton("Regresar al Menú");
        botonRegresar.setFocusPainted(false);
        botonRegresar.setBackground(new Color(139, 69, 19)); // Color café oscuro
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFont(new Font("SansSerif", Font.PLAIN, 14));
        botonRegresar.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        botonRegresar.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Listener para regresar al menú principal
        botonRegresar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                regresarAlMenu();
            }
        });

        add(botonRegresar, BorderLayout.SOUTH);
    }

    // Método para regresar al menú principal
    private void regresarAlMenu() {
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        dispose(); // Cierra la ventana actual
    }
}
