package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("FieldMayBeFinal")
public class SalarioNetoPanel extends JPanel {
    private JTextField fieldSalarioBruto, fieldDiasTrabajados, fieldHoras;
    private JTextField fieldSalarioNetoCalculado, fieldCargasSociales, fieldRentaDeducida;
    
    private JButton botonRegresarSalario;
    private JButton botonCalcularSalarioNeto;

    public SalarioNetoPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(235, 245, 255));
        setBorder(createRoundedBorder());

        // Color de fondo común para los JTextFields y botones
        Color backgroundColor = new Color(173, 216, 230); // Azul claro similar al botón

        JPanel dataInputPanel = new JPanel();
        dataInputPanel.setLayout(new GridLayout(6, 2, 10, 10));
        dataInputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        dataInputPanel.setBackground(new Color(235, 245, 255));

        // Campos de entrada de datos del trabajador
        dataInputPanel.add(new JLabel("Salario Bruto:"));
        fieldSalarioBruto = new RoundedTextField("");
        fieldSalarioBruto.setBackground(backgroundColor);
        dataInputPanel.add(fieldSalarioBruto);

        dataInputPanel.add(new JLabel("Días Trabajados:"));
        fieldDiasTrabajados = new RoundedTextField("");
        fieldDiasTrabajados.setBackground(backgroundColor);
        dataInputPanel.add(fieldDiasTrabajados);

        dataInputPanel.add(new JLabel("Horas Extras:"));
        fieldHoras = new RoundedTextField("");
        fieldHoras.setBackground(backgroundColor);
        dataInputPanel.add(fieldHoras);

        // Campos de salida de cálculo
        dataInputPanel.add(new JLabel("Salario Neto Calculado:"));
        fieldSalarioNetoCalculado = new RoundedTextField("");
        fieldSalarioNetoCalculado.setEditable(false);
        fieldSalarioNetoCalculado.setBackground(backgroundColor);
        dataInputPanel.add(fieldSalarioNetoCalculado);

        dataInputPanel.add(new JLabel("Cargas Sociales Patrono:"));
        fieldCargasSociales = new RoundedTextField("");
        fieldCargasSociales.setEditable(false);
        fieldCargasSociales.setBackground(backgroundColor);
        dataInputPanel.add(fieldCargasSociales);

        dataInputPanel.add(new JLabel("Renta Deducida:"));
        fieldRentaDeducida = new RoundedTextField("");
        fieldRentaDeducida.setEditable(false);
        fieldRentaDeducida.setBackground(backgroundColor);
        dataInputPanel.add(fieldRentaDeducida);

        add(dataInputPanel, BorderLayout.CENTER);

        // Botones de cálculo y regreso
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        buttonPanel.setBackground(new Color(235, 245, 255));

        botonCalcularSalarioNeto = new RoundedButton("Calcular Salario Neto");
        botonCalcularSalarioNeto.setBackground(backgroundColor);
        buttonPanel.add(botonCalcularSalarioNeto);

        botonRegresarSalario = new RoundedButton("Volver al Menú");
        botonRegresarSalario.setBackground(backgroundColor);
        buttonPanel.add(botonRegresarSalario);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Getters y Setters para cada campo

    public JTextField getFieldSalarioBruto() { return fieldSalarioBruto; }
    public JTextField getFieldDiasTrabajados() { return fieldDiasTrabajados; }
    public JTextField getFieldHoras() { return fieldHoras; }
    public JTextField getFieldSalarioNetoCalculado() { return fieldSalarioNetoCalculado; }
    public JTextField getFieldCargasSociales() { return fieldCargasSociales; }
    public JTextField getFieldRentaDeducida() { return fieldRentaDeducida; }
    public JButton getBotonCalcularSalarioNeto() { return botonCalcularSalarioNeto; }
    public JButton getBotonRegresarSalario() { return botonRegresarSalario; }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
