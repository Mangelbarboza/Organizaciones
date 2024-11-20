package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class SalarioNetoPanel extends JPanel {
    private JTextField fieldSalarioBruto, fieldDiasTrabajados, fieldHoras;
    public JButton botonRegresarSalario;

    public SalarioNetoPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(235, 245, 255));
        setBorder(createRoundedBorder());

        JPanel dataInputPanel = new JPanel();
        dataInputPanel.setLayout(new GridLayout(3, 2, 10, 10));
        dataInputPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        dataInputPanel.setBackground(new Color(235, 245, 255));

        dataInputPanel.add(new JLabel("Salario Bruto:"));
        fieldSalarioBruto = new RoundedTextField("");
        dataInputPanel.add(fieldSalarioBruto);

        dataInputPanel.add(new JLabel("Días Trabajados:"));
        fieldDiasTrabajados = new RoundedTextField("");
        dataInputPanel.add(fieldDiasTrabajados);

        dataInputPanel.add(new JLabel("Horas Extras:"));
        fieldHoras = new RoundedTextField("");
        dataInputPanel.add(fieldHoras);

        add(dataInputPanel, BorderLayout.NORTH);

        botonRegresarSalario = new RoundedButton("Volver al Menú");
        add(botonRegresarSalario, BorderLayout.SOUTH);
    }

    public JTextField getFieldSalarioBruto() { return fieldSalarioBruto; }
    public JTextField getFieldDiasTrabajados() { return fieldDiasTrabajados; }
    public JTextField getFieldHoras() { return fieldHoras; }
    public JButton getBotonRegresarSalario() { return botonRegresarSalario; }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
