/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagecarousel;

/**
 *
 * @author ilichh1
 */
public class ListaLigadaDobleCircular<T> {
    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int largo;
    // Nodo para indicar la posicion actual
    private Nodo<T> nodoActual;
    
    public ListaLigadaDobleCircular() {
        inicio = null;
        ultimo = null;
        largo = 0;
        nodoActual = null;
    }
    
    public void insertarAlFinal(T v) {
        Nodo nuevo = new Nodo(v);
        largo++;
        if (listaVacia()) {
            inicio = nuevo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
            ultimo = inicio;
            return;
        }
        
        nuevo.anterior = ultimo;
        nuevo.siguiente = inicio;
        inicio.anterior = nuevo;
        ultimo.siguiente = nuevo;
        ultimo = nuevo;
    }
    
    public T getAnterior() {
        if (listaVacia()) {
            return null;
        }
        
        if (nodoActual == null) {
            nodoActual = ultimo;
            return nodoActual.valor;
        }
        
        nodoActual = nodoActual.anterior;
        return nodoActual.valor;
    }
    
    public T getSiguiente() {
        if (listaVacia()) {
            return null;
        }

        if (nodoActual == null) {
            nodoActual = inicio;
            return nodoActual.valor;
        }
        
        nodoActual = nodoActual.siguiente;
        return nodoActual.valor;
    }
    
    public boolean listaVacia() {
        return inicio == null;
    }
    
    public int getLargo() {
        return largo;
    }
}

class Nodo<T> {
    public Nodo siguiente;
    public Nodo anterior;
    public T valor;
    
    public Nodo(T v) {
        valor = v;
    }
    
    public Nodo(Nodo a, T v, Nodo s) {
        valor = v;
        anterior = a;
        siguiente = s;
    }
}
