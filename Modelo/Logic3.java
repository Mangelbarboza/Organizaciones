package Modelo;

public class Logic3 {
    /*private static final int DIAS_VACACIONES_ANUAL = 12; // Días de vacaciones por año
    private static final int DIAS_POR_ANO = 360; // Días laborales por año (sin contar fines de semana)
    private static final int MESES_POR_ANO = 12;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Entrada de datos
        System.out.print("Ingrese el salario mensual: ");
        double salarioMensual = scanner.nextDouble();

        System.out.print("Ingrese la cantidad de días trabajados: ");
        int diasTrabajados = scanner.nextInt();

        System.out.print("Ingrese la cantidad de años trabajados: ");
        int anosTrabajados = scanner.nextInt();

        // Cálculo de vacaciones
        int diasVacaciones = calcularDiasVacaciones(diasTrabajados);
        double pagoVacaciones = calcularPagoVacaciones(salarioMensual, diasVacaciones);

        // Cálculo de aguinaldo
        double aguinaldo = calcularAguinaldo(salarioMensual, diasTrabajados);

        // Cálculo de liquidación (preaviso y cesantía)
        double preaviso = calcularPreaviso(salarioMensual, anosTrabajados);
        double cesantia = calcularCesantia(salarioMensual, anosTrabajados);

        // Mostrar resultados
        System.out.println("Días de Vacaciones: " + diasVacaciones);
        System.out.println("Pago por Vacaciones: " + pagoVacaciones);
        System.out.println("Aguinaldo: " + aguinaldo);
        System.out.println("Preaviso: " + preaviso);
        System.out.println("Cesantía: " + cesantia);

        scanner.close();
    }

    // Método para calcular los días de vacaciones
    public static int calcularDiasVacaciones(int diasTrabajados) {
        return (diasTrabajados * DIAS_VACACIONES_ANUAL) / DIAS_POR_ANO;
    }

    // Método para calcular el pago de vacaciones
    public static double calcularPagoVacaciones(double salarioMensual, int diasVacaciones) {
        double salarioDiario = salarioMensual / 30;
        return salarioDiario * diasVacaciones;
    }

    // Método para calcular el aguinaldo
    public static double calcularAguinaldo(double salarioMensual, int diasTrabajados) {
        double salarioAnual = salarioMensual * MESES_POR_ANO;
        return (salarioAnual / DIAS_POR_ANO) * diasTrabajados;
    }

    // Método para calcular el preaviso
    public static double calcularPreaviso(double salarioMensual, int anosTrabajados) {
        if (anosTrabajados < 1) {
            return salarioMensual * 0.5; // Medio mes de salario para menos de 1 año
        } else if (anosTrabajados >= 1 && anosTrabajados < 5) {
            return salarioMensual; // Un mes de salario para 1 a 5 años
        } else {
            return salarioMensual * 1.5; // Mes y medio de salario para más de 5 años
        }
    }

    // Método para calcular la cesantía
    public static double calcularCesantia(double salarioMensual, int anosTrabajados) {
        if (anosTrabajados < 1) {
            return 0;
        } else if (anosTrabajados >= 1 && anosTrabajados <= 5) {
            return salarioMensual * anosTrabajados; // Un mes por año trabajado entre 1 y 5 años
        } else {
            return salarioMensual * 5 + (salarioMensual * 2 * (anosTrabajados - 5)); // Dos meses por año adicional después de 5 años
        }
    } */
}
