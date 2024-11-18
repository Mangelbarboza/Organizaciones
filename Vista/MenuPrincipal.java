package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MenuPrincipal extends JFrame {
    private CardLayout cardLayout;
    public JButton botonSalarioNeto, botonVacaciones, botonAguinaldo, botonSalir;
    public JButton botonRegresarSalario, botonRegresarVacaciones, botonRegresarAguinaldo;
    public JPanel panelMenu, panelSalarioNeto, panelVacaciones, panelAguinaldo, panelFormulario;

    // Campos de texto del formulario simplificado
    private JTextField nombreField, cedulaField, puestoField;
    private JTextField salarioBrutoField, diasTrabajadosField;
    private JButton botonTerminarContinuar;

    private JTextField salarioMensualField;
    private JLabel resultadoDiasLabel, resultadoPagoLabel;
    public JButton botonCalcularVacaciones;

    public MenuPrincipal() {
        setTitle("Sistema de Cálculo Laboral");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        setLayout(cardLayout);

        initFormularioPanel(); 
        initMenuPanel();
        initSalarioPanel();
        initVacacionesPanel(); // Conservamos el diseño original
        initAguinaldoPanel();

        add(panelFormulario, "formulario");
        add(panelMenu, "menu");
        add(panelSalarioNeto, "salarioNeto");
        add(panelVacaciones, "vacaciones");
        add(panelAguinaldo, "aguinaldo");

        getContentPane().setBackground(new Color(240, 240, 240));  // Fondo pastel claro
    }

    private void initMenuPanel() {
        panelMenu = new JPanel(new GridBagLayout());
        panelMenu.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
        panelMenu.setBorder(createRoundedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        botonSalarioNeto = new RoundedButton("Calcular Salario Neto");
        botonVacaciones = new RoundedButton("Calcular Vacaciones");
        botonAguinaldo = new RoundedButton("Calcular Aguinaldo");
        botonSalir = new RoundedButton("Salir");

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
        panelSalarioNeto.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
        panelSalarioNeto.setBorder(createRoundedBorder());

        // Panel superior para ingreso de datos
        JPanel dataInputPanel = new JPanel();
        dataInputPanel.setLayout(new GridLayout(2, 2, 10, 10));
        dataInputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        dataInputPanel.setBackground(new Color(235, 245, 255));

        JLabel labelSalarioBruto = new JLabel("Salario Bruto:");
        JTextField fieldSalarioBruto = new RoundedTextField("");
        JLabel labelDiasTrabajados = new JLabel("Días Trabajados:");
        JTextField fieldDiasTrabajados = new RoundedTextField("");

        dataInputPanel.add(labelSalarioBruto);
        dataInputPanel.add(fieldSalarioBruto);
        dataInputPanel.add(labelDiasTrabajados);
        dataInputPanel.add(fieldDiasTrabajados);

        panelSalarioNeto.add(dataInputPanel, BorderLayout.NORTH);

        // Panel inferior para calculadora
        JPanel calculatorPanel = new JPanel(new GridLayout(4, 3, 10, 10));
        calculatorPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        calculatorPanel.setBackground(new Color(235, 245, 255));

        String[] buttons = {
            "7", "8", "9",
            "4", "5", "6",
            "1", "2", "3",
            "0", ".", "="
        };

        for (String text : buttons) {
            JButton button = new CircularButton(text);
            calculatorPanel.add(button);
        }

        panelSalarioNeto.add(calculatorPanel, BorderLayout.CENTER);

        botonRegresarSalario = new RoundedButton("Volver al Menú");
        panelSalarioNeto.add(botonRegresarSalario, BorderLayout.SOUTH);
    }

    private void initVacacionesPanel() {
        panelVacaciones = new JPanel();
        panelVacaciones.setLayout(new BoxLayout(panelVacaciones, BoxLayout.Y_AXIS));
        panelVacaciones.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
        panelVacaciones.setBorder(createRoundedBorder());

        JLabel label = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(70, 70, 70));
        panelVacaciones.add(label);

        salarioMensualField = new RoundedTextField("Salario mensual");
        panelVacaciones.add(new JLabel("Salario Mensual:"));
        panelVacaciones.add(salarioMensualField);

        botonCalcularVacaciones = new RoundedButton("Calcular Vacaciones"); // Conservamos este botón y su funcionalidad
        panelVacaciones.add(botonCalcularVacaciones);

        resultadoDiasLabel = new JLabel("Días de Vacaciones: ");
        resultadoPagoLabel = new JLabel("Pago de Vacaciones: ");
        panelVacaciones.add(resultadoDiasLabel);
        panelVacaciones.add(resultadoPagoLabel);

        botonRegresarVacaciones = new RoundedButton("Volver al Menú");
        panelVacaciones.add(botonRegresarVacaciones, BorderLayout.SOUTH);
    }

    private void initAguinaldoPanel() {
        panelAguinaldo = new JPanel(new BorderLayout());
        panelAguinaldo.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
        panelAguinaldo.setBorder(createRoundedBorder());

        JLabel label = new JLabel("Cálculo de Aguinaldo", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        label.setForeground(new Color(70, 70, 70));
        panelAguinaldo.add(label, BorderLayout.CENTER);

        botonRegresarAguinaldo = new RoundedButton("Volver al Menú");
        panelAguinaldo.add(botonRegresarAguinaldo, BorderLayout.SOUTH);
    }

    private void initFormularioPanel() {
        panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
        panelFormulario.setBorder(createRoundedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        nombreField = new RoundedTextField("Angel Hernandez Corea");
        cedulaField = new RoundedTextField("702970336");
        puestoField = new RoundedTextField("Desarrollador");
        salarioBrutoField = new RoundedTextField("1500000");
        diasTrabajadosField = new RoundedTextField("286");

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(new JLabel("Nombre Completo:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(nombreField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(new JLabel("Cédula:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(cedulaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(new JLabel("Puesto:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(puestoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panelFormulario.add(new JLabel("Salario Bruto:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(salarioBrutoField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        panelFormulario.add(new JLabel("Días Trabajados:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(diasTrabajadosField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        botonTerminarContinuar = new RoundedButton("Guardar y Continuar");
        panelFormulario.add(botonTerminarContinuar, gbc);
    }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }

    // Clase personalizada para JTextField con bordes redondeados
    private class RoundedTextField extends JTextField {
        public RoundedTextField(String placeholder) {
            super(placeholder);
            setFont(new Font("Segoe UI", Font.PLAIN, 14));
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15); // Bordes redondeados
            }
            super.paintComponent(g);
        }

        @Override
        public void setBackground(Color bg) {
            super.setBackground(bg);
        }
    }

    // Clase personalizada para JButton con bordes redondeados
    private class RoundedButton extends JButton {
        public RoundedButton(String text) {
            super(text);
            setFocusPainted(false);
            setFont(new Font("Segoe UI", Font.PLAIN, 16));
            setBackground(new Color(150, 200, 230)); // Color pastel
            setForeground(Color.DARK_GRAY);
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // Bordes redondeados
            }
            super.paintComponent(g);
        }
    }

    // Clase personalizada para JButton circular
    private class CircularButton extends JButton {
        public CircularButton(String text) {
            super(text);
            setFocusPainted(false);
            setFont(new Font("Segoe UI", Font.PLAIN, 16));
            setBackground(new Color(150, 200, 230)); // Color pastel
            setForeground(Color.DARK_GRAY);
            setOpaque(false);
            setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (g instanceof Graphics2D) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillOval(0, 0, getWidth(), getHeight()); // Botón circular
            }
            super.paintComponent(g);
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50); // Tamaño circular
        }
    }

    // Getters y Setters
    public JButton getBotonTerminarContinuar() { return botonTerminarContinuar; }
    public JTextField getSalarioMensualField() { return salarioMensualField; }
    public JTextField getDiasTrabajadosField() { return diasTrabajadosField; }
    public JLabel getResultadoDiasLabel() { return resultadoDiasLabel; }
    public JLabel getResultadoPagoLabel() { return resultadoPagoLabel; }
    public JTextField getNombreField() { return nombreField; }
    public JTextField getCedulaField() { return cedulaField; }
    public JTextField getPuestoField() { return puestoField; }
    public JTextField getSalarioBrutoField() { return salarioBrutoField; }
    public JButton getBotonCalcularVacaciones() { return botonCalcularVacaciones; }
    public JButton getBotonSalarioNeto() { return botonSalarioNeto; }
    public JButton getBotonVacaciones() { return botonVacaciones; }
    public JButton getBotonAguinaldo() { return botonAguinaldo; }
    public JButton getBotonSalir() { return botonSalir; }
    public JButton getBotonRegresarSalario() { return botonRegresarSalario; }
    public JButton getBotonRegresarVacaciones() { return botonRegresarVacaciones; }
    public JButton getBotonRegresarAguinaldo() { return botonRegresarAguinaldo; }
}
