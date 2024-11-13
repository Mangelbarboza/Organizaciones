package Vista;

import javax.swing.*;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    public JButton botonSalarioNeto, botonVacaciones, botonAguinaldo, botonLiquidacion, botonSalir;
    public JTextField campoNombre, campoPuesto, campoSalario, campoAnios;

    public MenuPrincipal() {
        setTitle("Sistema de Cálculo Laboral");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        getContentPane().setBackground(new Color(245, 222, 179));

        JPanel panelBotones = new JPanel(new GridLayout(5, 1, 10, 10));
        panelBotones.setBackground(new Color(245, 222, 179));
        panelBotones.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

        // Crear botones para las opciones
        botonSalarioNeto = crearBoton("Calcular Salario Neto");
        botonVacaciones = crearBoton("Calcular Vacaciones");
        botonAguinaldo = crearBoton("Calcular Aguinaldo");
        botonLiquidacion = crearBoton("Calcular Liquidación por Despido");
        botonSalir = crearBoton("Salir");

        panelBotones.add(botonSalarioNeto);
        panelBotones.add(botonVacaciones);
        panelBotones.add(botonAguinaldo);
        panelBotones.add(botonLiquidacion);
        panelBotones.add(botonSalir);

        add(panelBotones, BorderLayout.CENTER);

        // Panel para los datos básicos del trabajador
        JPanel panelDatos = new JPanel(new GridLayout(4, 2, 10, 10));
        panelDatos.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panelDatos.setBackground(new Color(245, 222, 179));

        // Campos para ingresar datos del trabajador
        panelDatos.add(new JLabel("Nombre del Trabajador:"));
        campoNombre = new JTextField();
        panelDatos.add(campoNombre);

        panelDatos.add(new JLabel("Puesto:"));
        campoPuesto = new JTextField();
        panelDatos.add(campoPuesto);

        panelDatos.add(new JLabel("Salario Bruto:"));
        campoSalario = new JTextField();
        panelDatos.add(campoSalario);

        panelDatos.add(new JLabel("Años Trabajados:"));
        campoAnios = new JTextField();
        panelDatos.add(campoAnios);

        add(panelDatos, BorderLayout.NORTH);
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
