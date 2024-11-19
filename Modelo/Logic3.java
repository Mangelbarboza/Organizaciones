package Modelo;

public class Logic3 {
  
    public static double calcularAguinaldo(double salarioMensual, int horasExtrasMensuales, int diasTrabajados) {
        int diasA= 360; //Según el codigo de trabajo tienen que ser 360
        double salarioAnual = (salarioMensual * 12) + (horasExtrasMensuales * 12); //se calcula todos los ingresos del empleado
        return (salarioAnual / diasA) * diasTrabajados; //formula para calcular el aguinaldo según los meses laborados del empleadop
    }
    
    }

