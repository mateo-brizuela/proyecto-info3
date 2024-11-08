package ProyectoJava.Arbol_Rojinegro.src.utils;

import Utils.BinaryTree.Color;

public class RBTree extends SelfEquilTree{
    // ------------------------------------ Atributos ------------------------------------
    private TreeNode root; // puntero al primer elemento del arbol (a la "raiz")
    // ------------------------------------ Metodos ------------------------------------
    // constructores
    public RBTree(){

    }
    public RBTree(TreeNode root){
        this.root = root;
    }
    // --------- funciones basicas ---------
    public void insert(TreeNode newNode){
        TreeNode currentNode = root;
        boolean found = false;

        if(root == null){ // caso 1: arbol vacio => se inserta en la raiz
            root = newNode;
            root.setColor(Color.BLACK); // propiedad 2: la raiz debe ser negra
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
    /*
    public void delete(int data){
        TreeNode toDelete = searchNode(data);
        
        if(toDelete != null){
            
        }
    }
    */
    public TreeNode searchNode(int data){
        TreeNode currentNode = root;
        boolean found = false;

        while(currentNode != null && found == false){
            if(currentNode.getData() == data){
                found = true;
            }
            else{
                if(data > currentNode.getData()){
                    currentNode = currentNode.getRight();
                }
                else{ // data < currentNode.getData()
                    currentNode = currentNode.getLeft();
                }
            }
        }
        if(found == false){
            System.out.println("ERROR: el valor ingresado no se encuentra en el arbol.\n");
        }

        return(currentNode);
    }
    
    // --------- control de propiedades ---------
    // respecto de color
    private void colorBalanceDown(TreeNode currentNode){ // mantiene la consistencia de color de los nodos a medida que avanzamos hacia las hojas
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
    private void solveExtraRedness(TreeNode currentNode){ // mira si hay dos rojos consecutivos. Si es asi, lo resuelve
        TreeNode parentNode = currentNode.getParent();

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
    // rotaciones 
    private void rotateRightSimple(TreeNode pivot){ // recibe el nodo que quedara como raiz del subarbol
        TreeNode pivotParent = pivot.getParent();
        TreeNode rChild = pivot.getRight();

        if(pivotParent == root){ // caso 1: el padre de pivot es la raiz
            // actualizar la raiz
            root = pivot;
        }
        else{ // caso 2: el padre de pivot es un nodo comun
            // convertir a pivot en el hijo de su abuelo
            if(pivotParent == pivotParent.getParent().getLeft()){ // pivotParent era hijo izq
                pivotParent.getParent().setLeft(pivot);
            }
            else{ // pivotParent era hijo der
                pivotParent.getParent().setRight(pivot);
            }
        }
        pivot.setParent(pivotParent.getParent()); // si pivotParent == root, pivot pasa a ser la nueva raiz y su padre debe quedar en null
        // convertir al hijo der de pivot en el izq de su abuelo
        if(rChild != null){ // hay un rChild? (puede que no)
            rChild.setParent(pivotParent);
        }
        pivotParent.setLeft(rChild);// si rChild == null sirve lo mismo porque tenemos que limpiar el enlace
        // redefinir relacion entre pivot y su padre
        pivot.setRight(pivotParent);
        pivotParent.setParent(pivot);
    }
    private void rotateLeftSimple(TreeNode pivot){ // recibe el nodo que quedara como raiz del subarbol
        TreeNode pivotParent = pivot.getParent();
        TreeNode lChild = pivot.getLeft();

        if(pivotParent == root){ // caso 1: el padre de pivot es la raiz
            // actualizar la raiz
            root = pivot;
        }
        else{ // caso 2: el padre de pivot es un nodo comun
            // convertir a pivot en el hijo de su abuelo
            if(pivotParent == pivotParent.getParent().getLeft()){ // pivotParent era hijo izq
                pivotParent.getParent().setLeft(pivot);
            }
            else{ // pivotParent era hijo der
                pivotParent.getParent().setRight(pivot);
            }
        }
        pivot.setParent(pivotParent.getParent());  
        // convertir al hijo der de pivot en el izq de su abuelo
        if(lChild != null){ // hay un lChild? (puede que no)
            lChild.setParent(pivotParent);
        }
        pivotParent.setRight(lChild); // si lChild == null sirve lo mismo porque tenemos que limpiar el enlace
        // redefinir relacion entre pivot y su padre
        pivot.setLeft(pivotParent);
        pivotParent.setParent(pivot);
    }

    // getters y setters
    public TreeNode getRoot(){
        return root;
    }
}
