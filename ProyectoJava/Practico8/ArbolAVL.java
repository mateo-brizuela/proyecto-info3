package ProyectoJava.Practico8;

import java.util.*;

public class ArbolAVL {
    NodoArbol root;


    public boolean isEmpty(){
        return root == null;
    }

    public NodoArbol nodoMenor(NodoArbol nActual){
        if (isEmpty()) {
            System.out.println("no hay nodos en el arbol");
            return null;
        }
        if (nActual.leftEmpty()) { // caso base 
            System.out.println("se encontro el nodo menor");
            return nActual;
        }else{
            return nodoMenor(nActual.getLelft());
        }
        
    }

    public void agregar(NodoArbol nuevoNodo){
        if (isEmpty()) {
            root = nuevoNodo;
        }else{
            BuscarAgregar(nuevoNodo,root);
        }
    }

    public void eliminar(NodoArbol nodoBuscado){
        if (isEmpty()) {
            System.out.println("no hay nodos en el arbol");
        }else{

        }
    }

    // esta funcion va a ubicar el nuevo nodo en la posicion que le corresponde del arbol
    private void BuscarAgregar(NodoArbol nuevoNodo, NodoArbol nActual/*nodo actual*/){
        if (nuevoNodo.getDato() > nActual.getDato()) {
            if (nActual.rightEmpty()) {
                nActual.setRight(nuevoNodo);
            }else{
                BuscarAgregar(nuevoNodo, nActual.getRight());
            }
        }

        if (nuevoNodo.getDato() < nActual.getDato()) {
            if (nActual.leftEmpty()) {
                nActual.setLeft(nuevoNodo);
            }else{
                BuscarAgregar(nuevoNodo, nActual.getLelft());
            }
        }

        if (nuevoNodo.getDato() == nActual.getDato()) {
            System.out.println("error: no puede haber 2 nodos iguales");
        }
    }

    public void buscarEliminar(NodoArbol nodoBuscado, NodoArbol nActual, NodoArbol nodoPadre){
        if (nActual == null) {
            System.out.println("no se encontraron coincidencias");
            return;
        }else if (nodoBuscado.getDato() < nActual.getDato()) {
            buscarEliminar(nodoBuscado, nActual.getLelft(), nActual);

        }else if (nodoBuscado.getDato() > nActual.getDato()) {
            buscarEliminar(nodoBuscado, nActual.getRight(), nActual);

        }else{
            if (nodoPadre == null) { // pregunta si el nodo a eliminar es la raiz
                // pregunto si es el nodo raizy si no tiene hijos
                if (nActual.leftEmpty() && nActual.rightEmpty()) {
                    root = null;
                    System.out.println("se eliminaron todos los nodos del arbol");
                }
              // pregunto si el nodo a borrar es un nodo terminal
            }else if (nActual.rightEmpty() && nActual.leftEmpty()) {
                if (nActual.getDato() > nodoPadre.getDato()) {
                    nodoPadre.setRight(null); //borro el nodo
                }else{
                    nodoPadre.setLeft(null); //borro el nodo
                }
                System.out.println("se borro el nodo correctamente");

              // pregunto si tiene solo un hijo a la izquierda
            }else if ((nActual.rightEmpty() == true) && (nActual.leftEmpty() == false)) {
                if (nActual.getDato() > nodoPadre.getDato()) {
                    nodoPadre.setRight(nActual.getLelft()); //borro el nodo
                }else{
                    nodoPadre.setLeft(nActual.getLelft()); //borro el nodo
                }
                System.out.println("se borro el nodo correctamente");

              // pregunto si solo tiene un hijo a la derecha
            }else if ((nActual.rightEmpty() == false) && (nActual.leftEmpty() == true)) {
                if (nActual.getDato() > nodoPadre.getDato()) {
                    nodoPadre.setRight(nActual.getRight()); //borro el nodo
                }else{
                    nodoPadre.setLeft(nActual.getRight()); //borro el nodo
                }
                System.out.println("se borro el nodo correctamente");

            }else{ // si no es ninguno de los casos anteriores, es que tiene 2 hijos
                // el nodo menor del subarbol derecho
                NodoArbol nodoMenorDerecho = nodoMenor(nActual.getRight());
                // cuelgo el subarbol izquierdo en el menor nodo del subarbolderecho
                nodoMenorDerecho.setLeft(nActual.getLelft()); 

                nodoMenorDerecho.setLeft(nActual.getLelft());
                if (nActual.getDato() > nodoPadre.getDato()) {
                    nodoPadre.setRight(nActual.getRight()); //borro el nodo
                }else{
                    nodoPadre.setLeft(nActual.getRight()); // borro el nodo
                }
                System.out.println("se elimino el nodo correctamente");
            }

        }
    }

}
