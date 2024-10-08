package ProyectoJava.Practico8;

public class NodoArbol {
    private NodoArbol right;
    private NodoArbol left;
    private int altura; // es la cantidad de conexiones desde el nodo hasta el nodo terminal mas lejano
    private int profundidad; // es la cantidad de conexxiones desde el nodo hasta el nodo raiz
    private int size; // el equilibrio del nodo
    private int dato; //dato del nodo

    
    public String toString(){
        return "numero: " + dato;
    }

    //constructores
    public NodoArbol(int dato){
        right = null;
        left = null;
        this.dato = dato;
    }

    public NodoArbol(int dato, NodoArbol left, NodoArbol right){
        this.dato = dato;
        this.left = left;
        this.right = right;
    }

    public boolean leftEmpty(){
        return left == null;
    }

    public boolean rightEmpty(){
        return right == null;
    }

    // getters y setters
    public NodoArbol getLelft(){
        return left;
    }

    public void setLeft(NodoArbol left){
        this.left = left;
    }

    public NodoArbol getRight(){
        return right;
    }

    public void setRight(NodoArbol right){
        this.right = right;
    }

    public int getDato(){
        return dato;
    }

    public void setDato(int dato){
        this.dato = dato;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public void setProfundidad(int profundidad){
        this.profundidad = profundidad;
    }

    public int getProfundidad(){
        return profundidad;
    }
    

}
