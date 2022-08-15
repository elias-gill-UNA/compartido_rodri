La "libreria" se compone de tres Structs principales: "Lista", "Dato" y "Nodo".
- Lista: es la lista enlazada propiamente dicha. Contiene la referencia a un nodo cabeza de tipo "Nodo".
- Nodo: representa un nodo de la lista enlazada. Contiene un dato de tipo "Dato" y la referencia a un nodo "siguiente"
- Dato: es la estructura que contiene los distintos tipos de datos. Contiene una variable de tipo numerico(float), una de
  tipo string y una de tipo listaEnlazada.

## Para la creacion datos
- nuevaLista(): retorna un puntero a una nueva lista enlazada

#### Para crear los datos a ser inserttados en los nodos
Estas funciones retornan un nuevo puntero a un Struct de tipo "Dato".
- nuevaLista(): retorna un puntero a una nueva lista enlazada
 
- nuevoDatoCadena(String): retorna un nuevo dato con un string como contenido.
 
- nuevoDatoNumerico(float): similar a nuevoDatoCadena, retorna un nuevo dato con un valor float adentro
 
- nuevoDatoLista(Lista): similar a nuevoDatoLista, retorna un nuevo dato con una lista enlazada dentro.

## Para el manejo de lista enlazadas
- agregarElemento(Lista *lista, Dato *dato): recibe una lista elazada y un dato  de tipo "Dato", luego inserta dicho dato
  dentro de la lista enlazada. No cuenta con valor de retorno

- imprimirLista(Lista *lista): imprime en la terminal el contenido de una lista enlazada. Recibe como parametro la lista
  la cual se quiere imprimir

- destruirLista(Lista *lista): destruye la lista y libera el espacio en memoria de su contenido

```
#include "structs.h"

int main () {
    // creamos las listas
    Lista *lista1 = nuevaLista();
    Lista *lista2 = nuevaLista();

    // creamos nuevos datos y los agregamos
    Dato *dato1 = nuevoDatoCadena("lista interior");
    agregarElemento(lista2, dato1);

    Dato *dato2 = nuevoDatoNumerico(110.12);
    agregarElemento(lista1, dato2);

    Dato *dato = nuevoDatoLista(lista2);
    agregarElemento(lista1, dato);

    imprimirLista(lista1);
    destruirLista(lista1);
    destruirLista(lista2);
}
```
