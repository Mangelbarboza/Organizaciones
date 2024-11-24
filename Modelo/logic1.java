
package Modelo;

import Vista.SalarioNetoPanel;

public class logic1 {
    private SalarioNetoPanel UI;

    public logic1(SalarioNetoPanel UI) {
        this.UI = UI;
    }

    public void calcularSalarioNeto() {
        try {
            // Obtener salario bruto desde la UI
            double salarioBruto = Double.parseDouble(UI.getFieldSalarioBruto().getText());

            // CCSS
            double semPatrono = salarioBruto * 0.0925; // SEM
            double semTrabajador = salarioBruto * 0.0550;
            double ivmPatrono = salarioBruto * 0.0542; // IVM
            double ivmTrabajador = salarioBruto * 0.0417;

            double totalCCSSPatrono = semPatrono + ivmPatrono;
            double totalCCSSTrabajador = semTrabajador + ivmTrabajador;
            double totalCCSSTotalColones = totalCCSSPatrono + totalCCSSTrabajador;

            // Otras Instituciones
            double bpopPatrono = salarioBruto * 0.0025; // Banco Popular
            double asignaciones = salarioBruto * 0.05; // Asignaciones Familiares
            double imas = salarioBruto * 0.005; // IMAS
            double ina = salarioBruto * 0.015; // INA
            double totalOtrasInstituciones = bpopPatrono + asignaciones + imas + ina;

            // Ley de Protección al Trabajador
            double bpopLPTPatrono = salarioBruto * 0.0025; // LPT Banco Popular
            double bpopLPTTrabajador = salarioBruto * 0.01;
            double fclPatrono = salarioBruto * 0.015; // FCL
            double opcPatrono = salarioBruto * 0.02; // OPC
            double insPatrono = salarioBruto * 0.01; // INS
            double insTrabajador = salarioBruto * 0.01;
            double totalLPTPatrono = bpopLPTPatrono + fclPatrono + opcPatrono + insPatrono;
            double totalLPTTrabajador = bpopLPTTrabajador + insTrabajador;
            double totalLPTTotalColones = totalLPTPatrono + totalLPTTrabajador;

            // Resumen Totales
            double totalPorcentajePatrono = 0.1467 + 0.0725 + 0.0475; // Suma de porcentajes patrono
            double totalPorcentajeTrabajador = 0.0967 + 0.01; // Suma de porcentajes trabajador
            double totalPorcentajeGeneral = totalPorcentajePatrono + totalPorcentajeTrabajador;

            double totalColonesPatrono = totalCCSSPatrono + totalOtrasInstituciones + totalLPTPatrono;
            double totalColonesTrabajador = totalCCSSTrabajador + totalLPTTrabajador;
            double totalColonesGeneral = totalColonesPatrono + totalColonesTrabajador;

            // Actualizar valores en la UI para CCSS
            UI.getFieldSemPatrono().setText(String.format("%.2f", semPatrono));
            UI.getFieldSemTrabajador().setText(String.format("%.2f", semTrabajador));
            UI.getFieldSemTotalColones().setText(String.format("%.2f", semPatrono + semTrabajador));

            UI.getFieldIvmPatrono().setText(String.format("%.2f", ivmPatrono));
            UI.getFieldIvmTrabajador().setText(String.format("%.2f", ivmTrabajador));
            UI.getFieldIvmTotalColones().setText(String.format("%.2f", ivmPatrono + ivmTrabajador));

            UI.getFieldTotalCCSSPatrono().setText(String.format("%.2f", totalCCSSPatrono));
            UI.getFieldTotalCCSSTrabajador().setText(String.format("%.2f", totalCCSSTrabajador));
            UI.getFieldTotalCCSSTotalColones().setText(String.format("%.2f", totalCCSSTotalColones));

            // Actualizar valores en la UI para Otras Instituciones
            UI.getFieldBpopPatrono().setText(String.format("%.2f", bpopPatrono));
            UI.getFieldBpopTotalColones().setText(String.format("%.2f", bpopPatrono));

            UI.getFieldAsignacionesPatrono().setText(String.format("%.2f", asignaciones));
            UI.getFieldAsignacionesTotalColones().setText(String.format("%.2f", asignaciones));

            UI.getFieldImasPatrono().setText(String.format("%.2f", imas));
            UI.getFieldImasTotalColones().setText(String.format("%.2f", imas));

            UI.getFieldInaPatrono().setText(String.format("%.2f", ina));
            UI.getFieldInaTotalColones().setText(String.format("%.2f", ina));

            UI.getFieldTotalOtrasInstitucionesPatrono().setText(String.format("%.2f", totalOtrasInstituciones));
            UI.getFieldTotalOtrasInstitucionesTotalColones().setText(String.format("%.2f", totalOtrasInstituciones));

            // Actualizar valores en la UI para Ley de Protección al Trabajador
            UI.getFieldBpopLPTPatrono().setText(String.format("%.2f", bpopLPTPatrono));
            UI.getFieldBpopLPTTrabajador().setText(String.format("%.2f", bpopLPTTrabajador));
            UI.getFieldBpopLPTTotalColones().setText(String.format("%.2f", bpopLPTPatrono + bpopLPTTrabajador));

            UI.getFieldFclPatrono().setText(String.format("%.2f", fclPatrono));
            UI.getFieldFclTotalColones().setText(String.format("%.2f", fclPatrono));

            UI.getFieldOpcPatrono().setText(String.format("%.2f", opcPatrono));
            UI.getFieldOpcTotalColones().setText(String.format("%.2f", opcPatrono));

            UI.getFieldInsPatrono().setText(String.format("%.2f", insPatrono));
            UI.getFieldInsTrabajador().setText(String.format("%.2f", insTrabajador));
            UI.getFieldInsTotalColones().setText(String.format("%.2f", insPatrono + insTrabajador));

            UI.getFieldTotalLPTPatrono().setText(String.format("%.2f", totalLPTPatrono));
            UI.getFieldTotalLPTTrabajador().setText(String.format("%.2f", totalLPTTrabajador));
            UI.getFieldTotalLPTTotalColones().setText(String.format("%.2f", totalLPTTotalColones));

            // Actualizar valores en la UI para Resumen
            UI.getFieldTotalPorcentajePatrono().setText(String.format("%.2f", totalPorcentajePatrono * 100));
            UI.getFieldTotalPorcentajeTrabajador().setText(String.format("%.2f", totalPorcentajeTrabajador * 100));
            UI.getFieldTotalPorcentajeGeneral().setText(String.format("%.2f", totalPorcentajeGeneral * 100));

            UI.getFieldTotalesPatrono().setText(String.format("%.2f", totalColonesPatrono));
            UI.getFieldTotalesTrabajador().setText(String.format("%.2f", totalColonesTrabajador));
            UI.getFieldTotalesGeneral().setText(String.format("%.2f", totalColonesGeneral));

        } catch (NumberFormatException e) {
            System.err.println("Error: Asegúrese de ingresar un valor numérico válido para el salario bruto.");
        }
    }
}
