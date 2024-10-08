package ProyectoJava.Practico8;

import java.util.*;

public class ArbolAVL {
    private NodoArbol root;

    public NodoArbol getRoot(){
        return root;
    }

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

    public void agregar(){
        Scanner consola = new Scanner(System.in);
        NodoArbol nuevoNodo;
        int nDato; // nuevo dato
        System.out.println("ingrese el dato del nuevo nodo");
        nDato = consola.nextInt();
        nuevoNodo = new NodoArbol(nDato); // se crea el nuevo nodo

        if (isEmpty()) {
            root = nuevoNodo;
            System.out.println("se creo la raiz del arbol");
        }else{
            BuscarAgregar(nuevoNodo,root);
        }
    }

    public void eliminar(){
        Scanner consola = new Scanner(System.in);
        NodoArbol nodoBuscado;
        int datoBuscado; // nuevo dato
        System.out.println("ingrese el dato del nodo a eliminar");
        datoBuscado = consola.nextInt();
        nodoBuscado = new NodoArbol(datoBuscado); // esto se va a arreglar para que busque directamente el dato

        if (isEmpty()) {
            System.out.println("no hay nodos en el arbol");
        }else{
            buscarEliminar(datoBuscado, root, null);
        }
    }

    public void leerArbol(NodoArbol nActual){
        if (isEmpty()) {
            System.out.println("no hay nodos en el arbol para mostrar");
            return;
        }

        if (nActual.leftEmpty()) {
            System.out.println(nActual.getDato());
        }else{
            leerArbol(nActual.getLelft());
            System.out.println(nActual.getDato());

            if (nActual.rightEmpty() == false) {
                leerArbol(nActual.getRight());
            }
        }

    }

    public void actualizarProfundidad(NodoArbol nActual, int profundidad){
        if (isEmpty()) {
            System.out.println("no hay nodos en el arbol para calcular profundidad");
            return;
        }

        //caso base
        if ((nActual.leftEmpty() == true) && (nActual.rightEmpty() == true)) {
            nActual.setProfundidad(profundidad);
            return;
        }

        // yo enrealidad queria hacer tambien que si el nodo actual era nulo que se corte la ejecucion
        // pero por algun motivo el compilado me da error si hago eso, asi que estoy usando esta forma ineficiente

        if ((nActual.leftEmpty() == false) && (nActual.rightEmpty() == true)) {
            nActual.setProfundidad(profundidad);
            actualizarProfundidad(nActual.getLelft(), profundidad + 1);
            return;
        }

        if ((nActual.leftEmpty() == true) && (nActual.rightEmpty() == false)) {
            nActual.setProfundidad(profundidad);
            actualizarProfundidad(nActual.getRight(), profundidad + 1);
        }

         // caso donde el nodo tenga 2 hijos
        if ((nActual.leftEmpty() == false) && (nActual.rightEmpty() == false)) {
            nActual.setProfundidad(profundidad);
            actualizarProfundidad(nActual.getLelft(), profundidad + 1);
            actualizarProfundidad(nActual.getRight(), profundidad + 1);
            
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

    private void buscarEliminar(int datoBuscado, NodoArbol nActual, NodoArbol nodoPadre){
        // caso donde no se encontro un nodo con el dato buscado
        if (nActual == null) {
            System.out.println("no se encontraron coincidencias");
            return;

         // se recorre el arbol de forma recursiva buscando un nodo igual al dato
        }else if (datoBuscado < nActual.getDato()) {
            buscarEliminar(datoBuscado, nActual.getLelft(), nActual);

        }else if (datoBuscado > nActual.getDato()) {
            buscarEliminar(datoBuscado, nActual.getRight(), nActual);

         // si este else se ejecuta es porque se encontro una coincidencia con el dato buscado
        }else{
            NodoArbol nodoMenorDerecho; // nodo que se usa para identificar el nodo menor del subarbo derecho

            if (nodoPadre == null) { // pregunta si el nodo a eliminar es la raiz
                // pregunto si es el nodo raiz no tiene hijos
                if (nActual.leftEmpty() && nActual.rightEmpty()) {
                    root = null;
                    System.out.println("se eliminaron todos los nodos del arbol");
                }

                // pregunto si el nodo raiz tiene un hijo a la derecha
                if ((nActual.leftEmpty() == true) && (nActual.rightEmpty() == false)) {
                    root = nActual.getRight();
                    System.out.println("se elimino el nodo raiz");
                }

                // pregunto si el nodo raiz tiene un hijo a la izquierda
                if ((nActual.leftEmpty() == false) && (nActual.rightEmpty() == true)) {
                    root = nActual.getLelft();
                    System.out.println("se elimino el nodo raiz");
                }

                // pregunto si el nodo raiz tiene 2 hijos
                if ((nActual.leftEmpty() == false) && (nActual.rightEmpty() == false)) {
                    // asigno el subarbol izquierdo al nodo menor de la derecha
                    nodoMenorDerecho = nodoMenor(nActual.getRight());
                    nodoMenorDerecho.setLeft(nActual.getLelft());
                    // borro el nodo raiz
                    root = nActual.getRight();
                    System.out.println("se borro el nodo raiz");
                }


              // pregunto si el nodo a borrar es un nodo terminal
            }else if (nActual.rightEmpty() && nActual.leftEmpty()) {
                // esta comparacion se hace para saber cual enlace del nodo padre cambiar
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
                nodoMenorDerecho = nodoMenor(nActual.getRight());
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
