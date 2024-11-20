package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class AguinaldoPanel extends JPanel {
    private JTextField salarioMensualField, horasExtrasField, mesesTrabajadosField;
    public JButton botonCalcularAguinaldo, botonRegresarAguinaldo;
    public JLabel resultadoAguinaldoLabel;

    public AguinaldoPanel() {
        setLayout(new GridBagLayout());  // Utiliza GridBagLayout para organizar los componentes
        setBackground(new Color(235, 245, 255));  // Fondo pastel claro
        setBorder(createRoundedBorder());

        // Configuración de GridBagConstraints para organizar los componentes
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);  // Espaciado alrededor de cada componente

        // Etiqueta y campo de texto para el Salario Mensual
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Salario Mensual:"), gbc);
        salarioMensualField = new RoundedTextField("");  // Inicializa el JTextField
        salarioMensualField.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(salarioMensualField, gbc);

        // Etiqueta y campo de texto para las Horas Extras Mensuales
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Horas Extras Mensuales:"), gbc);
        horasExtrasField = new RoundedTextField("");  // Inicializa el JTextField
        horasExtrasField.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(horasExtrasField, gbc);

        // Etiqueta y campo de texto para los Meses Trabajados en el Año
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Meses Trabajados en el Año:"), gbc);
        mesesTrabajadosField = new RoundedTextField("");  // Inicializa el JTextField
        mesesTrabajadosField.setPreferredSize(new Dimension(150, 25));
        gbc.gridx = 1;
        add(mesesTrabajadosField, gbc);

        // Botón para calcular aguinaldo
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;  // El botón ocupa las dos columnas
        botonCalcularAguinaldo = new RoundedButton("Calcular Aguinaldo");
        add(botonCalcularAguinaldo, gbc);

        // Etiqueta para mostrar el resultado del aguinaldo
        gbc.gridy = 4;
        resultadoAguinaldoLabel = new JLabel("Aguinaldo Calculado: ₡0.00", SwingConstants.CENTER);
        add(resultadoAguinaldoLabel, gbc);

        // Botón para regresar al menú principal
        gbc.gridy = 5;
        botonRegresarAguinaldo = new RoundedButton("Volver al Menú");
        add(botonRegresarAguinaldo, gbc);
    }

    // Getters para acceder a los campos de texto y botones desde el controlador
    public JTextField getSalarioMensualField() { return salarioMensualField; }
    public JTextField getHorasExtrasField() { return horasExtrasField; }
    public JTextField getMesesTrabajadosField() { return mesesTrabajadosField; }
    public JButton getBotonCalcularAguinaldo() { return botonCalcularAguinaldo; }
    public JLabel getResultadoAguinaldoLabel() { return resultadoAguinaldoLabel; }
    public JButton getBotonRegresarAguinaldo() { return botonRegresarAguinaldo; }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
