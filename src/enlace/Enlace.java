/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enlace;

/**
 *
 * @author Admin
 */
public class Enlace {

    
    public static void main(String[] args){
        ListaEnlazada lista=new ListaEnlazada();
        ListaEnlazada lista2=new ListaEnlazada();
        lista2.anhadir(23);
        lista2.anhadir("Elias se pudo KAPE");
        lista.anhadir("Elias");
        lista.anhadir(45);
        lista.anhadir(80);
        lista.anhadir("Rodri");
        lista.anhadir(lista2);
        lista.listar();
    }
    
}
