package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipal extends JFrame {
    private CardLayout cardLayout;
    public JButton botonSalarioNeto, botonVacaciones, botonAguinaldo, botonSalir;
    public JButton botonRegresarSalario, botonRegresarVacaciones, botonRegresarAguinaldo;
    public JButton botonTerminarContinuar;
    public JPanel panelMenu, panelSalarioNeto, panelVacaciones, panelAguinaldo, panelFormulario;
    
    // Campos de texto del formulario
    private JTextField nombreField, cedulaField, puestoField, fechaIngresoField;
    private JTextField salarioBrutoField, tipoContratoField, deduccionesField;
    private JTextField diasTrabajadosField, vacacionesTomadasField, fechaInicioVacacionesField, fechaFinVacacionesField;
    private JTextField fechaDespidoField, causaDespidoField, aguinaldoPendienteField, diasNoRemuneradosField;

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

        // Acción del botón "Terminar y Continuar" para ir al panel de menú
        botonTerminarContinuar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(getContentPane(), "menu"); // Muestra el menú principal
            }
        });
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
         panelVacaciones.add(new JLabel("Salario Mensual:"));
         panelVacaciones.add(salarioMensualField);

         // Campo de entrada para días trabajados
         diasTrabajadosField = new JTextField();
         panelVacaciones.add(new JLabel("Días Trabajados:"));
         panelVacaciones.add(diasTrabajadosField);

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

    private void initFormularioPanel() {
        panelFormulario = new JPanel(new GridLayout(15, 2, 10, 10));
        panelFormulario.setBackground(new Color(255, 255, 255));
        panelFormulario.setBorder(createRoundedBorder());

        nombreField = new JTextField();
        cedulaField = new JTextField();
        puestoField = new JTextField();
        fechaIngresoField = new JTextField();
        salarioBrutoField = new JTextField();
        tipoContratoField = new JTextField();
        deduccionesField = new JTextField();
        diasTrabajadosField = new JTextField();
        vacacionesTomadasField = new JTextField();
        fechaInicioVacacionesField = new JTextField();
        fechaFinVacacionesField = new JTextField();
        fechaDespidoField = new JTextField();
        causaDespidoField = new JTextField();
        aguinaldoPendienteField = new JTextField();
        diasNoRemuneradosField = new JTextField();

        panelFormulario.add(new JLabel("Nombre Completo:"));
        panelFormulario.add(nombreField);
        panelFormulario.add(new JLabel("Cédula:"));
        panelFormulario.add(cedulaField);
        panelFormulario.add(new JLabel("Puesto:"));
        panelFormulario.add(puestoField);
        panelFormulario.add(new JLabel("Fecha de Ingreso:"));
        panelFormulario.add(fechaIngresoField);
        panelFormulario.add(new JLabel("Salario Bruto:"));
        panelFormulario.add(salarioBrutoField);
        panelFormulario.add(new JLabel("Tipo de Contrato:"));
        panelFormulario.add(tipoContratoField);
        panelFormulario.add(new JLabel("Deducciones:"));
        panelFormulario.add(deduccionesField);
        panelFormulario.add(new JLabel("Días Trabajados:"));
        panelFormulario.add(diasTrabajadosField);
        panelFormulario.add(new JLabel("Vacaciones Tomadas:"));
        panelFormulario.add(vacacionesTomadasField);
        panelFormulario.add(new JLabel("Fecha Inicio Vacaciones:"));
        panelFormulario.add(fechaInicioVacacionesField);
        panelFormulario.add(new JLabel("Fecha Fin Vacaciones:"));
        panelFormulario.add(fechaFinVacacionesField);
        panelFormulario.add(new JLabel("Fecha de Despido:"));
        panelFormulario.add(fechaDespidoField);
        panelFormulario.add(new JLabel("Causa del Despido:"));
        panelFormulario.add(causaDespidoField);
        panelFormulario.add(new JLabel("Aguinaldo Pendiente:"));
        panelFormulario.add(aguinaldoPendienteField);
        panelFormulario.add(new JLabel("Días No Remunerados:"));
        panelFormulario.add(diasNoRemuneradosField);

        botonTerminarContinuar = crearBoton("Terminar y Continuar");
        panelFormulario.add(botonTerminarContinuar);
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
    
}
