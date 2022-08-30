package arbol;
/**
 *
 * @author fires
 * blog: http://proyectosbeta.blogspot.com/
 */
public class AVLNode {
    public int dato;      	 // el dato del nodo
    public AVLNode izquierdo;            // hijo izquierdo
    public AVLNode derecho;              // hijo derecho
    public int height;                   // altura

    // Constructors
    public AVLNode( int dato ){
        this( dato, null, null );
    }

    public AVLNode( int dato, AVLNode izq, AVLNode der ){
        this.dato = dato;
        this.izquierdo = izq;
        this.derecho = der;
        height   = 0;               // altura predeterminada
    }
}
