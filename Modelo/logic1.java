package Modelo;

import Vista.SalarioNetoPanel;

public class logic1 {
    private SalarioNetoPanel UI;

    public logic1(SalarioNetoPanel UI) {
        this.UI = UI;
    }

    public void calcularSalarioNeto() {
        try {
            // Obtener datos de entrada desde la UI
            double salarioBruto = Double.parseDouble(UI.getFieldSalarioBruto().getText());
            int diasTrabajados = Integer.parseInt(UI.getFieldDiasTrabajados().getText());
            int horasExtras = Integer.parseInt(UI.getFieldHoras().getText());

            // Calcular cargas sociales con el porcentaje de 10.67%
            double cargasSociales = calcularCargasSociales(salarioBruto);

            // Calcular renta si aplica, con un porcentaje ajustado según la normativa vigente
            double rentaDeducida = calcularRenta(salarioBruto);

            // Calcular salario neto
            double salarioNeto = salarioBruto - cargasSociales - rentaDeducida;

            // Mostrar resultados en la UI
            UI.getFieldSalarioNetoCalculado().setText(String.format("%.2f", salarioNeto));
            UI.getFieldCargasSociales().setText(String.format("%.2f", cargasSociales));
            UI.getFieldRentaDeducida().setText(String.format("%.2f", rentaDeducida));

        } catch (NumberFormatException e) {
            System.err.println("Error: Asegúrese de ingresar valores numéricos válidos.");
        }
    }

    // Método para calcular las cargas sociales según el salario bruto
    private double calcularCargasSociales(double salarioBruto) {
        double porcentajeCargasSociales = 0.1067; // 10.67% basado en la imagen proporcionada
        return salarioBruto * porcentajeCargasSociales;
    }

    // Método para calcular la renta deducida si aplica, según el salario bruto
    private double calcularRenta(double salarioBruto) {
        double porcentajeRenta = 0.10; // Ajustar según el umbral actual de renta
        boolean aplicaRenta = salarioBruto > 500000; // ejemplo: renta aplicable a salarios mayores a ₡500,000
        return aplicaRenta ? salarioBruto * porcentajeRenta : 0.0;
    }
}
