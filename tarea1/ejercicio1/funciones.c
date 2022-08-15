#include "structs.h"

// ("privada") imprime el contenido de un nodo de una lista enlazada dependiendo 
// del tipo de dato
void imprimirNodo(Nodo *nodo){
    switch (nodo->dato->selector) {
        case 1:
            printf("'%s' ", nodo->dato->string);
            break;
        case 2:
            printf("%f ", nodo->dato->numero);
            break;
        // para la lista imprimir de manera recursiva la lista interna
        case 3: 
            imprimirLista(nodo->dato->Lista);
            break;
    }
    // seguir imprimiendo
    if (nodo->siguiente != NULL){
        imprimirNodo(nodo->siguiente);
    } 
}

// imprimir el contenido de una lista enlazada
void imprimirLista(Lista *lista){
    printf("( ");
    if(lista->cabeza != NULL){
        imprimirNodo(lista->cabeza);
    }
    printf(") ");
}

// insertar un nuevo elemento Nodo con el dato ingresado
void agregarElemento(Lista *lista, Dato *dato){
    Nodo *tmp = malloc(sizeof(Nodo)); // crear el nuevo nodo
    tmp->dato = dato; // asignar el valor
    tmp->siguiente = lista->cabeza;
    lista->cabeza = tmp;
}

// eliminar una lista enlazada
void destruirLista(Lista *lista) {
    free(lista);
}
