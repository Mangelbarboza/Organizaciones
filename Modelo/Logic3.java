package Modelo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Logic3 {
    private JTextField[] salarioMensualFields;
    private JLabel resultadoAguinaldoLabel;

    public Logic3(JTextField[] salarioMensualFields, JLabel resultadoAguinaldoLabel) {
        this.salarioMensualFields = salarioMensualFields;
        this.resultadoAguinaldoLabel = resultadoAguinaldoLabel;
    }

    // Método para calcular el aguinaldo según la ley de Costa Rica
    public double calcularAguinaldo() {
        double totalSalarios = 0;

        // Sumamos todos los salarios mensuales
        for (int i = 0; i < 12; i++) {
            try {
                String textoSalario = salarioMensualFields[i].getText().trim();
                double salarioMensual = textoSalario.isEmpty() ? 0 : Double.parseDouble(textoSalario);
                totalSalarios += salarioMensual;
            } catch (NumberFormatException e) {
                // En caso de que el campo no sea un número válido
                JOptionPane.showMessageDialog(null, "Por favor ingrese valores válidos en todos los meses.", "Error de Entrada", JOptionPane.ERROR_MESSAGE);
                return 0; // Si hay un error, retornamos 0
            }
        }

        // El aguinaldo es la doceava parte del total de salarios
        return totalSalarios / 12;
    }

    // Método para actualizar la etiqueta con el aguinaldo calculado
    public void actualizarAguinaldo() {
        double aguinaldo = calcularAguinaldo();
        if (aguinaldo > 0) {
            resultadoAguinaldoLabel.setText("Aguinaldo Calculado: ₡" + String.format("%.2f", aguinaldo));
        }
    }


}