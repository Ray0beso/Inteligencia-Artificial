package IA;

public class AppArbol {

	public static void main(String[] args) {
		
		Arbol<Integer> a = new Arbol<>();
		
		//Prueba método Vacio()

		if(a.Vacio()) 
			System.out.println("Arbol vacio");
		
		System.out.println();
		
		//Recorre el arbol en InOrden
		
		a.add(5);
		a.add(6);
		a.add(3);
		a.add(1);
		a.add(4);
		a.add(2);

		System.out.println("Arbol inorden:");
		
		a.InOrden();

	}
	
	//	CONSOLA:
	
/*
		Arbol vacio

		Arbol inorden:
		1
		2
		3
		4
		5
		6
	 
*/

}
