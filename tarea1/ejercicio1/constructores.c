#include "structs.h"

// retorna una nueva lista
Lista *nuevaLista(){
    return malloc(sizeof(Lista));
}

// retorna un nuevo dato de tipo entero
Dato *nuevoDatoCadena(char *dato){
    Dato *nuevo = malloc(sizeof(Dato));
    nuevo->string = dato;
    nuevo->selector = 1;
    return nuevo;
}

// retorna un nuevo dato de tipo string
Dato *nuevoDatoNumerico(float dato){
    Dato *nuevo = malloc(sizeof(Dato));
    nuevo->numero = dato;
    nuevo->selector = 2;
    return nuevo;
}

// retorna un nuevo dato que contiene una lista
Dato *nuevoDatoLista(Lista *lista){
    Dato *tmp = malloc(sizeof(Dato));
    tmp->Lista = lista;
    tmp->selector = 3;
    return tmp;
}
