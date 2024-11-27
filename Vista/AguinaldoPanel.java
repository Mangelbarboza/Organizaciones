package Vista;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import java.awt.*;

public class AguinaldoPanel extends JPanel {
    private JTextField[] salarioMensualFields = new JTextField[12];  // Campos para el salario de cada mes
    public JButton botonCalcularAguinaldo, botonRegresarAguinaldo;
    public JLabel resultadoAguinaldoLabel;

    public AguinaldoPanel() {
        setLayout(null);  // Desactivar el layout por defecto
        setBackground(new Color(235, 245, 255));  // Fondo pastel claro
        setBorder(createRoundedBorder());

        // Crear el arreglo de meses para mostrar las etiquetas
        String[] meses = {
            "Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", 
            "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"
        };

        // Título para los campos
        JLabel tituloLabel = new JLabel("Ingrese los datos para cada mes del año", JLabel.CENTER);
        tituloLabel.setFont(new Font("Arial", Font.BOLD, 16));
        tituloLabel.setBounds(50, 10, 400, 30);  // Posicion y tamaño del título
        add(tituloLabel);

        // Colocamos los meses y campos de salario en dos columnas (6 meses por columna)
        int xOffset = 2; // Desplazamiento horizontal
        int yOffset = 50; // Desplazamiento vertical inicial
        int fieldWidth = 120; // Ancho de los campos
        int fieldHeight = 25; // Altura de los campos
        int labelWidth = 100; // Ancho de las etiquetas

        // Colocamos los meses y campos de salario en dos columnas (Enero - Junio, Julio - Diciembre)
        for (int i = 0; i < 6; i++) {
            // Columna 1 (Enero - Junio)
            int yPos = yOffset + (i * 50); // Calcular la posición vertical de cada fila

            // Etiqueta del mes
            JLabel mesLabel = new JLabel(meses[i]);
            mesLabel.setBounds(xOffset, yPos, labelWidth, fieldHeight);
            add(mesLabel);

            // Campo de salario mensual
            salarioMensualFields[i] = new RoundedTextField("");
            salarioMensualFields[i].setBounds(xOffset + 70, yPos, fieldWidth, fieldHeight);
            add(salarioMensualFields[i]);

            // Aplicar filtro para permitir solo números
            applyNumberOnlyFilter(salarioMensualFields[i]);
        }

        // Colocamos los meses y campos de salario en la segunda columna (Julio - Diciembre)
        for (int i = 6; i < 12; i++) {
            // Columna 2 (Julio - Diciembre)
            int yPos = yOffset + ((i - 6) * 50); // Calcular la posición vertical de la segunda columna

            // Etiqueta del mes
            JLabel mesLabel = new JLabel(meses[i]);
            mesLabel.setBounds(xOffset + 250, yPos, labelWidth, fieldHeight);
            add(mesLabel);

            // Campo de salario mensual
            salarioMensualFields[i] = new RoundedTextField("");
            salarioMensualFields[i].setBounds(xOffset + 320, yPos, fieldWidth, fieldHeight);
            add(salarioMensualFields[i]);

            // Aplicar filtro para permitir solo números
            applyNumberOnlyFilter(salarioMensualFields[i]);
        }

        // Botón para calcular aguinaldo
        botonCalcularAguinaldo = new RoundedButton("Calcular Aguinaldo");
        botonCalcularAguinaldo.setBounds(100, 380, 300, 35);  // Ubicación y tamaño del botón
        add(botonCalcularAguinaldo);

        // Etiqueta para mostrar el resultado del aguinaldo
        resultadoAguinaldoLabel = new JLabel("Aguinaldo Calculado: ₡0.00", SwingConstants.CENTER);
        resultadoAguinaldoLabel.setBounds(100, 450, 300, 30);  // Ubicación y tamaño de la etiqueta
        add(resultadoAguinaldoLabel);

        // Botón para regresar al menú principal
        botonRegresarAguinaldo = new RoundedButton("Volver al Menú");
        botonRegresarAguinaldo.setBounds(100, 490, 300, 35);  // Ubicación y tamaño del botón
        add(botonRegresarAguinaldo);
    }

    // Método para aplicar el filtro de solo números en el JTextField
    private void applyNumberOnlyFilter(JTextField textField) {
        // Usamos un DocumentFilter para permitir solo números
        AbstractDocument document = (AbstractDocument) textField.getDocument();
        document.setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string.matches("[0-9]*") || string.equals(".")) {  // Permitir solo números y puntos
                    super.insertString(fb, offset, string, attr);
                }
            }

            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text.matches("[0-9]*") || text.equals(".")) {  // Permitir solo números y puntos
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    // Getters para acceder a los campos de texto y botones desde el controlador
    public JTextField[] getSalarioMensualFields() { return salarioMensualFields; }
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