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

    //Nai pero aun tengo duda
    private JTextField salarioMensualField;
    private JLabel resultadoDiasLabel, resultadoPagoLabel;
    public JButton botonCalcularVacaciones;


    public MenuPrincipal() {
        setTitle("Sistema de Cálculo Laboral");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Usar CardLayout para cambiar entre paneles
        cardLayout = new CardLayout();
        setLayout(cardLayout);

        // Inicializar paneles y estilo general
        initFormularioPanel(); // Mostrar el formulario primero
        initMenuPanel();
        initSalarioPanel();
        initVacacionesPanel();
        initAguinaldoPanel();

        // Añadir paneles al CardLayout
        add(panelFormulario, "formulario"); // Formulario inicial
        add(panelMenu, "menu"); // Menú principal
        add(panelSalarioNeto, "salarioNeto");
        add(panelVacaciones, "vacaciones");
        add(panelAguinaldo, "aguinaldo");

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
        gbc.insets = new Insets(10, 10, 10, 10);

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
         panelVacaciones = new JPanel();
         panelVacaciones.setLayout(new BoxLayout(panelVacaciones, BoxLayout.Y_AXIS));
         panelVacaciones.setBackground(new Color(255, 255, 255));
         panelVacaciones.setBorder(createRoundedBorder());

         JLabel label = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
         label.setFont(new Font("SansSerif", Font.BOLD, 18));
         label.setForeground(new Color(50, 50, 50));
         panelVacaciones.add(label);

          // Campo de entrada para salario mensual
         salarioMensualField = new JTextField();
         salarioMensualField.setText("Salario mensual");
         panelVacaciones.add(new JLabel("Salario Mensual:"));
         panelVacaciones.add(salarioMensualField);


         // Botón para calcular vacaciones
         botonCalcularVacaciones = crearBoton("Calcular Vacaciones");
         panelVacaciones.add(botonCalcularVacaciones);

         // Etiquetas para mostrar resultados
         resultadoDiasLabel = new JLabel("Días de Vacaciones: ");
         resultadoPagoLabel = new JLabel("Pago de Vacaciones: ");
         panelVacaciones.add(resultadoDiasLabel);
         panelVacaciones.add(resultadoPagoLabel);

         //Boton para regresar al menu pue
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

    private void initFormularioPanel() {//Nai
        panelFormulario = new JPanel(new GridLayout(8, 2, 10, 10)); // Cambiamos el tamaño de la cuadrícula para menos campos
    panelFormulario.setBackground(new Color(255, 255, 255));
    panelFormulario.setBorder(createRoundedBorder());

        // Campos de texto esenciales
    nombreField = new JTextField();
    nombreField.setText("Angel Hernandez Corea");

    cedulaField = new JTextField();
    cedulaField.setText("702970336");

    puestoField = new JTextField();
    puestoField.setText("Desarrolladores");

    salarioBrutoField = new JTextField();
    salarioBrutoField.setText("1500000");

    diasTrabajadosField = new JTextField();
    diasTrabajadosField.setText("286");

    // Añadimos solo los campos esenciales al panel
    panelFormulario.add(new JLabel("Nombre Completo:"));
    panelFormulario.add(nombreField);

    panelFormulario.add(new JLabel("Cédula:"));
    panelFormulario.add(cedulaField);

    panelFormulario.add(new JLabel("Puesto:"));
    panelFormulario.add(puestoField);

    panelFormulario.add(new JLabel("Salario Bruto:"));
    panelFormulario.add(salarioBrutoField);
  

    panelFormulario.add(new JLabel("Días Trabajados:"));
    panelFormulario.add(diasTrabajadosField);

       // Botón para continuar y guardar los datos
    botonTerminarContinuar = crearBoton("Guardar y Continuar");
    panelFormulario.add(botonTerminarContinuar);

    // Acción del botón "Guardar y Continuar"
    
    }

    private JButton crearBoton(String texto) {
        JButton boton = new JButton(texto);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(75, 85, 99));
        boton.setForeground(Color.WHITE);
        boton.setFont(new Font("SansSerif", Font.PLAIN, 16));
        boton.setBorder(BorderFactory.createEmptyBorder(15, 10, 15, 10));
        boton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        boton.setOpaque(true);
        boton.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        return boton;
    }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }

    public JButton getBotonTerminarContinuar() {
        return botonTerminarContinuar;
    }

    //Gett y Set publicos Nai
    public JTextField getSalarioMensualField() {
        return salarioMensualField;
    }
    
    public JTextField getDiasTrabajadosField() {
        return diasTrabajadosField;
    }
    
    public JLabel getResultadoDiasLabel() {
        return resultadoDiasLabel;
    }
    
    public JLabel getResultadoPagoLabel() {
        return resultadoPagoLabel;
    }

public JTextField getNombreField() { return nombreField; }
public JTextField getCedulaField() { return cedulaField; }
public JTextField getPuestoField() { return puestoField; }
public JTextField getSalarioBrutoField() { return salarioBrutoField; }
}
