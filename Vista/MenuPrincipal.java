package Vista;

import javax.swing.*;
import javax.swing.border.Border;

import java.awt.*;

public class MenuPrincipal extends JFrame {
    public JButton botonSalarioNeto, botonVacaciones, botonAguinaldo, botonSalir;
    public JButton botonRegresarSalario, botonRegresarVacaciones, botonRegresarAguinaldo;
    public JPanel panelMenu, panelSalarioNeto, panelVacaciones, panelAguinaldo;

    // oBJETOS DEL PANEL X





    

    public MenuPrincipal() {
        setTitle("Sistema de Cálculo Laboral");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new CardLayout());

        // Inicializar paneles y estilo general
        initMenuPanel();
        initSalarioPanel();
        initVacacionesPanel();
        initAguinaldoPanel();

        add(panelMenu, "menu");
        add(panelSalarioNeto, "salarioNeto");
        add(panelVacaciones, "vacaciones");
        add(panelAguinaldo, "aguinaldo");

        // Fondo del frame principal
        getContentPane().setBackground(new Color(240, 240, 240));
    }

    private void initMenuPanel() {
        panelMenu = new JPanel(new GridBagLayout());
        panelMenu.setBackground(new Color(255, 255, 255));
        panelMenu.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panelMenu.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)
        ));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Espaciado entre botones

        botonSalarioNeto = crearBoton("Calcular Salario Neto");
        botonVacaciones = crearBoton("Calcular Vacaciones");
        botonAguinaldo = crearBoton("Calcular Aguinaldo");
        botonSalir = crearBoton("Salir");

        gbc.gridy = 0;
        panelMenu.add(botonSalarioNeto, gbc);
        gbc.gridy++;
        panelMenu.add(botonVacaciones, gbc);
        gbc.gridy++;
        panelMenu.add(botonAguinaldo, gbc);
        gbc.gridy++;
        panelMenu.add(botonSalir, gbc);
    }

    private void initSalarioPanel() {
        panelSalarioNeto = new JPanel(new BorderLayout());
        panelSalarioNeto.setBackground(new Color(255, 255, 255));
        panelSalarioNeto.setBorder(createRoundedBorder());

        JLabel label = new JLabel("Cálculo de Salario Neto", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(new Color(50, 50, 50));
        panelSalarioNeto.add(label, BorderLayout.CENTER);

        botonRegresarSalario = crearBoton("Volver al Menú");
        panelSalarioNeto.add(botonRegresarSalario, BorderLayout.SOUTH);
    }

    private void initVacacionesPanel() {
        panelVacaciones = new JPanel(new BorderLayout());
        panelVacaciones.setBackground(new Color(255, 255, 255));
        panelVacaciones.setBorder(createRoundedBorder());

        JLabel label = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(new Color(50, 50, 50));
        panelVacaciones.add(label, BorderLayout.CENTER);

        botonRegresarVacaciones = crearBoton("Volver al Menú");
        panelVacaciones.add(botonRegresarVacaciones, BorderLayout.SOUTH);
    }

    private void initAguinaldoPanel() {
        panelAguinaldo = new JPanel(new BorderLayout());
        panelAguinaldo.setBackground(new Color(255, 255, 255));
        panelAguinaldo.setBorder(createRoundedBorder());

        JLabel label = new JLabel("Cálculo de Aguinaldo", SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 18));
        label.setForeground(new Color(50, 50, 50));
        panelAguinaldo.add(label, BorderLayout.CENTER);

        botonRegresarAguinaldo = crearBoton("Volver al Menú");
        panelAguinaldo.add(botonRegresarAguinaldo, BorderLayout.SOUTH);
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(75, 85, 99)); // Modern gray-blue
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        boton.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        
        // Borde redondeado
        boton.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        
        return boton;
    }

    // Método para crear un borde redondeado para los paneles
    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
