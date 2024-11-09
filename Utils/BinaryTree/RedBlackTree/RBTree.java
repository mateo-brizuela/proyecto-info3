package Utils.BinaryTree.RedBlackTree;

import Utils.BinaryTree.*;

public class RBTree extends SelfEquilTree{

    @Override
    public void insert(TreeNode newNode) {
        RBNode currentNode = getRoot();
        boolean found = false;

        if(getRoot() == null){ // caso 1: arbol vacio => se inserta en la raiz
            setRoot(newNode);
            getRoot().setColor(Color.BLACK); // propiedad 2: la raiz debe ser negra
        }
        else{ // caso 2: el arbol ya tiene elementos
            while(found == false){ // busca el lugar donde va el nodo
                colorBalanceDown(currentNode); // algunas cond. de color se controlan mientras bajamos
                if(newNode.getData() >= currentNode.getData()){ // es mayor o igual => miro a la derecha
                    if(currentNode.getRight() != null){ // el hijo der no esta vacio => segui buscando
                        currentNode = currentNode.getRight();
                    }
                    else{ // el hijo der esta vacio => ahi va newNode
                        found = true;
                        currentNode.setRight(newNode);
                    }
                }
                else{ // newNode.getData() < currentNode.getData() // es menor => miro a la izq
                    if(currentNode.getLeft() != null){ // hijo izq NO vacio => segui buscando
                        currentNode = currentNode.getLeft();
                    }
                    else{ // hijo izq vacio => ahi va newNode
                        found = true;
                        currentNode.setLeft(newNode);
                    }
                }
            }
            newNode.setParent(currentNode); // la actualizacion del padre es igual para los dos casos
            solveExtraRedness(newNode); // mira si hay dos rojos consecutivos tras insertar. Si es asi, lo resuelve
        }
    }
    
    @Override
    public TreeNode delete(){
        // ToDo: implementar excepcion ;
        throw new UnsupportedOperationException("Unimplemented method 'insert'");
    }

    // --------- control de propiedades ---------
    // respecto de color
    private void colorBalanceDown(RBNode currentNode){ // mantiene la consistencia de color de los nodos a medida que avanzamos hacia las hojas
        if(currentNode.isRed() == false){ // el nodo es negro 
            if((currentNode.rightEmpty() == false && currentNode.leftEmpty() == false)){ // el nodo tiene 2 hijos
                if((currentNode.getRight().isRed() && currentNode.getLeft().isRed())){ // ambos hijos son rojos
                    // tenemos padre negro con 2 hijos rojos => intercambio de color entre padre e hijos
                    currentNode.setColor(Color.RED);
                    currentNode.getRight().setColor(Color.BLACK);
                    currentNode.getLeft().setColor(Color.BLACK);
                    if(currentNode == root){ // el nodo era la raiz => lo hicimos rojo. Por regla 2: la raiz DEBE ser negra
                        currentNode.setColor(Color.BLACK);
                    }
                    else{ // si el nodo no era la raiz, el intercambio de color podria haber introducido dos rojos consecutivos
                        solveExtraRedness(currentNode);
                    }
                }
            }
        }
    }
    private void solveExtraRedness(RBNode currentNode){ // mira si hay dos rojos consecutivos. Si es asi, lo resuelve
        RBNode parentNode = currentNode.getParent();

        if(currentNode.isRed() && parentNode.isRed()){ // hay dos rojos consecutivos
            /*
            Combinaciones de orden posibles (se resuelven distinto): 
                - current es hDer y parent es hDer
                - current es hIzq y parent es hIzq
                - current es hDer y parent es hIzq
                - current es hIzq y parent es hDer
            */
            if(currentNode == parentNode.getRight() && parentNode == parentNode.getParent().getRight()){ // current es hDer y parent es hDer
                // rotacion 
                rotateLeftSimple(parentNode);
                // cambio de color
                parentNode.setColor(Color.BLACK);
                parentNode.getLeft().setColor(Color.RED);
            } 
            else if(currentNode == parentNode.getLeft() && parentNode == parentNode.getParent().getLeft()){ // current es hIzq y parent es hIzq
                // rotacion 
                rotateRightSimple(parentNode);
                // cambio de color
                parentNode.setColor(Color.BLACK);
                parentNode.getRight().setColor(Color.RED);
            }
            else if(currentNode == parentNode.getRight() && parentNode == parentNode.getParent().getLeft()){ // current es hDer y parent es hIzq
                // rotacion 
                rotateLeftSimple(currentNode);
                rotateRightSimple(currentNode);
                // cambio de color
                currentNode.setColor(Color.BLACK);
                currentNode.getRight().setColor(Color.RED);
            }
            else{ // current es hIzq y parent es hDer
                // rotacion 
                rotateRightSimple(currentNode);
                rotateLeftSimple(currentNode);
                // cambio de color
                currentNode.setColor(Color.BLACK);
                currentNode.getLeft().setColor(Color.RED);
            }
        }
    }


}
