/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import dto.Nodo;
import dto.Persona;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class listaEnlazada {
    private Nodo cabeza;

    public listaEnlazada() {
        this.cabeza = null;
    }
    
    //Metodo para insertar al final
    public void insertarFinal(Persona persona){
        Nodo nuevoNodo = new Nodo(persona);
        if(cabeza == null){
            cabeza = nuevoNodo; // Si la lista esta vacia, el nuevo nodo se convierte en la cabeza
        } else {
            Nodo actual = cabeza;
            //Recordamos hasta el último nodo
            while(actual.getSiguiente() != null){
                actual = actual.getAnterior();
            } 
            actual.setSiguiente(nuevoNodo); //Enlazamos el ultimo nodo con el nuevo nodo
        }
    }
    
    //Metodo para eliminar el ultimo nodo
    public void eliminarFinal(){
        if(cabeza == null){
            JOptionPane.showMessageDialog(null, "La lista esta Vacia, no hay nada que eliminar OE");
        } else if(cabeza.getSiguiente() == null) {
            //Si hay un solo nodo, lo eliminamos y la lista queda vacia
            cabeza = null;
            JOptionPane.showMessageDialog(null, "La lista se ha vaciado como el amor de ella MIGAJERO");
        } else {
            Nodo actual = cabeza;
            //Recorremos hasta el ultimo nodo 
            while(actual.getSiguiente().getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            //El ultimo nodo es el actual, lo eliminamos
            actual.setSiguiente(null);
            JOptionPane.showMessageDialog(null, "Se elimino el ultimo elemento UwU");
        }
    }
    
    //Metodo para mostrar la lista
    public void mostrarEnlazada(){
        if(cabeza == null){
            JOptionPane.showMessageDialog(null, "La lista esta Vacia, no hay nada que mostrar BAB...");
            return;
        } 
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
        Nodo actual = cabeza;
        String mensaje = "Lista Enlazada - Persona\n";
        while(actual != null){
            Persona a = (Persona) actual.getDato();
            mensaje += a.getDni() + " - " + a.getNombre() + " - " + a.getApellido() + " - " + sdf.format(a.getNacimiento()) + "\n";
            actual = actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, mensaje);
    }
}
