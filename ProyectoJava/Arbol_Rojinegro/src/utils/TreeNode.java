package ProyectoJava.Arbol_Rojinegro.src.utils;

public class TreeNode {
    // ------------------ Atributos ------------------
    // informacion sobre el nodo
    private int data; // dato guardado en el nodo
    private Color color; // rojo o negro
    private int hight; // como es un arbol rojinegro, hight = cant. de nodos NEGROS a uno terminal
    // conexiones entre nodos
    private TreeNode parent; // nodo padre
    private TreeNode right; // nodo hijo derecho
    private TreeNode left; // nodo hijo izquierdo

    // ------------------ Metodos ------------------
    // constructores
    public TreeNode(int data){
        this.data = data;
        color = Color.RED;
    }
    public TreeNode(int data, TreeNode parent){
        this.data = data;
        color = Color.RED;
        this.parent = parent;
    }

    // metodos no triviales
    public boolean isRed(){ // devuelve 1 si el nodo es rojo
        return(getColor() == Color.RED);
    }
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
    public void setColor(Color color){
        this.color = color;
    }
    public void setHight(int hight){
        this.hight = hight;
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
    public Color getColor(){
        return color;
    }
    public int getHight(){
        return hight;
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
