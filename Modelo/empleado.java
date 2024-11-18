package modelo;

public class Empleado {
    // Atributos  para los cálculos
    private double salarioDiario;
    private double salarioMensual;
    private int aniosTrabajados;
    private int diasTrabajados;
    private double horasExtras;
    private boolean aplicaRenta;

    
    public Empleado(double salarioDiario, double salarioMensual, int aniosTrabajados, int diasTrabajados, double horasExtras, boolean aplicaRenta) {
        this.salarioDiario = salarioDiario;
        this.salarioMensual = salarioMensual;
        this.aniosTrabajados = aniosTrabajados;
        this.diasTrabajados = diasTrabajados;
        this.horasExtras = horasExtras;
        this.aplicaRenta = aplicaRenta;
    }

    
    public double getSalarioDiario() {
        return salarioDiario;
    }

    public void setSalarioDiario(double salarioDiario) {
        this.salarioDiario = salarioDiario;
    }

    public double getSalarioMensual() {
        return salarioMensual;
    }

    public void setSalarioMensual(double salarioMensual) {
        this.salarioMensual = salarioMensual;
    }

    public int getAniosTrabajados() {
        return aniosTrabajados;
    }

    public void setAniosTrabajados(int aniosTrabajados) {
        this.aniosTrabajados = aniosTrabajados;
    }

    public int getDiasTrabajados() {
        return diasTrabajados;
    }

    public void setDiasTrabajados(int diasTrabajados) {
        this.diasTrabajados = diasTrabajados;
    }

    public double getHorasExtras() {
        return horasExtras;
    }

    public void setHorasExtras(double horasExtras) {
        this.horasExtras = horasExtras;
    }

    public boolean isAplicaRenta() {
        return aplicaRenta;
    }

    public void setAplicaRenta(boolean aplicaRenta) {
        this.aplicaRenta = aplicaRenta;
    }
}
