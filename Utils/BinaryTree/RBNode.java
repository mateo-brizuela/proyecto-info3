package Utils.BinaryTree;

public class RBNode extends TreeNode {
    private Color color; // rojo o negro

    // constructores
    public RBNode(int data){
        this.data = data;
        color = Color.RED;
    }
    public RBNode(int data, TreeNode parent){
        this.data = data;
        color = Color.RED;
        this.parent = parent;
    }

    @Override
    public String toString() {
        return (getData() + " " + getColor());
    }

    public boolean isRed(){ // devuelve 1 si el nodo es rojo
        return(getColor() == Color.RED);
    }

    public void setColor(Color color){
        this.color = color;
    }
    public Color getColor(){
        return color;
    }
}
