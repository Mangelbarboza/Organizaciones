package Modelo;

import Vista.MenuPrincipal;

public class Logic2 {
    private MenuPrincipal UI;

    public Logic2(MenuPrincipal UI) {
        this.UI = UI;
    }

    public int calcularDiasVacaciones(Empleado empleado) {
        // 1 día de vacaciones por cada 26 días trabajados
        int diasVacaciones = empleado.getDiasTrabajados() / 26;
        return diasVacaciones;
    }

    public double calcularPagoVacaciones(Empleado empleado) {
        // Lógica para calcular el pago de vacaciones
        double pagoVacaciones = calcularDiasVacaciones(empleado) * empleado.getSalarioDiario();

    
        // Para verificar en consola durante pruebas
        System.out.println("Días de Vacaciones: " + calcularDiasVacaciones(empleado));
        System.out.println("Salario Diario: " + empleado.getSalarioDiario());
        System.out.println("Pago Vacaciones: " + pagoVacaciones);

        return pagoVacaciones;
    }
}
