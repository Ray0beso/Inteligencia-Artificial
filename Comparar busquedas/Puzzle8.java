

public class Puzzle8 {

    public static void main(String[] args) {
    	

    	String estadoInicialRapido = "1524 3786";
    	String estadoInicialMedio = "41275386 ";
    	String estadoIniciaTardado = "87 536412";

    	String [] estados = { estadoInicialRapido, estadoInicialMedio, estadoIniciaTardado };
    	long inicio=0, fin=0;
    	ArbolBusqueda a ;
    	
    	String estadoFinal   = "12345678 ";
        System.out.println(" >> Comparativa de búsquedas");
        
        for (String estado : estados) {
    	
	        a = new ArbolBusqueda(estado, estadoFinal);
	       
	        // Mide algoritmo por anchura
	        inicio = System.nanoTime();
	        a.busquedaPorAnchura();
	        fin = System.nanoTime();
	        
	        double TiempoAnchura = (double) (fin - inicio) / 1000000000;
	
	        // Mide algoritmo por profundidad
	        
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
	        
	        
	        System.out.println("\n Estado: '"+estado+"'\n");
	        System.out.println("  Anchura:      \t" + TiempoAnchura + "   \tsegundos");
	        System.out.println("  Profundidad:  \t" + TiempoProfundidad + "   \tsegundos");
	        System.out.println("  Heuristica 1: \t" + TiempoHeuristica1 + "   \tsegundos");
	        System.out.println("  Heuristica 2: \t" + TiempoHeuristica2 + "   \tsegundos");
	        System.out.println("  Heuristica 3: \t" + TiempoHeuristica3 + "   \tsegundos");
    
        }
    }
    
    		/*
    		 
    		 
    		  >> Comparativa de búsquedas

			 Estado: '1524 3786'
			
			  Anchura:      	0.0012386   	segundos
			  Profundidad:  	0.0031393   	segundos
			  Heuristica 1: 	0.0025172   	segundos
			  Heuristica 2: 	2.303E-4   		segundos
			  Heuristica 3: 	1.703E-4   		segundos
			
			 Estado: '41275386 '
			
			  Anchura:      	0.0091698   	segundos
			  Profundidad:  	61.3905956   	segundos
			  Heuristica 1: 	0.0031957   	segundos
			  Heuristica 2: 	0.0027784   	segundos
			  Heuristica 3: 	1.033E-4   		segundos

    		 
    		  ...
    		 
    		 
    		 */
    
}