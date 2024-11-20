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

            // Calcular cargas sociales
            double cargasSociales = calcularCargasSociales(salarioBruto);

            // Calcular renta si aplica
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
        double porcentajeCargasSociales = 0.09; // 9% como ejemplo, ajustar según la ley
        return salarioBruto * porcentajeCargasSociales;
    }

    // Método para calcular la renta deducida si aplica, según el salario bruto
    private double calcularRenta(double salarioBruto) {
        double porcentajeRenta = 0.15; // 15% como ejemplo, ajustar según la normativa vigente
        boolean aplicaRenta = salarioBruto > 500000; // ejemplo: renta aplicable a salarios mayores a ₡500,000
        return aplicaRenta ? salarioBruto * porcentajeRenta : 0.0;
    }
}
