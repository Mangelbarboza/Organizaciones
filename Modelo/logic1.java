package Modelo;

import Vista.MenuPrincipal;

public class logic1 {
    private MenuPrincipal UI;

    public logic1(MenuPrincipal UI) {
        this.UI = UI;
    }

    public double calcularSalarioNeto(Empleado empleado) {
        // Aquí implementaríamos el cálculo de deducciones y cargas sociales, si aplica renta
        double salarioNeto = empleado.getSalarioBruto();

        // Ejemplo de deducciones, ajustar con los valores correctos según la ley de Costa Rica
        double cargasSociales = salarioNeto * 0.09;  // Ejemplo: 9% de cargas sociales
        double renta = empleado.isAplicaRenta() ? salarioNeto * 0.15 : 0.0;  // Ejemplo: 15% si aplica renta

        return salarioNeto - cargasSociales - renta;
    }
}
