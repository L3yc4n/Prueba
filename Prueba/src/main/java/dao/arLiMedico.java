package dao;

import dto.Medico;
import java.util.ArrayList;
import java.util.List;

public class arLiMedico {
    
    private List<Medico> lista =new ArrayList<>();
    
    private int ubi=-1;
    public boolean lista_vacia(){
        return lista.isEmpty();
    }
    public void primero(){
        ubi=0;
    }
    public void ultimo(){
        ubi=lista.size()-1;
    }
    public void siguiente(){
        if(ubi<lista.size()-1){
            ubi++;
        }
    }
    public void anterior(){
        if(ubi>0){
            ubi--;
        }
    }
    
    //modificar
    public Medico getMedico(){
        return lista.get(ubi);
    }
    public void setMedico(Medico m){
        lista.set(ubi, m);
    }
    public void agregar(Medico m){
        lista.add(m);
        ubi=lista.size()-1;
    }
    public String imprimir(){
        String imprimir=" ";
        for (Medico medico : lista) {
            imprimir += medico.getCodigo()+" - "+medico.getNombre()+" - "+medico.getApellido()+" - "+medico.getNacimiento()+"\n";
        }
        return imprimir;
    }
    public void eliminar(){
        if(!lista.isEmpty()){
            lista.remove(ubi);
            if(ubi>=lista.size()){
                ubi=lista.size()-1;
            }
        }
    }
}
