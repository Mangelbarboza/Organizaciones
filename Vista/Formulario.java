package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class Formulario extends JPanel {
    private JTextField nombreField;
    private JTextField cedulaField;
    private JTextField puestoField;
    private JTextField salarioBrutoField;
    private JButton botonGuardarContinuar;

    public Formulario() {
        setLayout(new GridBagLayout());
        setBackground(new Color(235, 245, 255));
        setBorder(createRoundedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        // Título
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        JLabel tituloLabel = new JLabel("Formulario de Empleado", SwingConstants.CENTER);
        tituloLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(tituloLabel, gbc);

        // Logo
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/Vista/Logo.png"));
        Image scaledImage = originalIcon.getImage().getScaledInstance(originalIcon.getIconWidth() / 2, originalIcon.getIconHeight() / 2, Image.SCALE_SMOOTH);
        JLabel logoLabel = new JLabel(new ImageIcon(scaledImage), SwingConstants.CENTER);
        add(logoLabel, gbc);

        // Campo para Nombre Completo
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Nombre Completo:"), gbc);
        nombreField = new JTextField(20);
        nombreField.setText("Angel Cristal Hernandez");
        gbc.gridx = 1;
        add(nombreField, gbc);

        // Campo para Cédula
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Cédula:"), gbc);
        cedulaField = new JTextField(20);
        cedulaField.setText("7-0297-0336");
        gbc.gridx = 1;
        add(cedulaField, gbc);

        // Campo para Puesto
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Puesto:"), gbc);
        puestoField = new JTextField(20);
        puestoField.setText("Desarrollador de Software");
        gbc.gridx = 1;
        add(puestoField, gbc);

        // Campo para Salario Bruto
        gbc.gridx = 0;
        gbc.gridy++;
        add(new JLabel("Salario Bruto:"), gbc);
        salarioBrutoField = new JTextField(20);
        salarioBrutoField.setText("350.000");
        gbc.gridx = 1;
        add(salarioBrutoField, gbc);

        // Botón para Guardar y Continuar
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        botonGuardarContinuar = new JButton("Guardar y Continuar");
        add(botonGuardarContinuar, gbc);
    }

    // Getters para los campos
    public JTextField getNombreField() {
        return nombreField;
    }

    public JTextField getCedulaField() {
        return cedulaField;
    }

    public JTextField getPuestoField() {
        return puestoField;
    }

    public JTextField getSalarioBrutoField() {
        return salarioBrutoField;
    }

    public JButton getBotonGuardarContinuar() {
        return botonGuardarContinuar;
    }

    // Método para crear un borde redondeado
    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
