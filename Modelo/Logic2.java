package Modelo;

import Vista.MenuPrincipal;

public class Logic2 {
    private MenuPrincipal UI;

    public Logic2(MenuPrincipal UI) {
        this.UI = UI;
    }

    public int calcularDiasVacaciones(Empleado empleado) {
        // Lógica para calcular días de vacaciones
        int diasVacaciones = (int) (empleado.getDiasTrabajados() / 365.0 * 12);  // Ejemplo: 1 día por cada 12 días trabajados
        return diasVacaciones;
    }

    public double calcularPagoVacaciones(Empleado empleado) {
        // Lógica para calcular el pago de vacaciones
        double pagoVacaciones = calcularDiasVacaciones(empleado) * empleado.getSalarioDiario();
        return pagoVacaciones;
    }
}
