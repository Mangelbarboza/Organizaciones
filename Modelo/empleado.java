package modelo;

public class Empleado {
    // Información personal
    private String nombre;
    private String cedula;

    // Información laboral
    private String puesto;
    private String fechaIngreso;

    // Atributos para cálculos 
    private double salarioDiario;
    private double salarioMensual;
    private double salarioBruto; 
    private int aniosTrabajados;
    private int diasTrabajados;
    private double horasExtras;
    private boolean aplicaRenta;

    // Constructor
    public Empleado(String nombre, String cedula, String puesto, String fechaIngreso, 
                    double salarioDiario, double salarioMensual, double salarioBruto, 
                    int aniosTrabajados, int diasTrabajados, double horasExtras, boolean aplicaRenta) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.puesto = puesto;
        this.fechaIngreso = fechaIngreso;
        this.salarioDiario = salarioDiario;
        this.salarioMensual = salarioMensual;
        this.salarioBruto = salarioBruto;
        this.aniosTrabajados = aniosTrabajados;
        this.diasTrabajados = diasTrabajados;
        this.horasExtras = horasExtras;
        this.aplicaRenta = aplicaRenta;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getPuesto() { return puesto; }
    public void setPuesto(String puesto) { this.puesto = puesto; }

    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String fechaIngreso) { this.fechaIngreso = fechaIngreso; }

    public double getSalarioBruto() { return salarioBruto; }
    public void setSalarioBruto(double salarioBruto) { this.salarioBruto = salarioBruto; }

    public double getSalarioDiario() { return salarioDiario; }
    public void setSalarioDiario(double salarioDiario) { this.salarioDiario = salarioDiario; }

    public double getSalarioMensual() { return salarioMensual; }
    public void setSalarioMensual(double salarioMensual) { this.salarioMensual = salarioMensual; }

    public int getAniosTrabajados() { return aniosTrabajados; }
    public void setAniosTrabajados(int aniosTrabajados) { this.aniosTrabajados = aniosTrabajados; }

    public int getDiasTrabajados() { return diasTrabajados; }
    public void setDiasTrabajados(int diasTrabajados) { this.diasTrabajados = diasTrabajados; }

    public double getHorasExtras() { return horasExtras; }
    public void setHorasExtras(double horasExtras) { this.horasExtras = horasExtras; }

    public boolean isAplicaRenta() { return aplicaRenta; }
    public void setAplicaRenta(boolean aplicaRenta) { this.aplicaRenta = aplicaRenta; }
}
