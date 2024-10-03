package ProyectoJava.Practico8;

import java.util.*;

public class ArbolAVL {
    NodoArbol root;


    public boolean isEmpty(){
        return root == null;
    }

    public void agregar(NodoArbol nuevoNodo){
        if (isEmpty()) {
            root = nuevoNodo;
        }
    }

        //no se si esta bien
    private NodoArbol BuscarAgregar(int num/*numero que comparo*/, NodoArbol nActual/*nodo actual*/){
        if (num > nActual.getDato()) {
            if (nActual.rightEmpty()) {
                return nActual;
            }else{
                return BuscarAgregar(num, nActual.getRight());
            }
        }

        if (num < nActual.getDato()) {
            if (nActual.leftEmpty()) {
                return nActual;
            }else{
                return BuscarAgregar(num, nActual.getLelft());
            }
        }

        return null;
    }
}
