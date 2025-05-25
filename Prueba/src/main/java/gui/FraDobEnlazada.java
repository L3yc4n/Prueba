package gui;

import dto.Alumno;
import dao.listaDobleEnlazada;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class FraDobEnlazada {

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    listaDobleEnlazada li = new listaDobleEnlazada();

    public void menu() throws ParseException {
        int opc;
        String mensaje = "Menu\n";
        mensaje += "[1] Agregar \n"
                + "[2] mostra \n"
                + "[3] eliminar solo el ultimo\n"
                + "[4] Salir.\n"
                + "seleccione una opcion: ";
        do {
            opc = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch (opc) {
                case 1:
                   
       //             for (int i = 0; i < cantidad; i++) {
                        int codigo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo: "));
                        String nombre = JOptionPane.showInputDialog("ingrese el nombre: ");
                        double nota = Double.parseDouble(JOptionPane.showInputDialog("ingrese la nota: "));
                        Date nacimiento = sdf.parse(JOptionPane.showInputDialog("ingrese la fecha: \t con este formato: dd/mm/aa"));
                        Alumno alumno = new Alumno(codigo, nombre, nota, nacimiento);
                        li.agregar(alumno);
         //           }
                    break;
                case 2:
                    li.mostrar();
                    break;
                case 3:
                    li.eliminarFinal();
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "ingrese un numero correcto");
                    break;
            }
        } while (opc != 4);
    }

    public static void main(String[] args) throws ParseException{

FraDobEnlazada nose=new FraDobEnlazada();
nose.menu();

    }
}
