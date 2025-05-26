
package gui;

import dao.listaCircular;
import dto.Medico;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class FraCircular {
    SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yy");
    listaCircular li=new listaCircular();
    
    public void menu() throws ParseException{
        int opc;
        String mensaje="medico: \n";
        mensaje +=  "[1] Agregar \n"
                + "[2] mostrar \n"
                + "[3] eliminar solo el ultimo\n"
                + "[4] Salir.\n"
                + "seleccione una opcion: ";
        do{
            opc=Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch(opc){
                case 1:
                      int codigo = Integer.parseInt(JOptionPane.showInputDialog("ingrese el codigo: "));
                        String nombre = JOptionPane.showInputDialog("ingrese el nombre: ");
                        String apellido = JOptionPane.showInputDialog("ingrese el apellido: ");
                        //double nota = Double.parseDouble(JOptionPane.showInputDialog("ingrese la nota: "));
                        Date nacimiento = sdf.parse(JOptionPane.showInputDialog("ingrese la fecha: \t con este formato: dd/mm/aa"));
                        Medico medico = new Medico( nombre,  apellido,  nacimiento,  codigo);
                        li.agregarFinal(medico);
                    break;
                case 2:
                   li.mostrarCircular();
                    break;
                case 3:
                     int codigoEliminar = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el código a eliminar: "));
                    li.eliminarNodo(codigoEliminar);
                    break;
                case 4:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "yo solo veo 4 NUMEROS y pones otro numero? enserio?");
                    break;
                            
        }
            
            
        }while(opc!=4);
    }
    
    
    
    
    
    public static void main(String[] args) throws ParseException {
        FraCircular a=new FraCircular();
        a.menu();
    }
    
}
