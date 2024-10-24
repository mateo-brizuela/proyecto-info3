package ProyectoJava.Practico8;

import java.util.Scanner;

public class ArbolAVL2 {
    private NodoArbol root;

    // Obtener la raíz del árbol
    public NodoArbol getRoot() {
        return root;
    }

    // Verifica si el árbol está vacío
    public boolean isEmpty() {
        return root == null;
    }

    // Encuentra el nodo con el menor valor en un subárbol
    public NodoArbol nodoMenor(NodoArbol nActual) {
        if (isEmpty()) {
            System.out.println("No hay nodos en el árbol");
            return null;
        }
        if (nActual.leftEmpty()) {
            return nActual; // Caso base: el nodo más a la izquierda es el menor
        } else {
            return nodoMenor(nActual.getLeft());
        }
    }

    // Método para agregar un nuevo nodo
    public void agregar() {
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese el dato del nuevo nodo:");
        int nDato = consola.nextInt(); // Nuevo dato del nodo
        agregarConParametro(nDato);
    }

    public void agregarConParametro(int dato) {
        NodoArbol nuevoNodo = new NodoArbol(dato);

        if (isEmpty()) {
            root = nuevoNodo; // El primer nodo se convierte en la raíz
            nuevoNodo.setProfundidad(0); // La profundidad de la raíz es 0
            System.out.println("Se creó la raíz del árbol");
        } else {
            buscarAgregar(nuevoNodo, root, 0);
        }
    }

    // Método para eliminar un nodo
    public void eliminar() {
        Scanner consola = new Scanner(System.in);
        System.out.println("Ingrese el dato del nodo a eliminar:");
        int datoBuscado = consola.nextInt();

        if (isEmpty()) {
            System.out.println("No hay nodos en el árbol");
        } else {
            buscarEliminar(datoBuscado, root);
        }
    }

    // Método para leer el árbol en inorden (izquierda, raíz, derecha)
    public void leerArbol(NodoArbol nActual) {
        if (nActual != null) {
            leerArbol(nActual.getLeft());
            System.out.println(nActual.getDato());
            leerArbol(nActual.getRight());
        }
    }

    // lee el arbol pero mostrando la informacion detallada de cada nodo
    public void leerDetalleArbol(NodoArbol nActual, int numNodo){
        if (isEmpty()) {
            System.out.println("no hay nodos en el arbol para leer");
            return;
        }

        System.out.println("////////// nodo numero :" + numNodo + " //////////");
        System.out.println("dato: " + nActual.getDato());
        System.out.println("altura: " + nActual.getAltura());
        System.out.println("profundidad: " + nActual.getProfundidad());
        
        if (!nActual.leftEmpty()) {
            leerDetalleArbol(nActual.getLeft(), (numNodo * 2));
        }

        if (!nActual.rightEmpty()) {
            leerDetalleArbol(nActual.getRight(), (numNodo*2) + 1);
        }
    }

    // Función que actualiza la altura y profundidad después de una rotación o inserción
    private void actualizarAlturaYProfundidad(NodoArbol nodo) {
        while (nodo != null) {
            int alturaIzquierda = nodo.leftEmpty() ? -1 : nodo.getLeft().getAltura();
            int alturaDerecha = nodo.rightEmpty() ? -1 : nodo.getRight().getAltura();
            nodo.setAltura(Math.max(alturaIzquierda, alturaDerecha) + 1);
            nodo.setProfundidad(nodo.getNodoPadre() == null ? 0 : nodo.getNodoPadre().getProfundidad() + 1);

            // Actualizar el equilibrio del nodo
            nodo.setSize(alturaDerecha - alturaIzquierda);

            // Verificar si hay desbalance y reequilibrar
            if (Math.abs(nodo.getSize()) > 1) {
                rebalancear(nodo);
            }
            nodo = nodo.getNodoPadre();
        }
    }

    // Rotación simple a la izquierda
    private void rotacionIzquierda(NodoArbol nActual) {
        NodoArbol nuevaRaiz = nActual.getRight();
        NodoArbol subArbolIzquierdo = nuevaRaiz.getLeft();

        nuevaRaiz.setLeft(nActual);
        nActual.setRight(subArbolIzquierdo);

        if (nActual == root) {
            root = nuevaRaiz;
        } else {
            if (nActual.getNodoPadre().getLeft() == nActual) {
                nActual.getNodoPadre().setLeft(nuevaRaiz);
            } else {
                nActual.getNodoPadre().setRight(nuevaRaiz);
            }
        }
        nuevaRaiz.setNodoPadre(nActual.getNodoPadre());
        nActual.setNodoPadre(nuevaRaiz);
        if (subArbolIzquierdo != null) subArbolIzquierdo.setNodoPadre(nActual);

        // Actualizar alturas y profundidades después de la rotación
        actualizarAlturaYProfundidad(nActual);
        actualizarAlturaYProfundidad(nuevaRaiz);
    }

