package dao;
import dto.Nodo;
import dto.Alumno;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;

public class listaDobleEnlazada {
    Nodo cabeza;

    public listaDobleEnlazada() {
        this.cabeza = null;
    }
    
    public void agregar(Alumno alumno){
    Nodo nuevonodo=new Nodo(alumno);
    if(cabeza==null){
        cabeza=nuevonodo;
    } else {
        Nodo actual=cabeza;
        while(actual.getSiguiente()!=null){
            actual=actual.getSiguiente();
        }
        actual.setSiguiente(nuevonodo);
        nuevonodo.setAnterior(actual);
    }
    
    }
    
    public void mostrar (){
        if(cabeza==null){
            JOptionPane.showMessageDialog(null, "que vas a mostrar ps, si no hay nada");
            return;
        }
      Nodo actual=cabeza;
        SimpleDateFormat sdf =new SimpleDateFormat ("dd/MM/yy");
        String resultado="alumno: \n";
        resultado +="codigo-nombre-nota-nacimiento\n";
        while(actual!=null){
            Alumno a= (Alumno)actual.getDato();
           resultado += a.getCodigo()+" - "+a.getNombre()+" - "+a.getNota()+" - "+ sdf.format(a.getNacimiento())+"\n";
           actual=actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public void eliminarFinal(){
        if(cabeza == null){
            JOptionPane.showMessageDialog(null, "Esta vacio que mas quieres eliminar?");
        } else if(cabeza.getSiguiente() == null) { //este es por si solo hay un elemento
            cabeza = null;
            JOptionPane.showMessageDialog(null, "La lista se ha vaciado , ahora si no hay nada de nada");
        } else {
            Nodo actual = cabeza; //Recorremos hasta el ultimo nodo 
            while(actual.getSiguiente() != null){
                actual = actual.getSiguiente();
            }
            actual.getAnterior().setSiguiente(null); //El ultimo nodo es el actual, lo eliminamos
        }
    }
    
    
}//FINAL
