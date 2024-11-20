package Modelo;

public class Logic3 {
  
    public static double calcularAguinaldo(double salarioMensual, double horasExtrasMensuales, int mesesTrabajados) {
        // Calcular el ingreso mensual total (salario base más horas extras)
        double ingresoMensualTotal = salarioMensual + horasExtrasMensuales;
        
        // Calcular los ingresos devengados en función de los meses trabajados
        double ingresosAnuales = ingresoMensualTotal * mesesTrabajados;
    
        // Calcular el aguinaldo como la doceava parte de los ingresos anuales
        return ingresosAnuales / 12;
    }
    
}
