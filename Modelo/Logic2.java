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
        // Dividir el salario mensual entre 30 y multiplicar por los días de vacaciones
        double salarioDiario = empleado.getSalarioMensual() / 30;
        double pagoVacaciones = calcularDiasVacaciones(empleado) * salarioDiario;

        // Para verificar en consola durante pruebas
        System.out.println("Días de Vacaciones: " + calcularDiasVacaciones(empleado));
        System.out.println("Salario Diario: " + salarioDiario);
        System.out.println("Pago Vacaciones: " + pagoVacaciones);

        return pagoVacaciones;
    }
}
