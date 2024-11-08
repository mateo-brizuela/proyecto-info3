package Utils.BinaryTree;

public class TreeNode {
    // ------------------ Atributos ------------------
    private int data; // dato guardado en el nodo
    // conexiones entre nodos
    private TreeNode parent; // nodo padre
    private TreeNode right; // nodo hijo derecho
    private TreeNode left; // nodo hijo izquierdo

    // ------------------ Metodos ------------------
    public boolean rightEmpty(){ // devuelve 1 si no tiene hijo der.
        return(getRight() == null);
    }
    public boolean leftEmpty(){ // devuelve 1 si no tiene hijo izq.
        return(getLeft() == null);
    }
    public boolean isTerminal(){ // devuelve 1 si el nodo es terminal
        return(getRight() == null && getLeft() == null);
    }

    // setters y getters
    public void setData(int data){
        this.data = data;
    }
    public void setParent(TreeNode parent){
        this.parent = parent;
    }
    public void setRight(TreeNode right){
        this.right = right;
    }
    public void setLeft(TreeNode left){
        this.left = left;
    }

    public int getData(){
        return data;
    }
    public TreeNode getParent(){
        return parent;
    }
    public TreeNode getRight(){
        return right;
    }
    public TreeNode getLeft(){
        return left;
    }
}
