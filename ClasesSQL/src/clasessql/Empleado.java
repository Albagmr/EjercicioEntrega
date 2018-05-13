package clasessql;

import java.sql.Date;

/**
 *
 * @author Alba
 */
public class Empleado {

    private int numEmpleado;
    private String apellido;
    private String oficio;
    private int director;
    private Date fechaAlt;
    private float salario;
    private float comision;
    private int numeroDepartamento;

    /**
     * Constructor vacío
     */

    public Empleado() {
    }

    /**
     * Constructor lleno
     */
    public Empleado(int numEmpleado, String apellido, String oficio, int director, Date fechaAlt, float salario, float comision, int numeroDepartamento) {
        this.numEmpleado = numEmpleado;
        this.apellido = apellido;
        this.oficio = oficio;
        this.director = director;
        this.fechaAlt = fechaAlt;
        this.salario = salario;
        this.comision = comision;
        this.numeroDepartamento = numeroDepartamento;
    }

// creamos los getters y los setters
    public int getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(int numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDirector() {
        return director;
    }

    public void setDirector(int director) {
        this.director = director;
    }

    public Date getFechaAlt() {
        return fechaAlt;
    }

    public void setFechaAlt(Date fechaAlt) {
        this.fechaAlt = fechaAlt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getNumeroDepartamento() {
        return numeroDepartamento;
    }

    public void setNumeroDepartamento(int numeroDepartamento) {
        this.numeroDepartamento = numeroDepartamento;
    }

    public void create() {

    }
}
