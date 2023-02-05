package IA;

public class Arbol<E extends Comparable<E>> {

	private Nodo<E> raiz;

	public Arbol() {
		this.raiz = null;
	}
	
	// Método Vacio

	public boolean Vacio() {
		return raiz == null;
	}
	
	// Orden de busqueda preorden, inorden y postorden (2 extra)

	public void PreOrden() {
		PreOrden(raiz);
	}

	private void PreOrden(Nodo<E> ap) {
		if (ap != null) {
			System.out.println(ap.getDatos());
			PreOrden(ap.getIzq());
			PreOrden(ap.getDer());
		}
	}

	public void InOrden() {
		InOrden(raiz);
	}

	private void InOrden(Nodo<E> ap) {
		if (ap != null) {
			InOrden(ap.getIzq());
			System.out.println(ap.getDatos());
			InOrden(ap.getDer());
		}
	}

	public void PostOrden() {
		PostOrden(raiz);
	}

	private void PostOrden(Nodo<E> ap) {
		if (ap != null) {
			PostOrden(ap.getIzq());
			PostOrden(ap.getDer());
			System.out.println(ap.getDatos());
		}
	}
	
	// --- Métodos extra ---

	public boolean add(E datos) {
		if (Vacio()) {
			raiz = new Nodo<>(datos);
			return true;
		}
		return add(datos, raiz);
	}

	private boolean add(E datos, Nodo<E> r) {
		if (r != null) {
			if (datos.compareTo(r.getDatos()) < 0) {
				if (r.getIzq() != null) // Si hay nodo en la parte izquierda,
					// nos movemos
					return add(datos, r.getIzq());
				else { // si no, agregamos el nuevo nodo
					r.setIzq(new Nodo<>(datos));
					return true;
				}
			}
			if (datos.compareTo(r.getDatos()) > 0) {
				if (r.getDer() != null) // Si hay nodo en la parte derecha, nos
					// movemos
					return add(datos, r.getDer());
				else { // si no, agregamos el nuevo nodo
					r.setDer(new Nodo<>(datos));
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public void clear() {
		raiz = null;
	}
	
	public int CuentaNodos(Nodo<E> R) {
		return (R != null) ? CuentaNodos(R.getIzq()) + CuentaNodos(R.getDer()) + 1 : 0;
	}

	public void balancea() {
		balancea(raiz);
	}

	private void balancea(Nodo<E> R) {
		if (R != null) {
			int NI = CuentaNodos(R.getIzq());
			int ND = CuentaNodos(R.getDer());
			if (NI > ND) {
				if ((NI - ND) > 1)
					PasaADerecha(R, (NI - ND) / 2);
			} else {
				if ((ND - NI) > 1)
					PasaAIzquierda(R, (ND - NI) / 2);
			}
			balancea(R.getIzq());
			balancea(R.getDer());
		}
	}

	public boolean set(E dato) {
		return set(dato, raiz);
	}

	private boolean set(E dato, Nodo<E> R) {
		if (R == null)
			return false;
		else {
			if (dato.compareTo(R.getDatos()) < 0)
				return set(dato, R.getIzq());
			else if (dato.compareTo(R.getDatos()) > 0)
				return set(dato, R.getDer());
			else {
				R.setDatos(dato);
				return true;
			}
		}
	}

	public Nodo<E> getRaiz() {
		return raiz;
	}

	private void PasaAIzquierda(Nodo<E> R, int Cant) {
		if (Cant > 0 && R != null) {
			// Paso 1 Duplicar raiz en el subarbol izquierda
			if (R.getIzq() != null)
				add(R.getDatos(), R.getIzq());
			else
				R.setIzq(new Nodo<>(R.getDatos()));
			// Paso 2 Sustituir raiz con el menor de los mayores
			Nodo<E> ap = R.getDer();
			while (ap.getIzq() != null)
				ap = ap.getIzq();
			R.setDatos(ap.getDatos());
			// Paso 3 Borrar el menor de los mayores
			remove(ap.getDatos(), R.getDer(), R);
			PasaAIzquierda(R, Cant - 1);
		}
	}

	private void PasaADerecha(Nodo<E> R, int Cant) {
		if (Cant > 0 && R != null) {
			// Paso 1 Duplicar raiz en el subarbol derecho
			if (R.getDer() != null)
				add(R.getDatos(), R.getDer());
			else
				R.setDer(new Nodo<>(R.getDatos()));
			// Paso 2 Sustituir raiz con el mayor de los menores
			Nodo<E> ap = R.getIzq();
			while (ap.getDer() != null)
				ap = ap.getDer();
			R.setDatos(ap.getDatos());
			// Paso 3 Borrar el mayor de los menores
			remove(ap.getDatos(), R.getIzq(), R);
			PasaADerecha(R, Cant - 1);
		}
	}

	public boolean remove(E datoBusqueda) {
		return remove(datoBusqueda, raiz, raiz);
	}

	public boolean remove(E dato, Nodo<E> R, Nodo<E> RA) {
		Nodo<E> ap;
		if (R == null)
			return false;
		else {
			if (dato.compareTo(R.getDatos()) < 0)
				return remove(dato, R.getIzq(), R);
			else {
				if (dato.compareTo(R.getDatos()) > 0)
					return remove(dato, R.getDer(), R);
				else {
					// Cuando tenga 2 hijos
					if (R.getDer() != null && R.getIzq() != null) {
						if (CuentaNodos(R.getIzq()) > CuentaNodos(R.getDer())) {
							// El mayor de los menores
							ap = R.getIzq();
							while (ap.getDer() != null)
								ap = ap.getDer();
							R.setDatos(ap.getDatos());
							return remove(ap.getDatos(), R.getIzq(), R);
						} else {
							// El menor de los mayores
							ap = R.getDer();
							while (ap.getIzq() != null)
								ap = ap.getIzq();
							R.setDatos(ap.getDatos());
							return remove(ap.getDatos(), R.getDer(), R);
						}
					} else {
						// Cuando tenga 0 o 1 hijo y se trata de la raiz
						// principal la que vamos a eliminar
						if (R == RA)
							if (R.getIzq() == null) // Cuando ya es el ultimo nodo que queda en el arbol
								raiz = R.getIzq();
							else
								raiz = R.getDer();
						else // Cuando es el penultimo nodo que queda en el arbol
						if (R.getIzq() == null)
							if (RA.getIzq() == R)
								RA.setIzq(R.getDer());
							else
								RA.setDer(R.getDer());
						else if (RA.getIzq() == R)
							RA.setIzq(R.getIzq());
						else
							RA.setDer(R.getIzq());
						return true;
					}
				}
			}
		}
	}

	public E find(E dato) {
		return find(dato, raiz);
	}

	private E find(E dato, Nodo<E> R) {
		if (R == null)
			return null;
		else {
			if (dato.compareTo(R.getDatos()) < 0)
				return find(dato, R.getIzq());
			else if (dato.compareTo(R.getDatos()) > 0)
				return find(dato, R.getDer());
			else
				return R.getDatos();
		}
	}

}
