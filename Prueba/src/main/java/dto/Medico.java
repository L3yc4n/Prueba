package dto;

import java.util.Date;

public class Medico {
    private String nombre;
    private String apellido;
    private Date nacimiento;
    private int codigo;

    public Medico() {
    }

    public Medico(String nombre, String apellido, Date nacimiento, int codigo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
        this.codigo = codigo;
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
    
    
    
}
