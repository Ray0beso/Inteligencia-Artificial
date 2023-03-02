

public class Puzzle8 {

    public static void main(String[] args) {
    	
//    		String estadoInicial = "12578 346";
//      	String estadoInicial = "41275386 ";
    	String estadoInicial = "41275386 ";
    	String estadoFinal   = "12345678 ";
    	
        
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(estadoInicial, estadoFinal);
       
        //Realiza cada una de las busquedas y las imprime
        a.busquedaPorProfundidad();
        a.imprimirSolucion();
        
        a.busquedaPorAnchura();
        a.imprimirSolucion();
        
        a.busquedaPorHeuristica(1);
        a.imprimirSolucion();
        
        a.busquedaPorHeuristica(2);
        a.imprimirSolucion();
        
        a.busquedaPorHeuristica(3);
        a.imprimirSolucion();
    
    }
    
}
