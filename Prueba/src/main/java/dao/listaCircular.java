package dao;

import dto.Medico;
import dto.Nodo;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class listaCircular {
    Nodo cabeza; //Referencia al primer nodo de la lista

    public listaCircular() {
        this.cabeza = null;
    }
    
    //Metodo para insertar al final de la lista
    public void agregarFinal(Medico medico){
        Nodo nuevoNodo = new Nodo(medico);
        if(cabeza == null){
            cabeza = nuevoNodo; //Si la lista esta vacia, el nuevo nodo se convierte en la cabeza
            nuevoNodo.setSiguiente(cabeza); //El siguiente dek nuevo nodo es el mismo nodo
        } else {
            Nodo actual = cabeza;
            while(actual.getSiguiente() != cabeza){
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevoNodo);  //Enlazamos el último nodo con el nuevo nodo
            nuevoNodo.setSiguiente(cabeza); // El nuevo nodo apunta a la cabeza
        }
    }
    
    //Metodo para eliminar un nodo especifico
    public void eliminarNodo(int codigoMedi){
        if(cabeza == null){
            JOptionPane.showMessageDialog(null, "Tu wbd esta vacia, que vas a eliminar bab...?.");
            return;
        }
        Nodo actual = cabeza;
        Nodo anterior = null;
        //Buscamos el nodo a eliminar
        do{
            Object dato = actual.getDato();
            if(dato instanceof Medico){
                Medico a = (Medico) dato; //Se hace cast si es instancia de medico
                if(a.getCodigo() == codigoMedi){
                    //Si es el unico en la lista 
                    if(actual == cabeza && actual.getSiguiente() == cabeza){
                        cabeza = null;
                    } else {
                        //Si se elimina la cabeza 
                        if(actual == cabeza){
                            anterior = cabeza;
                            while(anterior.getSiguiente() != cabeza){
                                anterior = anterior.getSiguiente();
                            }
                            cabeza = cabeza.getSiguiente(); //Actualizamos la cabeza
                            anterior.setSiguiente(cabeza); //El ultimo nodo apunta a la nueva cabeza
                        } else {
                            anterior.setSiguiente(actual.getSiguiente()); //Eliminar el nodo
                        }
                    }
                    JOptionPane.showMessageDialog(null, "Nodo con código: " + codigoMedi + " ha sido eliminado correctamente.");
                return;
                }
            }
            anterior = actual;
            actual = actual.getSiguiente();
        } while ( actual != cabeza); //Volver al inicio
        JOptionPane.showMessageDialog(null, "Nodo con codigo: " + " " + "no ha sido encontrado.");
    }
    
    //Metodo para mostrar los elementos de la lista
    public void mostrarCircular(){
        if(cabeza == null){
            JOptionPane.showMessageDialog(null, "No hay nada en la lista web...");
            return;
        }
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
        Nodo actual = cabeza;
        String resultado = "Lista Circular - (Medico)\n";
        do{
            Medico a = (Medico) actual.getDato();
            resultado += a.getCodigo() + " - " + a.getNombre() + " - " + a.getApellido() + " - " + sdf.format(a.getNacimiento()) + "\n";
            actual = actual.getSiguiente();
        } while (actual != cabeza);
        resultado += "De nuevo al comienzo en este punto :3";
        JOptionPane.showMessageDialog(null, resultado);
    }
}
