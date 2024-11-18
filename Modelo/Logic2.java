package modelo;

public class Logic2 {
    
    private static final int DIAS_VACACIONES_ANUAL = 12; //los dias de vacaciones por año completo
    private static final int DIAS_POR_ANIO = 360; //excluyendo fines de semana y feriados

    //Calculamos dias de vacaciones 
    public static int calcularDiasVacaciones(Empleado empleado){
        //usamos el diasTrabajados de empleado
        return (empleado.getDiasTrabajados()*DIAS_VACACIONES_ANUAL)/DIAS_POR_ANIO; 
    }

    //Metodo para calcular el pago de vacaciones
    public static double calcularPagoVaciones(Empleado empleado){
        //putos del empleado atributo salarioMensual
        double salarioDiario = empleado.getSalarioMensual()/30; //suponiendo 30 días en un mes
        int diasVacaciones = calcularDiasVacaciones(empleado);
        return salarioDiario * diasVacaciones; 
    }
}
