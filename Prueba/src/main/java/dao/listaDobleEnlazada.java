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
        nuevonodo.setSiguiente(actual);
    }
    
    }
    
    public void mostrar (Alumno alumno){
        if(cabeza==null){
            JOptionPane.showMessageDialog(null, "que vas ps, si no hay nada");
            return;
        }
      Nodo actual=cabeza;
        SimpleDateFormat sdf =new SimpleDateFormat ("dd/mm/yy");
        String resultado="alumno: \n";
        resultado +="codigo-nombre-nota-nacimiento\n";
        while(actual!=null){
            Alumno a= (Alumno)actual.getDato();
           resultado += a.getCodigo()+" - "+a.getNombre()+" - "+a.getNota()+" - "+ sdf.format(a.getNacimiento())+"\n";
           actual=actual.getSiguiente();
        }
        JOptionPane.showMessageDialog(null, resultado);
    }
    
}//FINAL
