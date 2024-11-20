package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class VacacionesPanel extends JPanel {
    private JTextField salarioMensualField;
    private JTextField diasTrabajadosField;  // Nuevo campo
    public JButton botonCalcularVacaciones, botonRegresarVacaciones;
    public JLabel resultadoDiasLabel, resultadoPagoLabel;

    public VacacionesPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(235, 245, 255));
        setBorder(createRoundedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel label = new JLabel("Cálculo de Vacaciones", SwingConstants.CENTER);
        label.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(label, gbc);

        gbc.gridwidth = 1;
        gbc.gridy++;
        add(new JLabel("Salario Mensual:"), gbc);
        salarioMensualField = new RoundedTextField("");
        gbc.gridx = 1;
        add(salarioMensualField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Días Trabajados:"), gbc);  // Etiqueta para días trabajados
        diasTrabajadosField = new RoundedTextField("");  // Campo de texto para días trabajados
        gbc.gridx = 1;
        add(diasTrabajadosField, gbc);

        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        botonCalcularVacaciones = new RoundedButton("Calcular Vacaciones");
        add(botonCalcularVacaciones, gbc);

        gbc.gridy++;
        resultadoDiasLabel = new JLabel("Días de Vacaciones: ");
        add(resultadoDiasLabel, gbc);

        gbc.gridy++;
        resultadoPagoLabel = new JLabel("Pago de Vacaciones: ");
        add(resultadoPagoLabel, gbc);

        gbc.gridy++;
        botonRegresarVacaciones = new RoundedButton("Volver al Menú");
        add(botonRegresarVacaciones, gbc);
    }

    public JTextField getSalarioMensualField() { return salarioMensualField; }
    public JTextField getDiasTrabajadosField() { return diasTrabajadosField; }  // Getter para días trabajados
    public JButton getBotonCalcularVacaciones() { return botonCalcularVacaciones; }
    public JLabel getResultadoDiasLabel() { return resultadoDiasLabel; }
    public JLabel getResultadoPagoLabel() { return resultadoPagoLabel; }
    public JButton getBotonRegresarVacaciones() { return botonRegresarVacaciones; }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
