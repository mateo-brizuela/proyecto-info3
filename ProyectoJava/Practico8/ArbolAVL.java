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
            nuevoNodo.setProfundidad(0);
            System.out.println("se creo la raiz del arbol");
        }else{
            BuscarAgregar(nuevoNodo,root,0);
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
            buscarEliminar(datoBuscado, root);
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


    // funcion recursiva que actualiza la altura cuando se agrega un nodo
    private void actualizarAltura(int alturaSugerida, NodoArbol nActual){
        if (nActual == null) { // es por si la raiz actualiza la altura
            return;
        }

        // si la altura sugerida es menor, significa que el otro subarbol tiene mayor altura
        // por lo tanto desde este nodo hacia arriba no es necesario actualizar la altura
        if (nActual.getAltura() >= alturaSugerida) { 
            return;
        }else{
            nActual.setAltura(alturaSugerida);
            actualizarAltura(alturaSugerida + 1, nActual.getNodoPadre());
        }
    }





    // esta funcion va a ubicar el nuevo nodo en la posicion que le corresponde del arbol
    private void BuscarAgregar(NodoArbol nuevoNodo, NodoArbol nActual, int profundidad){
        if (nuevoNodo.getDato() > nActual.getDato()) {
            if (nActual.rightEmpty()) {
                nuevoNodo.setProfundidad(profundidad + 1); // asigno la profundidad al nuevo nodo
                nuevoNodo.setAltura(0); // la altura de un nuevo nodo siempre es 0
                nuevoNodo.setNodoPadre(nActual);
                nActual.setRight(nuevoNodo);
                actualizarAltura(1, nActual); // comienza a  actualizar la altura
            }else{
                BuscarAgregar(nuevoNodo, nActual.getRight(), profundidad + 1);
            }
        }

        if (nuevoNodo.getDato() < nActual.getDato()) {
            if (nActual.leftEmpty()) {
                nuevoNodo.setProfundidad(profundidad + 1); // asigno la profundidad al nuevo nodo
                nuevoNodo.setAltura(0); // la altura de un nuevo nodo siempre es 0
                nuevoNodo.setNodoPadre(nActual);
                nActual.setLeft(nuevoNodo);
                actualizarAltura(1, nActual); // comienza a  actualizar la altura
            }else{
                BuscarAgregar(nuevoNodo, nActual.getLelft(), profundidad + 1);
            }
        }

        if (nuevoNodo.getDato() == nActual.getDato()) {
            System.out.println("error: no puede haber 2 nodos iguales");
        }
    }

    private void buscarEliminar(int datoBuscado, NodoArbol nActual){
        // caso donde no se encontro un nodo con el dato buscado
        if (nActual == null) {
            System.out.println("no se encontraron coincidencias");
            return;

         // se recorre el arbol de forma recursiva buscando un nodo igual al dato
        }else if (datoBuscado < nActual.getDato()) {
            buscarEliminar(datoBuscado, nActual.getLelft());

        }else if (datoBuscado > nActual.getDato()) {
            buscarEliminar(datoBuscado, nActual.getRight());

         // si este else se ejecuta es porque se encontro una coincidencia con el dato buscado
        }else{
            NodoArbol nodoMenorDerecho; // nodo que se usa para identificar el nodo menor del subarbo derecho

            if (nActual.getNodoPadre() == null) { // pregunta si el nodo a eliminar es la raiz
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
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {

                    nActual.getNodoPadre().setRight(null); //borro el nodo

                }else{

                    nActual.getNodoPadre().setLeft(null); //borro el nodo

                }
                System.out.println("se borro el nodo correctamente");


              // pregunto si tiene solo un hijo a la izquierda
            }else if ((nActual.rightEmpty() == true) && (nActual.leftEmpty() == false)) {
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {

                    nActual.getNodoPadre().setRight(nActual.getLelft()); //borro el nodo

                }else{

                    nActual.getNodoPadre().setLeft(nActual.getLelft()); //borro el nodo

                }
                System.out.println("se borro el nodo correctamente");


              // pregunto si solo tiene un hijo a la derecha
            }else if ((nActual.rightEmpty() == false) && (nActual.leftEmpty() == true)) {
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {
                    
                    nActual.getNodoPadre().setRight(nActual.getRight()); //borro el nodo

                }else{

                    nActual.getNodoPadre().setLeft(nActual.getRight()); //borro el nodo
                    
                }
                System.out.println("se borro el nodo correctamente");

            }else{ // si no es ninguno de los casos anteriores, es que tiene 2 hijos
                // el nodo menor del subarbol derecho
                nodoMenorDerecho = nodoMenor(nActual.getRight());
                // cuelgo el subarbol izquierdo en el menor nodo del subarbolderecho
                nodoMenorDerecho.setLeft(nActual.getLelft()); 

                nodoMenorDerecho.setLeft(nActual.getLelft());
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {

                    nActual.getNodoPadre().setRight(nActual.getRight()); //borro el nodo

                }else{

                    nActual.getNodoPadre().setLeft(nActual.getRight()); //borro el nodo

                }
                System.out.println("se elimino el nodo correctamente");
            }

        }
    }

}
