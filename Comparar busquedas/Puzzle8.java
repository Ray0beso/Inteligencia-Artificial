

public class Puzzle8 {

    public static void main(String[] args) {
    	
    	String estadoInicialRapido = "1524 3786",
    		   estadoInicialMedio  = "1 5723486",
    		   estadoIniciaTardado = "12578 346",
    		   
    		   estadoFinal   = "12345678 ";
    	
    	String [] estados = { estadoInicialRapido, estadoInicialMedio, estadoIniciaTardado };
    	long inicio, fin;
    	ArbolBusqueda a ;
    	double Tiempo;
    	
        System.out.println(" >> Comparativa de búsquedas");
        
        for (String estado : estados) {
    	
	        a = new ArbolBusqueda(estado, estadoFinal);
	        System.out.println("\n Estado: '"+estado+"'\n");
	        
	        for (int i= 0; i < 5; i++) {
	        	inicio = System.nanoTime();
		    		switch(i) {
	    				case 0:
	    					a.busquedaPorAnchura();
	    					break;
		    			case 1:
		    				a.busquedaPorProfundidad();
		    				break;
		    			default:
		    				a.busquedaPorHeuristica((i - 1));
		    				break;
		    		}
		        fin = System.nanoTime();
		        Tiempo = (double) (fin - inicio) / 1000000000;
		        System.out.println(NombreBusqueda(i)+":      \t" + Tiempo + "   \tsegundos");
	        }
        }
    }
    
    public static String NombreBusqueda(int indice) {
    	switch(indice) {
			case 0:
				return "  Anchura";
			case 1:
				return "  Profundidad";
			default:
				return "  Heuristica " + (indice - 1);
    	}
    }
}
    
/*
    		        - - - - - - - - - - - - -
    		        - - - C O N S O L A - - -
    		        - - - - - - - - - - - - -
    		 
 		 >> Comparativa de búsquedas

		 Estado: '1524 3786'
		
		  Anchura:      	0.0069155   	segundos
		  Profundidad:      	0.0578025   	segundos
		  Heuristica 1:      	0.0021797   	segundos
		  Heuristica 2:      	0.0010725   	segundos
		  Heuristica 3:      	2.447E-4   	segundos
		
		 Estado: '1 5723486'
		
		  Anchura:      	2.1894798   	segundos
		  Profundidad:      	9.1209579   	segundos
		  Heuristica 1:      	0.0151911   	segundos
		  Heuristica 2:      	0.2855567   	segundos
		  Heuristica 3:      	0.3906259   	segundos
		
		 Estado: '12578 346'
		
		  Anchura:      	48.6934367   	segundos
		  Profundidad:      	363.9081815   	segundos
		  Heuristica 1:      	0.0019248   	segundos
		  Heuristica 2:      	0.0657379   	segundos
		  Heuristica 3:      	0.0063561   	segundos

    		 
*/
    

