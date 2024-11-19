package Modelo;

public class Logic3 {
  
    public static double calcularAguinaldo(double salarioMensual, double horasExtrasMensuales, int diasTrabajados) {
        int diasA= 360; 
        double salarioAnual = (salarioMensual * 12) + (horasExtrasMensuales * 12);
        return (salarioAnual / diasA) * diasTrabajados;
    }
    
    }

