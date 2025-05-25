
package gui;

import dto.Alumno;
import dao.listaDobleEnlazada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class FraDobEnlazada {
    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
        
        listaDobleEnlazada li=new listaDobleEnlazada();
     
        int cantidad= Integer.parseInt(JOptionPane.showInputDialog("cuantos alumnos desea agregar?"));
        for (int i = 0; i < cantidad; i++) {
            int codigo=Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo: "));
            String nombre=JOptionPane.showInputDialog("ingrese el nombre: ");
            double nota=Double.parseDouble(JOptionPane.showInputDialog("ingrese la nota: "));
            Date nacimiento=sdf.parse(JOptionPane.showInputDialog("ingrese la fecha: \t con este formato: dd/mm/aa"));
            Alumno alumno = new Alumno(codigo, nombre, nota, nacimiento);
                li.agregar(alumno);
        }
       li.mostrar();
        
    }
}
