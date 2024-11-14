package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {   
    public JButton botonSalarioNeto, botonVacaciones, botonAguinaldo, botonSalir;
    public JButton botonRegresarSalario, botonRegresarVacaciones, botonRegresarAguinaldo;
    public JPanel panelMenu, panelSalarioNeto, panelVacaciones, panelAguinaldo;

    public MenuPrincipal() {
        setTitle("Sistema de Cálculo Laboral");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());  // Usaremos CardLayout para cambiar de paneles fácilmente

        initMenuPanel();
        initSalarioPanel();
        initVacacionesPanel();
        initAguinaldoPanel();

        add(panelMenu, "menu");        // Agrega el panel de menú principal
        add(panelSalarioNeto, "salarioNeto");
        add(panelVacaciones, "vacaciones");
        add(panelAguinaldo, "aguinaldo");
    }

    private void initMenuPanel() {
        panelMenu = new JPanel(new GridLayout(5, 1, 10, 10));
        panelMenu.setBackground(new Color(245, 222, 179));

        // Crear botones para las opciones
        botonSalarioNeto = crearBoton("Calcular Salario Neto");
        botonVacaciones = crearBoton("Calcular Vacaciones");
        botonAguinaldo = crearBoton("Calcular Aguinaldo");
        botonSalir = crearBoton("Salir");

        panelMenu.add(botonSalarioNeto);
        panelMenu.add(botonVacaciones);
        panelMenu.add(botonAguinaldo);
        panelMenu.add(botonSalir);
    }

    private void initSalarioPanel() {
        panelSalarioNeto = new JPanel(new BorderLayout());
        panelSalarioNeto.setBackground(new Color(220, 245, 255));

        JLabel label = new JLabel("Cálculo de Salario Neto", SwingConstants.CENTER);
        panelSalarioNeto.add(label, BorderLayout.CENTER);

        botonRegresarSalario = crearBoton("Volver al Menú");
        panelSalarioNeto.add(botonRegresarSalario, BorderLayout.SOUTH);
    }

    private void initVacacionesPanel() {
        panelVacaciones = new JPanel(new BorderLayout());
        panelVacaciones.setBackground(new Color(240, 255, 220));

        JLabel label = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
        panelVacaciones.add(label, BorderLayout.CENTER);

        botonRegresarVacaciones = crearBoton("Volver al Menú");
        panelVacaciones.add(botonRegresarVacaciones, BorderLayout.SOUTH);
    }

    private void initAguinaldoPanel() {
        panelAguinaldo = new JPanel(new BorderLayout());
        panelAguinaldo.setBackground(new Color(255, 235, 220));

        JLabel label = new JLabel("Cálculo de Aguinaldo", SwingConstants.CENTER);
        panelAguinaldo.add(label, BorderLayout.CENTER);

        botonRegresarAguinaldo = crearBoton("Volver al Menú");
        panelAguinaldo.add(botonRegresarAguinaldo, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(139, 69, 19));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        boton.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        return boton;
    }
}
