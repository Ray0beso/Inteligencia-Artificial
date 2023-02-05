package IA;

public class Nodo<E extends Comparable<E>> {

	private Nodo<E> izq;
	private E datos;
	private Nodo<E> der;

	public Nodo(Nodo<E> izq, E datos, Nodo<E> der) {
		this.izq = izq;
		this.datos = datos;
		this.der = der;
	}

	public Nodo(E datos) {
		this(null, datos, null);
	}

	public Nodo<E> getIzq() {
		return izq;
	}

	public void setIzq(Nodo<E> izq) {
		this.izq = izq;
	}

	public E getDatos() {
		return datos;
	}

	public void setDatos(E datos) {
		this.datos = datos;
	}

	public Nodo<E> getDer() {
		return der;
	}

	public void setDer(Nodo<E> der) {
		this.der = der;
	}

	@Override
	public String toString() {
		return datos.toString();
	}
}
