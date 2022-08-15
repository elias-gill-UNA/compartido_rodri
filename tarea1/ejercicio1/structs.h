#include <stdio.h>
#include <stdio.h>
#include <stdlib.h>

typedef struct Lista {
    struct Nodo *cabeza;
}Lista;

// estructura de un nodo en la lista
typedef struct Nodo {
    struct Nodo *siguiente; // nodo siguiente en la lista
    struct Dato *dato; // el tipo de dato
}Nodo;

// estructura de un dato nuevo 
typedef struct Dato {
    char *string; // tipo de dato (se escribe como cadena)
    float numero;
    struct Lista *Lista;

    int selector; // selector que contiene a cual tipo de dato apuntar
                    // 1- string
                    // 2- entero
                    // 3- lista
}Dato;

void imprimirLista(Lista *lista);
void agregarElemento(Lista *lista, Dato *dato);
void destruirLista(Lista *lista);

// funciones "publicas"
Dato *nuevoDatoLista(Lista *lista);
Dato *nuevoDatoCadena(char *dato);
Dato *nuevoDatoNumerico(float dato);
Lista *nuevaLista();
