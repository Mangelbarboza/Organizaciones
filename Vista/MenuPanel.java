package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

public class MenuPanel extends JPanel {
    public JButton botonSalarioNeto, botonVacaciones, botonAguinaldo, botonSalir;

    public MenuPanel() {
        setLayout(new GridBagLayout());
        setBackground(new Color(235, 245, 255));
        setBorder(createRoundedBorder());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(10, 10, 10, 10);

        botonSalarioNeto = new RoundedButton("Calcular Salario Neto");
        botonVacaciones = new RoundedButton("Calcular Vacaciones");
        botonAguinaldo = new RoundedButton("Calcular Aguinaldo");
        botonSalir = new RoundedButton("Salir");

        gbc.gridy = 0;
        add(botonSalarioNeto, gbc);
        gbc.gridy++;
        add(botonVacaciones, gbc);
        gbc.gridy++;
        add(botonAguinaldo, gbc);
        gbc.gridy++;
        add(botonSalir, gbc);
    }

    public JButton getBotonSalarioNeto() { return botonSalarioNeto; }
    public JButton getBotonVacaciones() { return botonVacaciones; }
    public JButton getBotonAguinaldo() { return botonAguinaldo; }
    public JButton getBotonSalir() { return botonSalir; }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(15, 15, 15, 15)
        );
    }
}
