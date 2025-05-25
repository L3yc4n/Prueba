package dto;

import java.util.Date;

public class Alumno {
    private int codigo;
    private String nombre;
    private double nota;
    private Date nacimiento;

    public Alumno(int codigo, String nombre, double nota,Date nacimiento) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nota = nota;
        this.nacimiento=nacimiento;
    }

    public Alumno() {
    }

    public Date getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(Date nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }
}