    // Rotación simple a la derecha
    private void rotacionDerecha(NodoArbol nActual) {
        NodoArbol nuevaRaiz = nActual.getLeft();
        NodoArbol subArbolDerecho = nuevaRaiz.getRight();

        nuevaRaiz.setRight(nActual);
        nActual.setLeft(subArbolDerecho);

        if (nActual == root) {
            root = nuevaRaiz;
        } else {
            if (nActual.getNodoPadre().getLeft() == nActual) {
                nActual.getNodoPadre().setLeft(nuevaRaiz);
            } else {
                nActual.getNodoPadre().setRight(nuevaRaiz);
            }
        }
        nuevaRaiz.setNodoPadre(nActual.getNodoPadre());
        nActual.setNodoPadre(nuevaRaiz);
        if (subArbolDerecho != null) subArbolDerecho.setNodoPadre(nActual);

        // Actualizar alturas y profundidades después de la rotación
        actualizarAlturaYProfundidad(nActual);
        actualizarAlturaYProfundidad(nuevaRaiz);
    }

    // Rebalancea el árbol en caso de desbalance
    public void rebalancear(NodoArbol nActual) {
        if (nActual.getSize() < -1) {
            if (nActual.getLeft().getSize() > 0) {
                rotacionIzquierda(nActual.getLeft());
            }
            rotacionDerecha(nActual);
        } else if (nActual.getSize() > 1) {
            if (nActual.getRight().getSize() < 0) {
                rotacionDerecha(nActual.getRight());
            }
            rotacionIzquierda(nActual);
        }
    }

    // Función para agregar un nuevo nodo en la posición correcta
    private void buscarAgregar(NodoArbol nuevoNodo, NodoArbol nActual, int profundidad) {
        if (nuevoNodo.getDato() > nActual.getDato()) {
            if (nActual.rightEmpty()) {
                nuevoNodo.setProfundidad(profundidad + 1); // Asignar la profundidad correctamente
                nuevoNodo.setAltura(0); // La altura de un nodo recién insertado es 0
                nuevoNodo.setNodoPadre(nActual); // Enlazar con el nodo padre
                nActual.setRight(nuevoNodo); // Insertar en la derecha
                actualizarAlturaYProfundidad(nActual); // Actualizar la altura a partir del padre
            } else {
                buscarAgregar(nuevoNodo, nActual.getRight(), profundidad + 1);
            }
        } else if (nuevoNodo.getDato() < nActual.getDato()) {
            if (nActual.leftEmpty()) {
                nuevoNodo.setProfundidad(profundidad + 1);
                nuevoNodo.setAltura(0);
                nuevoNodo.setNodoPadre(nActual);
                nActual.setLeft(nuevoNodo);
                actualizarAlturaYProfundidad(nActual);
            } else {
                buscarAgregar(nuevoNodo, nActual.getLeft(), profundidad + 1);
            }
        } else {
            System.out.println("Error: no puede haber 2 nodos con el mismo valor");
        }
    }


    // Función para eliminar un nodo del árbol
    private void buscarEliminar(int datoBuscado, NodoArbol nActual) {
        if (nActual == null) {
            System.out.println("No se encontraron coincidencias");
            return;
        }

        // Recorrer el árbol buscando el nodo a eliminar
        if (datoBuscado < nActual.getDato()) {
            buscarEliminar(datoBuscado, nActual.getLeft());
        } else if (datoBuscado > nActual.getDato()) {
            buscarEliminar(datoBuscado, nActual.getRight());
        } else {
            // Nodo encontrado: gestionar eliminación de diferentes casos
            if (nActual.rightEmpty() && nActual.leftEmpty()) {
                // Caso nodo hoja
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {
                    nActual.getNodoPadre().setRight(null);
                } else {
                    nActual.getNodoPadre().setLeft(null);
                }
            } else if (nActual.leftEmpty() && !nActual.rightEmpty()) {
                // Nodo con hijo derecho
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {
                    nActual.getNodoPadre().setRight(nActual.getRight());
                } else {
                    nActual.getNodoPadre().setLeft(nActual.getRight());
                }
            } else if (!nActual.leftEmpty() && nActual.rightEmpty()) {
                // Nodo con hijo izquierdo
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {
                    nActual.getNodoPadre().setRight(nActual.getLeft());
                } else {
                    nActual.getNodoPadre().setLeft(nActual.getLeft());
                }
            } else {
                // Nodo con dos hijos: buscar el nodo menor en el subárbol derecho
                NodoArbol nodoMenorDerecho = nodoMenor(nActual.getRight());
                nodoMenorDerecho.setLeft(nActual.getLeft());
                if (nActual.getDato() > nActual.getNodoPadre().getDato()) {
                    nActual.getNodoPadre().setRight(nActual.getRight());
                } else {
                    nActual.getNodoPadre().setLeft(nActual.getRight());
                }
            }
            System.out.println("Se eliminó el nodo correctamente");
        }
    }
}
