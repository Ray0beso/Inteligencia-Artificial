

public class Puzzle8 {

//	public static String estadoInicial = "12578 346";
    public static String estadoInicial = "41275386 ";
    public static String estadoFinal = "12345678 ";
    
    public static void main(String[] args) {
        
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(estadoInicial, estadoFinal);
        
        //Ejecuta la busqueda
        a.busquedaPorProfundidad();
        
        //Imprime arbol
        a.imprimirSolucion();
        
        // Cambia nodos del arbol por la busqueda en anchura
        a.busquedaPorAnchura();

        //Imprime arbol
        a.imprimirSolucion();
        
    }
    
}
