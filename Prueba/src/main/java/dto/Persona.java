
package dto;

import java.util.Date;

public class Persona {
    private int dni;
    private String nombre;
    private String apellido;
    private Date nacimiento;

    public Persona() {
    }

    public Persona(int dni, String nombre, String apellido, Date nacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacimiento = nacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
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
    
    
}
