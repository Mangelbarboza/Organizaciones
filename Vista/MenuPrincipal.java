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
    private JTextField horasField;

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
        JLabel labelHoras = new JLabel("Horas Extras: ");
        JTextField fieldHoras = new RoundedTextField("");



        dataInputPanel.add(labelSalarioBruto);
        dataInputPanel.add(fieldSalarioBruto);
        dataInputPanel.add(labelDiasTrabajados);
        dataInputPanel.add(fieldDiasTrabajados);
        dataInputPanel.add(labelHoras);
        dataInputPanel.add(fieldHoras);

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
    panelVacaciones = new JPanel(new GridBagLayout());
    panelVacaciones.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
    panelVacaciones.setBorder(createRoundedBorder());

    // Título de la sección
    JLabel label = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
    label.setFont(new Font("Segoe UI", Font.BOLD, 18));
    label.setForeground(new Color(70, 70, 70));

    // Configuración de GridBagConstraints para organizar los componentes
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(5, 5, 5, 5);  // Espaciado reducido

    // Añadir el título
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.gridwidth = 2;
    panelVacaciones.add(label, gbc);

    // Etiqueta "Salario Mensual"
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.gridwidth = 1;
    panelVacaciones.add(new JLabel("Salario Mensual:"), gbc);

    // Campo de texto "Salario Mensual" con ancho reducido
    salarioMensualField = new RoundedTextField("Salario mensual");
    salarioMensualField.setPreferredSize(new Dimension(150, 25)); // Reducir ancho del campo de texto
    gbc.gridx = 1;
    gbc.gridy = 1;
    panelVacaciones.add(salarioMensualField, gbc);

    // Botón "Calcular Vacaciones"
    botonCalcularVacaciones = new RoundedButton("Calcular Vacaciones");
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.gridwidth = 2;
    panelVacaciones.add(botonCalcularVacaciones, gbc);

    // Etiqueta de resultado para días de vacaciones
    resultadoDiasLabel = new JLabel("Días de Vacaciones: ");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    panelVacaciones.add(resultadoDiasLabel, gbc);

    // Etiqueta de resultado para pago de vacaciones
    resultadoPagoLabel = new JLabel("Pago de Vacaciones: ");
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 2;
    panelVacaciones.add(resultadoPagoLabel, gbc);

    // Botón para regresar al menú
    botonRegresarVacaciones = new RoundedButton("Volver al Menú");
    gbc.gridx = 0;
    gbc.gridy = 5;
    gbc.gridwidth = 2;
    panelVacaciones.add(botonRegresarVacaciones, gbc);
}

