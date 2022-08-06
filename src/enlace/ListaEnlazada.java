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
public class ListaEnlazada {
    //Toda Lista enlazada cuenta con su nodo cabeza
    Nodo cabeza;
    public ListaEnlazada(){
        this.cabeza=null;// El Nodo Cabeza es Nulo por Defecto
    }
    // Metodo para añadir elementos de cualquier tipo a la lista enlazada
    public void anhadir(Object elemento){
        if (cabeza==null){
            cabeza=new Nodo(elemento);
        } else{
            Nodo temp=cabeza;
            Nodo nuevo=new Nodo(elemento);
            nuevo.agregar_nodo(temp);
            this.cabeza=nuevo;
        }
    }
    //meotodo para mostrar todos los elementos de la lista enlazada
    public void listar(){
        Nodo temporal=cabeza;
        while (temporal.obtenerSiguiente()!=null){
            System.out.println(temporal.obtener_valor());
            temporal=temporal.obtenerSiguiente();
        }
        System.out.println(temporal.obtener_valor());
    }
    
}
