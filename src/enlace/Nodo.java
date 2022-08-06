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
public class Nodo {
    Object valor;
    Nodo siguiente;
    public Nodo(Object valor){
        this.valor=valor;
        this.siguiente=null;
    }
    public Object obtener_valor(){
        return valor;  
    }
    public void agregar_nodo(Nodo n){
        this.siguiente=n;
    }
    public Nodo obtenerSiguiente(){
        return siguiente;
    }
}
