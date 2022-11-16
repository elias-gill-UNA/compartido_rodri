/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package busqueda;

/**
 *
 * @author Admin
 */
public class buscar {
    public static void lineal(double vector[],double valor){
        int i=0;
        int posicion=-1;
        while(i<vector.length){
            if (vector[i]==valor){
                posicion=i;
            }
            i++;
        }
    }
   
public static void busquedabinaria(double vector[],double valor){
        int low_indice=0;
        int high_indice=vector.length-1;
        int posicion=-1;
        while(low_indice<=high_indice){
            int medio_indice=(low_indice+high_indice)/2;
            if(valor==vector[medio_indice]){
                posicion=medio_indice;
                break;
            }else if(valor<vector[medio_indice]){
                high_indice=medio_indice-1;
            }else if(valor>vector[medio_indice]){
                low_indice=medio_indice+1;
            }
        }
        
    }
}
