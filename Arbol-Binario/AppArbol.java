package IA;

public class AppArbol {

	public static void main(String[] args) {
		
		Arbol<String> a = new Arbol<String>();
		String [] nombres = {"Luis", "Pedro", "Carlos", "Juan", "Antonio", "Manuel"};
		
	  //Prueba m�todo Vacio(): boolean
		
		if(a.Vacio()) 
			System.out.println("Arbol vacio");
		else
			System.out.println("Arbol no vacio");
		
	  //Prueba m�todo BuscarNodo(): Nodo<String> (InOrden)
		
		System.out.println();
		for(String nombre : nombres) {
			System.out.println(a.buscarNodo(nombre));
		}
		
	  //Prueba m�todo Insertar()

		for(String nombre : nombres) {
			a.Insertar(nombre);
		}

		System.out.println("\nAhora si se insertaron los nombres");
		
	  //Prueba m�todo Vacio - otra vez
			
		System.out.println();
		if(a.Vacio()) 
			System.out.println("Arbol vacio");
		else
			System.out.println("Arbol NO vacio");
		
	  //Prueba m�todo ImprimirArbol()

		System.out.println("\nArbol InOrden:");
		a.ImprimirArbol();
		
	  //Prueba m�todo BuscarNodo - otra vez
		
		System.out.println();
		for(String nombre : nombres) {
			System.out.println(a.buscarNodo(nombre));
		}

	}
	
	  // CONSOLA:
	
	/*

		Arbol vacio
		
		null
		null
		null
		null
		null
		null
		
		Ahora si se insertaron los nombres
		
		Arbol NO vacio
		
		Arbol InOrden:
		Antonio
		Carlos
		Juan
		Luis
		Manuel
		Pedro
		
		 > Nodo�{NodoIzquierda: "Carlos", EsteNodo: "Luis", NodoDerecha: "Pedro"}
		 > Nodo�{NodoIzquierda: "Manuel", EsteNodo: "Pedro", NodoDerecha: null}
		 > Nodo�{NodoIzquierda: "Antonio", EsteNodo: "Carlos", NodoDerecha: "Juan"}
		 > Nodo�{NodoIzquierda: null, EsteNodo: "Juan", NodoDerecha: null}
		 > Nodo�{NodoIzquierda: null, EsteNodo: "Antonio", NodoDerecha: null}
		 > Nodo�{NodoIzquierda: null, EsteNodo: "Manuel", NodoDerecha: null}

	 
	 */

}
