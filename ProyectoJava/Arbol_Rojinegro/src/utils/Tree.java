package ProyectoJava.Arbol_Rojinegro.src.utils;

public abstract class Tree {
    
    public void printTree(TreeNode node, String space){
        if(node == null) return;
        
        space += "      ";
        printTree(node.getRight(), space);
        System.out.println(space + node.getData() + " " + node.getColor());
        printTree(node.getLeft(), space);
    }

}
