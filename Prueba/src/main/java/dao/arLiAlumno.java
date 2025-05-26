/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Alumno;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Enrique
 */
public class arLiAlumno {
    private List<Alumno> lista = new ArrayList<>();
    private int ubicacion = -1;
    
    public void agregar(Alumno a){
        lista.add(a);
        ubicacion = lista.size()-1;
    }
    
    public String imprimir(){
        String resultado = "Lista - Alumno \n";
        for (Alumno alumno : lista) {
            SimpleDateFormat sdf = new SimpleDateFormat();
            resultado = alumno.getCodigo() + " - " + alumno.getNombre() + " - " + sdf.format(alumno.getNacimiento()) + " - " + alumno.getNota() + "\n";
        }
        return resultado;
    }
    
    public void primero(){
        ubicacion = 0;
    }
    
    public void anterior(){
        if(ubicacion > 0){
            ubicacion--;
        }
    }
    
    public void siguiente(){
        if(ubicacion < lista.size()-1){
            ubicacion++;
        }
    }
    
    public void ultimo(){
        ubicacion = lista.size() - 1;
    }
    
    public Alumno getAlumno(){
        if(ubicacion >= 0 && ubicacion < lista.size()-1) return lista.get(ubicacion);
        return null;
    }
    
    public void setAlumno(Alumno a){
        lista.set(ubicacion, a);
        
    }
    
    public boolean esVacio(){
        return lista.isEmpty();
    }
    
    public void eliminar(){
        if(!esVacio()){
            lista.remove(ubicacion);
        }
        if(ubicacion >= lista.size()-1){
            ubicacion = lista.size() - 1;
        }
    }
}