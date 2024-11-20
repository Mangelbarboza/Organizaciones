package Modelo;

public class Logic3 {
  
    public static double calcularAguinaldo(double salarioMensual, int horasExtrasMensuales, int diasTrabajados) {
        int diasA = 360;  // Según el código de trabajo, deben ser 360 días en un año
        double salarioAnual = (salarioMensual * 12) + (horasExtrasMensuales * 12);  // Se calcula todos los ingresos del empleado
        return (salarioAnual / diasA) * diasTrabajados;  // Fórmula para calcular el aguinaldo según los meses laborados
    }
}
