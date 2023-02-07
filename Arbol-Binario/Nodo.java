package IA;

@SuppressWarnings("hiding")
public class Nodo<String extends Comparable<String>> {

	private Nodo<String> izq;
	private String nombre;
	private Nodo<String> der;

	public Nodo(Nodo<String> izq, String nombre, Nodo<String> der) {
		this.izq = izq;
		this.nombre = nombre;
		this.der = der;
	}

	public Nodo(String nombre) {
		this(null, nombre, null);
	}

	public Nodo<String> getIzq() {
		return izq;
	}

	public void setIzq(Nodo<String> izq) {
		this.izq = izq;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Nodo<String> getDer() {
		return der;
	}

	public void setDer(Nodo<String> der) {
		this.der = der;
	}

	public java.lang.String NodotoString() {
		try {
			return " > Nodo {NodoIzquierda: \""+izq.nombre+"\", EsteNodo: \""+nombre+"\", NodoDerecha: \""+der.nombre+"\"}";
		}catch(Exception e) {}

		try {
			return " > Nodo {NodoIzquierda: null, EsteNodo: \""+nombre+"\", NodoDerecha: \""+der.nombre+"\"}";
		}catch(Exception e) {}
		
		try {
			return " > Nodo {NodoIzquierda: \""+izq.nombre+"\", EsteNodo: \""+nombre+"\", NodoDerecha: null}";
		}catch(Exception e) {}
		
		try {
			return " > Nodo {NodoIzquierda: null, EsteNodo: \""+nombre+"\", NodoDerecha: null}";
		}catch(Exception e) {}

		return " > Nodo {null}";
	}

	@Override
	public java.lang.String toString() {
		return NodotoString();
	}
}
