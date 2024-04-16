package org.example.Personas;

public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private int anioNacimiento;
    private int salario;
    private double coeficiente;

    public Persona(int id, String nombre, String apellido, int anioNacimiento,
                   int salario, double coeficiente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.anioNacimiento = anioNacimiento;
        this.salario = salario;
        this.coeficiente = coeficiente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getAnioNacimiento() {
        return anioNacimiento;
    }

    public void setAnioNacimiento(int anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public double getCoeficiente() {
        return coeficiente;
    }

    public void setCoeficiente(double coeficiente) {
        this.coeficiente = coeficiente;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", salario=" + salario +
                ", coeficiente=" + coeficiente +
                '}';
    }
}
