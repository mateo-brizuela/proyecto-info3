package Utils.BinaryTree.AVLTree;
import Utils.BinaryTree.*;

public abstract class SelfEquilTree2<T extends TreeNode<T>> extends BinaryTree<T> {

    // Rotación simple a la derecha
    protected T rotateRightSimple(T pivotParent) {
        if (pivotParent == null) {
            return null; // Si el nodo es null, no se realiza la rotación
        }

        T pivot = pivotParent.getLeft();
        if (pivot == null) {
            return pivotParent; // Si no hay nodo izquierdo, no se realiza la rotación
        }

        T rChild = pivot.getRight();

        // Si pivotParent es la raíz, actualizar la raíz
        if (pivotParent == getRoot()) {
            setRoot(pivot);
            pivot.setParent(null); // La nueva raíz no tiene padre
        } else {
            T grandParent = pivotParent.getParent();
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

        return pivot; // Retorna el nuevo nodo raíz del subárbol
    }

    // Rotación simple a la izquierda
    protected T rotateLeftSimple(T pivotParent) {
        if (pivotParent == null) {
            return null; // Si el nodo es null, no se realiza la rotación
        }

        T pivot = pivotParent.getRight();
        if (pivot == null) {
            return pivotParent; // Si no hay nodo derecho, no se realiza la rotación
        }

        T lChild = pivot.getLeft();

        // Si pivotParent es la raíz, actualizar la raíz
        if (pivotParent == getRoot()) {
            setRoot(pivot);
            pivot.setParent(null); // La nueva raíz no tiene padre
        } else {
            T grandParent = pivotParent.getParent();
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

        return pivot; // Retorna el nuevo nodo raíz del subárbol
    }
}