////////////////////////////////////////////////////////////////////////////////////////////
private void initAguinaldoPanel() {
    panelAguinaldo = new JPanel(new BorderLayout());
    panelAguinaldo.setBackground(new Color(235, 245, 255)); // Fondo pastel claro
    panelAguinaldo.setBorder(createRoundedBorder());

    // Panel superior para el título, con mayor espaciado para bajarlo un poco
    JPanel titlePanel = new JPanel();
    titlePanel.setBackground(new Color(235, 245, 255));
    titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 0, 20, 0)); // Espacio alrededor del título para bajarlo más

    JLabel label = new JLabel("Cálculo de Aguinaldo", SwingConstants.CENTER);
    label.setFont(new Font("Segoe UI", Font.BOLD, 24)); // Tamaño de fuente grande
    label.setForeground(new Color(70, 70, 70));
    titlePanel.add(label);

    panelAguinaldo.add(titlePanel, BorderLayout.NORTH);

    // Panel central para los campos de entrada de datos
    JPanel dataInputPanel = new JPanel(new GridBagLayout());
    dataInputPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    dataInputPanel.setBackground(new Color(235, 245, 255));
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(10, 5, 15, 5);  // Mayor separación entre las filas

    // Configuración de fuente para etiquetas y campos
    Font labelFont = new Font("Segoe UI", Font.BOLD, 16);  // Etiquetas en negrita
    Font textFieldFont = new Font("Segoe UI", Font.PLAIN, 16);

    // Campo y etiqueta de Salario Mensual
    JLabel labelSalarioMensual = new JLabel("Salario Mensual:");
    labelSalarioMensual.setFont(labelFont);
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.EAST;
    dataInputPanel.add(labelSalarioMensual, gbc);

    JTextField fieldSalarioMensual = new RoundedTextField("");
    fieldSalarioMensual.setPreferredSize(new Dimension(150, 30)); // Tamaño un poco más grande
    fieldSalarioMensual.setFont(textFieldFont);
    gbc.gridx = 1;
    gbc.anchor = GridBagConstraints.WEST;
    dataInputPanel.add(fieldSalarioMensual, gbc);

    // Campo y etiqueta de Horas Extras Mensuales
    JLabel labelHorasExtrasMensuales = new JLabel("Horas Extras Mensuales:");
    labelHorasExtrasMensuales.setFont(labelFont);
    gbc.gridx = 0;
    gbc.gridy = 1;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.insets = new Insets(15, 5, 15, 5);  // Aumenta espacio entre las filas
    dataInputPanel.add(labelHorasExtrasMensuales, gbc);

    JTextField fieldHorasExtrasMensuales = new RoundedTextField("");
    fieldHorasExtrasMensuales.setPreferredSize(new Dimension(150, 30)); // Tamaño un poco más grande
    fieldHorasExtrasMensuales.setFont(textFieldFont);
    gbc.gridx = 1;
    gbc.anchor = GridBagConstraints.WEST;
    dataInputPanel.add(fieldHorasExtrasMensuales, gbc);

    // Campo y etiqueta de Días Trabajados
    JLabel labelDiasTrabajados = new JLabel("Días Trabajados en el Año:");
    labelDiasTrabajados.setFont(labelFont);
    gbc.gridx = 0;
    gbc.gridy = 2;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.insets = new Insets(15, 5, 15, 5);  // Aumenta espacio entre las filas
    dataInputPanel.add(labelDiasTrabajados, gbc);

    JTextField fieldDiasTrabajados = new RoundedTextField("");
    fieldDiasTrabajados.setPreferredSize(new Dimension(150, 30)); // Tamaño un poco más grande
    fieldDiasTrabajados.setFont(textFieldFont);
    gbc.gridx = 1;
    gbc.anchor = GridBagConstraints.WEST;
    dataInputPanel.add(fieldDiasTrabajados, gbc);

    // Botón "Calcular" debajo de los campos de entrada
    JButton botonCalcular = new RoundedButton("Calcular");
    gbc.gridx = 0;
    gbc.gridy = 3;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.insets = new Insets(20, 5, 20, 5);  // Espacio extra antes y después del botón
    dataInputPanel.add(botonCalcular, gbc);

    // Etiqueta para mostrar el resultado del aguinaldo
    JLabel labelResultadoAguinaldo = new JLabel("Aguinaldo Calculado:");
    labelResultadoAguinaldo.setFont(labelFont);
    gbc.gridx = 0;
    gbc.gridy = 4;
    gbc.gridwidth = 1;
    gbc.anchor = GridBagConstraints.EAST;
    gbc.insets = new Insets(15, 5, 5, 5);  // Espacio adicional para separar del botón anterior
    dataInputPanel.add(labelResultadoAguinaldo, gbc);

    JLabel resultadoAguinaldo = new JLabel("₡0.00"); // Valor inicial para el resultado
    resultadoAguinaldo.setFont(new Font("Segoe UI", Font.PLAIN, 18)); // Tamaño intermedio para el resultado
    resultadoAguinaldo.setForeground(new Color(60, 60, 60));
    gbc.gridx = 1;
    gbc.anchor = GridBagConstraints.WEST;
    dataInputPanel.add(resultadoAguinaldo, gbc);

    // Añadir el panel de entrada de datos al centro del panel de aguinaldo
    panelAguinaldo.add(dataInputPanel, BorderLayout.CENTER);

    // Botón para regresar al menú principal
    botonRegresarAguinaldo = new RoundedButton("Volver al Menú");
    JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 10));
    bottomPanel.setBackground(new Color(235, 245, 255));
    bottomPanel.add(botonRegresarAguinaldo);
    panelAguinaldo.add(bottomPanel, BorderLayout.SOUTH);
}

/////////////////////////////////////////////////////////////////////////////////////////

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
        horasField = new RoundedTextField("6");

        

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
        panelFormulario.add(new JLabel("Horas Extras:"), gbc);
        gbc.gridx = 1;
        panelFormulario.add(horasField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 6;
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
    public JTextField getHorasField() { return horasField; }
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
