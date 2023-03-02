

public class Puzzle8 {

    public static void main(String[] args) {
    	
//    		String estadoInicial = "12578 346";
    	String estadoInicial = "41275386 ";
    	String estadoFinal   = "12345678 ";
    	
        
        //Instanciar el arbol
        ArbolBusqueda a = new ArbolBusqueda(estadoInicial, estadoFinal);
       
        
        // Mide algoritmo por anchura

        long inicio = System.nanoTime();

        a.busquedaPorAnchura();

        long fin = System.nanoTime();
        
        double TiempoAnchura = (double) (fin - inicio) / 1000000000;

        // Mide algoritmo por pr
        
        inicio = System.nanoTime();
        
        a.busquedaPorProfundidad();

        fin = System.nanoTime();
        
        double TiempoProfundidad = (double) (fin - inicio) / 1000000000;
      

        // Mide algoritmo heuristica 1
        
        inicio = System.nanoTime();

        a.busquedaPorHeuristica(1);

        fin = System.nanoTime();
        
        double TiempoHeuristica1 = (double) (fin - inicio) / 1000000000;

        // Mide algoritmo heuristica 2
        
        inicio = System.nanoTime();

        a.busquedaPorHeuristica(2);

        fin = System.nanoTime();
        
        double TiempoHeuristica2 = (double) (fin - inicio) / 1000000000;

        // Mide algoritmo heuristica 3
        
        inicio = System.nanoTime();

        a.busquedaPorHeuristica(3);

        fin = System.nanoTime();
        
        double TiempoHeuristica3 = (double) (fin - inicio) / 1000000000;
        
        // Imprime resultados
        
        System.out.println("Anchura: " + TiempoAnchura + " segundos");
        System.out.println("Profundidad: " + TiempoProfundidad + " segundos");
        System.out.println("Heuristica 1: " + TiempoHeuristica1 + " segundos");
        System.out.println("Heuristica 2: " + TiempoHeuristica2 + " segundos");
        System.out.println("Heuristica 3: " + TiempoHeuristica3 + " segundos");
    
    }
    
}

		/*  CONSOLA

		Anchura: 0.0029388 segundos
		Profundidad: 26.6111178 segundos
		Heuristica 1: 0.0043181 segundos
		Heuristica 2: 0.0031335 segundos
		Heuristica 3: 1.301E-4 segundos

	*/



