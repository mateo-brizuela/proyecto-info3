package Utils.BinaryTree.AVLTree;

import Utils.BinaryTree.*;

public class AVLTree extends BinaryTree<AVLNode> {

    // Inserta un nodo en el árbol AVL
    @Override
    public void insert(AVLNode node) {
        setRoot(insertRec(getRoot(), node));
    }

    // Implementación del método abstracto delete() de BinaryTree
    @Override
    public AVLNode delete() {
        throw new UnsupportedOperationException("Use delete(int data) para eliminar un nodo específico.");
    }

    // Método de eliminación con verificación de existencia
    public boolean delete(int data) {
        AVLNode nodeToDelete = searchNode(data);
        if (nodeToDelete == null) {
            return false; // El nodo no existe
        } else {
            setRoot(deleteRec(getRoot(), data));
            return true; // El nodo fue eliminado
        }
    }

    // Método recursivo de eliminación
    private AVLNode deleteRec(AVLNode current, int data) {
        if (current == null) {
            return null;
        }

        if (data < current.getData()) {
            current.setLeft(deleteRec(current.getLeft(), data));
        } else if (data > current.getData()) {
            current.setRight(deleteRec(current.getRight(), data));
        } else {
            if (current.getLeft() == null || current.getRight() == null) {
                return (current.getLeft() != null) ? current.getLeft() : current.getRight();
            }
            AVLNode minLargerNode = findMin(current.getRight());
            current.setData(minLargerNode.getData());
            current.setRight(deleteRec(current.getRight(), minLargerNode.getData()));
        }

        current.updateHeight();
        return balance(current);
    }

    // Método recursivo para insertar un nodo
    private AVLNode insertRec(AVLNode current, AVLNode node) {
        if (current == null) {
            return node;
        }
        if (node.getData() < current.getData()) {
            current.setLeft(insertRec(current.getLeft(), node));
            current.getLeft().setParent(current);
        } else if (node.getData() > current.getData()) {
            current.setRight(insertRec(current.getRight(), node));
            current.getRight().setParent(current);
        } else {
            return current; // Si el nodo ya existe, no se inserta
        }

        current.updateHeight();
        return balance(current);
    }

    // Balanceo del nodo
    private AVLNode balance(AVLNode node) {
        int balanceFactor = node.getBalanceFactor();
        if (balanceFactor > 1) {
            if (node.getLeft().getBalanceFactor() < 0) {
                node.setLeft(rotateLeftSimple(node.getLeft()));
            }
            node = rotateRightSimple(node);
        } else if (balanceFactor < -1) {
            if (node.getRight().getBalanceFactor() > 0) {
                node.setRight(rotateRightSimple(node.getRight()));
            }
            node = rotateLeftSimple(node);
        }
        return node;
    }

    // Rotación simple a la derecha
    private AVLNode rotateRightSimple(AVLNode pivotParent) {
        AVLNode pivot = pivotParent.getLeft();
        AVLNode rChild = pivot.getRight();

        if (pivotParent == getRoot()) {
            setRoot(pivot);
            pivot.setParent(null);
        } else {
            AVLNode grandParent = pivotParent.getParent();
            if (grandParent != null) {
                if (pivotParent == grandParent.getLeft()) {
                    grandParent.setLeft(pivot);
                } else {
                    grandParent.setRight(pivot);
                }
            }
            pivot.setParent(grandParent);
        }

        pivotParent.setLeft(rChild);
        if (rChild != null) {
            rChild.setParent(pivotParent);
        }

        pivot.setRight(pivotParent);
        pivotParent.setParent(pivot);

        return pivot;
    }

    // Rotación simple a la izquierda
    private AVLNode rotateLeftSimple(AVLNode pivotParent) {
        AVLNode pivot = pivotParent.getRight();
        AVLNode lChild = pivot.getLeft();

        if (pivotParent == getRoot()) {
            setRoot(pivot);
            pivot.setParent(null);
        } else {
            AVLNode grandParent = pivotParent.getParent();
            if (grandParent != null) {
                if (pivotParent == grandParent.getLeft()) {
                    grandParent.setLeft(pivot);
                } else {
                    grandParent.setRight(pivot);
                }
            }
            pivot.setParent(grandParent);
        }

        pivotParent.setRight(lChild);
        if (lChild != null) {
            lChild.setParent(pivotParent);
        }

        pivot.setLeft(pivotParent);
        pivotParent.setParent(pivot);

        return pivot;
    }
}
