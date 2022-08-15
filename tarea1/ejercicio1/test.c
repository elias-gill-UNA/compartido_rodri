#include "structs.h"

int main () {
    // creamos las listas
    Lista *lista1 = nuevaLista();
    Lista *lista2 = nuevaLista();


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
