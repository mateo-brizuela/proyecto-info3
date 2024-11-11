package Utils.BinaryTree.AVLTree;

import Utils.BinaryTree.*;

public class AVLTree extends SelfEquilTree<AVLNode> {

    // Inserta un nodo en el árbol AVL
    @Override
    public void insert(AVLNode node) {
        setRoot(insertRec(getRoot(), node));
    }

    // Método recursivo para insertar un nodo y ajustar el árbol si es necesario
    private AVLNode insertRec(AVLNode current, AVLNode node) {
        if (current == null) {
            return node;
        }
        if (node.getData() < current.getData()) {
            current.setLeft(insertRec(current.getLeft(), node));
        } else if (node.getData() > current.getData()) {
            current.setRight(insertRec(current.getRight(), node));
        } else {
            return current; // Si el nodo ya existe, no se inserta
        }

        current.updateHeight(); // Actualiza la altura del nodo actual
        return balance(current); // Balancea el árbol a partir del nodo actual
    }

    // Método de eliminación no soportado sin especificar un dato
    @Override
    public AVLNode delete() {
        throw new UnsupportedOperationException("Use delete(int data) para eliminar un nodo específico.");
    }

    // Elimina un nodo específico por valor
    public void delete(int data) {
        setRoot(deleteRec(getRoot(), data));
    }

    // Método recursivo para eliminar un nodo y ajustar el árbol si es necesario
    private AVLNode deleteRec(AVLNode current, int data) {
        if (current == null) {
            return null;
        }

        if (data < current.getData()) {
            current.setLeft(deleteRec(current.getLeft(), data));
        } else if (data > current.getData()) {
            current.setRight(deleteRec(current.getRight(), data));
        } else {
            // Caso: el nodo tiene uno o ningún hijo
            if (current.getLeft() == null || current.getRight() == null) {
                return (current.getLeft() != null) ? current.getLeft() : current.getRight();
            }
            // Caso: el nodo tiene dos hijos
            AVLNode minLargerNode = findMin(current.getRight());
            current.setData(minLargerNode.getData());
            current.setRight(deleteRec(current.getRight(), minLargerNode.getData()));
        }

        current.updateHeight(); // Actualiza la altura del nodo actual
        return balance(current); // Balancea el árbol a partir del nodo actual
    }

    // Método para balancear el árbol a partir de un nodo
    private AVLNode balance(AVLNode node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor > 1) { // Subárbol izquierdo desbalanceado
            if (node.getLeft().getBalanceFactor() < 0) {
                rotateLeftSimple(node.getLeft());
            }
            rotateRightSimple(node);
        } else if (balanceFactor < -1) { // Subárbol derecho desbalanceado
            if (node.getRight().getBalanceFactor() > 0) {
                rotateRightSimple(node.getRight());
            }
            rotateLeftSimple(node);
        }
        return node;
    }
}
