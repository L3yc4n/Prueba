/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import dao.listaEnlazada;
import dto.Persona;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Enrique
 */
public class FraEnlazada {
    
    listaEnlazada lista = new listaEnlazada();
    
    public void menu() throws ParseException{
        int opc;
        String mensaje = "Menú - Persona\n";
        mensaje += "[1] Agregar \n" +
                "[2] Eliminar FInal\n" +
                "[3] Mostrar Lista\n" +
                "[4] Salir.\n"
                +"Seleccione una opcion: ";
        do{
            opc = Integer.parseInt(JOptionPane.showInputDialog(mensaje));
            switch(opc){
                case 1:
                    agregar();
                    break;
                case 2:
                    lista.eliminarFinal();
                    break;
                case 3:
                    lista.mostrarEnlazada();
                    break;
                case 4:
                    break;
                default: 
                    JOptionPane.showMessageDialog(null, "Valor no definido.");
            }
        } while(opc != 4);
    }
    
    public void agregar() throws ParseException{
        int dni;
        String nombre, apellido;
        Date fecha;
        dni = Integer.parseInt(JOptionPane.showInputDialog("Digite su DNI:"));
        nombre = JOptionPane.showInputDialog("Digite su nombre:");
        apellido = JOptionPane.showInputDialog("Digite su apellido:");
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        fecha = sdf.parse(JOptionPane.showInputDialog("Digite su fecha de nacimiento:"));
        Persona p = new Persona(dni,nombre,apellido,fecha);
        lista.insertarFinal(p);
    }
    
    public static void main(String[] args) throws ParseException {
        FraEnlazada a = new FraEnlazada();
        a.menu();
    }
}
