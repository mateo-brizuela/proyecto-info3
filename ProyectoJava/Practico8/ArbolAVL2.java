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
        if (nActual.leftEmpty()) { // Caso base: no hay más nodos a la izquierda
            System.out.println("Se encontró el nodo menor");
            return nActual;
        } else {
            return nodoMenor(nActual.getLeft());
        }
    }

    // Método para agregar un nuevo nodo
    public void agregar() {
        Scanner consola = new Scanner(System.in);
        NodoArbol nuevoNodo;
        int nDato; // Nuevo dato
        System.out.println("Ingrese el dato del nuevo nodo");
        nDato = consola.nextInt();
        nuevoNodo = new NodoArbol(nDato); // Se crea el nuevo nodo

        if (isEmpty()) {
            root = nuevoNodo;
            nuevoNodo.setProfundidad(0); // El nodo raíz tiene profundidad 0
            System.out.println("Se creó la raíz del árbol");
        } else {
            buscarAgregar(nuevoNodo, root, 0);
        }
    }

    public void agregarConParametro(int dato){
        NodoArbol nuevoNodo;
        nuevoNodo = new NodoArbol(dato);

        if (isEmpty()) {
            root = nuevoNodo;
            nuevoNodo.setProfundidad(0); // El nodo raíz tiene profundidad 0
            System.out.println("Se creó la raíz del árbol");
        } else {
            buscarAgregar(nuevoNodo, root, 0);
        }

    }


    // Método para eliminar un nodo
    public void eliminar() {
        Scanner consola = new Scanner(System.in);
        int datoBuscado;
        System.out.println("Ingrese el dato del nodo a eliminar");
        datoBuscado = consola.nextInt();

        if (isEmpty()) {
            System.out.println("No hay nodos en el árbol");
        } else {
            buscarEliminar(datoBuscado, root);
        }
    }

    // Método para leer el árbol en inorden (izquierda, raíz, derecha)
    public void leerArbol(NodoArbol nActual) {
        if (isEmpty()) {
            System.out.println("No hay nodos en el árbol para mostrar");
            return;
        }

        if (!nActual.leftEmpty()) {
            leerArbol(nActual.getLeft());
        }
        System.out.println(nActual.getDato());
        if (!nActual.rightEmpty()) {
            leerArbol(nActual.getRight());
        }
    }

    // Función que actualiza la altura de un nodo recursivamente
    private void actualizarAltura(NodoArbol nActual) {
        while (nActual != null) {
            int alturaIzquierda = nActual.leftEmpty() ? -1 : nActual.getLeft().getAltura();
            int alturaDerecha = nActual.rightEmpty() ? -1 : nActual.getRight().getAltura();

            int nuevaAltura = Math.max(alturaIzquierda, alturaDerecha) + 1;

            // Si la altura no cambia, no es necesario seguir actualizando
            if (nActual.getAltura() == nuevaAltura) {
                break;
            }

            nActual.setAltura(nuevaAltura);
            nActual = nActual.getNodoPadre(); // Se continúa actualizando hacia arriba
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



    // Función para agregar un nuevo nodo en la posición correcta
    private void buscarAgregar(NodoArbol nuevoNodo, NodoArbol nActual, int profundidad) {
        // Comparación para determinar si el nuevo nodo va a la derecha o a la izquierda
        if (nuevoNodo.getDato() > nActual.getDato()) {
            if (nActual.rightEmpty()) {
                nuevoNodo.setProfundidad(profundidad + 1); // Asignar la profundidad correctamente
                nuevoNodo.setAltura(0); // La altura de un nodo recién insertado es 0
                nuevoNodo.setNodoPadre(nActual); // Enlazar con el nodo padre
                nActual.setRight(nuevoNodo); // Insertar en la derecha
                actualizarAltura(nActual); // Actualizar la altura a partir del padre
            } else {
                buscarAgregar(nuevoNodo, nActual.getRight(), profundidad + 1);
            }
        } else if (nuevoNodo.getDato() < nActual.getDato()) {
            if (nActual.leftEmpty()) {
                nuevoNodo.setProfundidad(profundidad + 1); // Asignar la profundidad correctamente
                nuevoNodo.setAltura(0); // La altura de un nodo recién insertado es 0
                nuevoNodo.setNodoPadre(nActual); // Enlazar con el nodo padre
                nActual.setLeft(nuevoNodo); // Insertar en la izquierda
                actualizarAltura(nActual); // Actualizar la altura a partir del padre
            } else {
                buscarAgregar(nuevoNodo, nActual.getLeft(), profundidad + 1);
            }
        } else {
            System.out.println("Error: no puede haber 2 nodos iguales");
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
