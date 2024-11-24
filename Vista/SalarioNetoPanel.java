
package Vista;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;

@SuppressWarnings("FieldMayBeFinal")
public class SalarioNetoPanel extends JPanel {
    private JTextField fieldSalarioBruto;
    private JTextField fieldSemPatrono, fieldSemTrabajador, fieldSemTotalColones;
    private JTextField fieldIvmPatrono, fieldIvmTrabajador, fieldIvmTotalColones;
    private JTextField fieldTotalCCSSPatrono, fieldTotalCCSSTrabajador, fieldTotalCCSSTotalColones;

    private JTextField fieldBpopPatrono, fieldBpopTotalColones;
    private JTextField fieldAsignacionesPatrono, fieldAsignacionesTotalColones;
    private JTextField fieldImasPatrono, fieldImasTotalColones;
    private JTextField fieldInaPatrono, fieldInaTotalColones;
    private JTextField fieldTotalOtrasInstitucionesPatrono, fieldTotalOtrasInstitucionesTotalColones;

    private JTextField fieldBpopLPTPatrono, fieldBpopLPTTrabajador, fieldBpopLPTTotalColones;
    private JTextField fieldFclPatrono, fieldFclTotalColones;
    private JTextField fieldOpcPatrono, fieldOpcTotalColones;
    private JTextField fieldInsPatrono, fieldInsTrabajador, fieldInsTotalColones;
    private JTextField fieldTotalLPTPatrono, fieldTotalLPTTrabajador, fieldTotalLPTTotalColones;

    // Nuevos campos para el resumen
    private JTextField fieldTotalPorcentajePatrono, fieldTotalPorcentajeTrabajador, fieldTotalPorcentajeGeneral;
    private JTextField fieldTotalesPatrono, fieldTotalesTrabajador, fieldTotalesGeneral;

    private JButton botonCalcular, botonVolver;

    public SalarioNetoPanel() {
        setLayout(new BorderLayout(20, 20));
        setBackground(new Color(235, 245, 255));
        setBorder(createRoundedBorder());

        // Panel principal para contener todo
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS)); // Distribuir verticalmente
        mainPanel.setBackground(new Color(235, 245, 255));

        // Entrada de salario bruto
        JPanel salarioBrutoPanel = createSectionPanel("Entrada");
        salarioBrutoPanel.setLayout(new GridLayout(1, 2, 10, 10));
        salarioBrutoPanel.add(new JLabel("Salario Bruto:"));
        fieldSalarioBruto = createTextField("", true);
        salarioBrutoPanel.add(fieldSalarioBruto);
        mainPanel.add(salarioBrutoPanel);

        // Sección CCSS
        JPanel ccssPanel = createSectionPanel("CCSS");
        ccssPanel.setLayout(new GridLayout(3, 4, 10, 10)); // Ahora con 4 columnas
        addRow(ccssPanel, "SEM", fieldSemPatrono = createTextField("", false), fieldSemTrabajador = createTextField("", false), fieldSemTotalColones = createTextField("", false));
        addRow(ccssPanel, "IVM", fieldIvmPatrono = createTextField("", false), fieldIvmTrabajador = createTextField("", false), fieldIvmTotalColones = createTextField("", false));
        addRow(ccssPanel, "Total CCSS", fieldTotalCCSSPatrono = createTextField("", false), fieldTotalCCSSTrabajador = createTextField("", false), fieldTotalCCSSTotalColones = createTextField("", false));
        mainPanel.add(ccssPanel);

        // Sección Otras Instituciones
        JPanel otrasInstitucionesPanel = createSectionPanel("Otras Instituciones");
        otrasInstitucionesPanel.setLayout(new GridLayout(5, 4, 10, 10)); // Ahora con 4 columnas
        addRow(otrasInstitucionesPanel, "Banco Popular", fieldBpopPatrono = createTextField("", false), new JLabel("-"), fieldBpopTotalColones = createTextField("", false));
        addRow(otrasInstitucionesPanel, "Asignaciones Familiares", fieldAsignacionesPatrono = createTextField("", false), new JLabel("-"), fieldAsignacionesTotalColones = createTextField("", false));
        addRow(otrasInstitucionesPanel, "IMAS", fieldImasPatrono = createTextField("", false), new JLabel("-"), fieldImasTotalColones = createTextField("", false));
        addRow(otrasInstitucionesPanel, "INA", fieldInaPatrono = createTextField("", false), new JLabel("-"), fieldInaTotalColones = createTextField("", false));
        addRow(otrasInstitucionesPanel, "Total Otras Instituciones", fieldTotalOtrasInstitucionesPatrono = createTextField("", false), new JLabel("-"), fieldTotalOtrasInstitucionesTotalColones = createTextField("", false));
        mainPanel.add(otrasInstitucionesPanel);

        // Sección Ley de Protección al Trabajador
        JPanel lptPanel = createSectionPanel("Ley de Protección al Trabajador");
        lptPanel.setLayout(new GridLayout(5, 4, 10, 10)); // Ahora con 4 columnas
        addRow(lptPanel, "BPOP LPT", fieldBpopLPTPatrono = createTextField("", false), fieldBpopLPTTrabajador = createTextField("", false), fieldBpopLPTTotalColones = createTextField("", false));
        addRow(lptPanel, "FCL", fieldFclPatrono = createTextField("", false), new JLabel("-"), fieldFclTotalColones = createTextField("", false));
        addRow(lptPanel, "OPC", fieldOpcPatrono = createTextField("", false), new JLabel("-"), fieldOpcTotalColones = createTextField("", false));
        addRow(lptPanel, "INS", fieldInsPatrono = createTextField("", false), fieldInsTrabajador = createTextField("", false), fieldInsTotalColones = createTextField("", false));
        addRow(lptPanel, "Total LPT", fieldTotalLPTPatrono = createTextField("", false), fieldTotalLPTTrabajador = createTextField("", false), fieldTotalLPTTotalColones = createTextField("", false));
        mainPanel.add(lptPanel);

        // Resumen: Total Porcentajes y Totales en Colones
        JPanel resumenPanel = createSectionPanel("Resumen");
        resumenPanel.setLayout(new GridLayout(2, 4, 10, 10)); // Dos filas: Porcentajes y Totales
        addRow(resumenPanel, "Total %", fieldTotalPorcentajePatrono = createTextField("", false), fieldTotalPorcentajeTrabajador = createTextField("", false), fieldTotalPorcentajeGeneral = createTextField("", false));
        addRow(resumenPanel, "Totales", fieldTotalesPatrono = createTextField("", false), fieldTotalesTrabajador = createTextField("", false), fieldTotalesGeneral = createTextField("", false));
        mainPanel.add(resumenPanel);

        // Agregar panel principal con JScrollPane
        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane, BorderLayout.CENTER);

        // Botones
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 20, 20));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        buttonPanel.setBackground(new Color(235, 245, 255));

        botonCalcular = new JButton("Calcular");
        botonCalcular.setBackground(new Color(173, 216, 230));
        buttonPanel.add(botonCalcular);

        botonVolver = new JButton("Volver");
        botonVolver.setBackground(new Color(173, 216, 230));
        buttonPanel.add(botonVolver);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // Métodos auxiliares para construir la UI
    private JPanel createSectionPanel(String title) {
        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(173, 216, 230), 1), title));
        panel.setBackground(new Color(235, 245, 255));
        return panel;
    }

    private void addRow(JPanel panel, String label, Component col1, Component col2, Component col3) {
        panel.add(new JLabel(label + ":"));
        panel.add(col1);
        panel.add(col2);
        panel.add(col3);
    }

    private JTextField createTextField(String placeholder, boolean editable) {
        JTextField textField = new JTextField(placeholder);
        textField.setEditable(editable);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);
        return textField;
    }

    private Border createRoundedBorder() {
        return BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(180, 180, 180), 1),
                BorderFactory.createEmptyBorder(10, 10, 10, 10)
        );
    }

    // Getters para los campos, incluyendo los nuevos
    public JTextField getFieldSalarioBruto() {
        return fieldSalarioBruto;
    }

    public JTextField getFieldSemPatrono() {
        return fieldSemPatrono;
    }

    public JTextField getFieldSemTrabajador() {
        return fieldSemTrabajador;
    }

    public JTextField getFieldSemTotalColones() {
        return fieldSemTotalColones;
    }

    public JTextField getFieldIvmPatrono() {
        return fieldIvmPatrono;
    }

    public JTextField getFieldIvmTrabajador() {
        return fieldIvmTrabajador;
    }

    public JTextField getFieldIvmTotalColones() {
        return fieldIvmTotalColones;
    }

    public JTextField getFieldTotalCCSSPatrono() {
        return fieldTotalCCSSPatrono;
    }

    public JTextField getFieldTotalCCSSTrabajador() {
        return fieldTotalCCSSTrabajador;
    }

    public JTextField getFieldTotalCCSSTotalColones() {
        return fieldTotalCCSSTotalColones;
    }

    public JTextField getFieldBpopPatrono() {
        return fieldBpopPatrono;
    }

    public JTextField getFieldBpopTotalColones() {
        return fieldBpopTotalColones;
    }

    public JTextField getFieldAsignacionesPatrono() {
        return fieldAsignacionesPatrono;
    }

    public JTextField getFieldAsignacionesTotalColones() {
        return fieldAsignacionesTotalColones;
    }

    public JTextField getFieldImasPatrono() {
        return fieldImasPatrono;
    }

    public JTextField getFieldImasTotalColones() {
        return fieldImasTotalColones;
    }

    public JTextField getFieldInaPatrono() {
        return fieldInaPatrono;
    }

    public JTextField getFieldInaTotalColones() {
        return fieldInaTotalColones;
    }

    public JTextField getFieldTotalOtrasInstitucionesPatrono() {
        return fieldTotalOtrasInstitucionesPatrono;
    }

    public JTextField getFieldTotalOtrasInstitucionesTotalColones() {
        return fieldTotalOtrasInstitucionesTotalColones;
    }

    public JTextField getFieldBpopLPTPatrono() {
        return fieldBpopLPTPatrono;
    }

    public JTextField getFieldBpopLPTTrabajador() {
        return fieldBpopLPTTrabajador;
    }

    public JTextField getFieldBpopLPTTotalColones() {
        return fieldBpopLPTTotalColones;
    }

    public JTextField getFieldFclPatrono() {
        return fieldFclPatrono;
    }

    public JTextField getFieldFclTotalColones() {
        return fieldFclTotalColones;
    }

    public JTextField getFieldOpcPatrono() {
        return fieldOpcPatrono;
    }

    public JTextField getFieldOpcTotalColones() {
        return fieldOpcTotalColones;
    }

    public JTextField getFieldInsPatrono() {
        return fieldInsPatrono;
    }

    public JTextField getFieldInsTrabajador() {
        return fieldInsTrabajador;
    }

    public JTextField getFieldInsTotalColones() {
        return fieldInsTotalColones;
    }

    public JTextField getFieldTotalLPTPatrono() {
        return fieldTotalLPTPatrono;
    }

    public JTextField getFieldTotalLPTTrabajador() {
        return fieldTotalLPTTrabajador;
    }

    public JTextField getFieldTotalLPTTotalColones() {
        return fieldTotalLPTTotalColones;
    }

    public JTextField getFieldTotalPorcentajePatrono() {
        return fieldTotalPorcentajePatrono;
    }

    public JTextField getFieldTotalPorcentajeTrabajador() {
        return fieldTotalPorcentajeTrabajador;
    }

    public JTextField getFieldTotalPorcentajeGeneral() {
        return fieldTotalPorcentajeGeneral;
    }

    public JTextField getFieldTotalesPatrono() {
        return fieldTotalesPatrono;
    }

    public JTextField getFieldTotalesTrabajador() {
        return fieldTotalesTrabajador;
    }

    public JTextField getFieldTotalesGeneral() {
        return fieldTotalesGeneral;
    }

    public JButton getBotonCalcular() {
        return botonCalcular;
    }

    public JButton getBotonVolver() {
        return botonVolver;
    }
}
