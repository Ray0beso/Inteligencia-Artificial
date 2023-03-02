

import java.util.Collection;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.PriorityQueue;

public class ArbolBusqueda {
    
    private Nodo raiz, nObjetivo;
    private String objetivo;
    private String tipoDeBusqueda;
    
    public ArbolBusqueda(String estadoInicial, String objetivo) {
        this.raiz = new Nodo(estadoInicial);
        this.objetivo = objetivo;
        this.nObjetivo = null;
        this.tipoDeBusqueda = "no definida";
    }
    
  //Busqueda por Anchura
    public void busquedaPorAnchura() {
    	
    	if(nObjetivo!=null) LimpiarArbol();
    	
    	tipoDeBusqueda = "Anchura";
        Nodo nodoActual = raiz;
        String estadoActual = raiz.getEstado();
        Collection<String> estadosVisitados = new LinkedList<>();
        Queue<Nodo> cola = new LinkedList<>();
        Collection<Nodo> hijos;
        
        while(!estadoActual.equals(objetivo)) {
            estadosVisitados.add(estadoActual);
            hijos = nodoActual.getHijos();
            for (Nodo hijo : hijos) {
                if(!estadosVisitados.contains(hijo.getEstado())) 
                    cola.add(hijo);
            }
            nodoActual = cola.poll();
            estadoActual = nodoActual.getEstado();
        }
        nObjetivo = nodoActual;
    }
    
  //Busqueda por Profundidad
    public void busquedaPorProfundidad() {
    	
    	if(nObjetivo!=null) LimpiarArbol();
    	
    	tipoDeBusqueda = "Profundidad";
        Nodo nodoActual = raiz;
        String estadoActual = raiz.getEstado();
        Collection<String> estadosVisitados = new LinkedList<>();
        Stack<Nodo> pila = new Stack<>();
        Collection<Nodo> hijos;
        
        while(!estadoActual.equals(objetivo)) {
            estadosVisitados.add(estadoActual);
            hijos = nodoActual.getHijos();
            for (Nodo hijo : hijos) {
                if(!estadosVisitados.contains(hijo.getEstado())) 
                    pila.add(hijo);
            }
            nodoActual = pila.pop();
            estadoActual = nodoActual.getEstado();
        }
        nObjetivo = nodoActual;
    }
    
  //Busqueda por Anchura
    public void busquedaPorHeuristica(int metodoHeuristico) {
    	
    	if(nObjetivo!=null) LimpiarArbol();
    	
    	tipoDeBusqueda = "Heurística "+metodoHeuristico;
    	raiz.setHeuristica(metodoHeuristico);
    	
        Nodo nodoActual = raiz;
        String estadoActual = raiz.getEstado();
        Collection<String> estadosVisitados = new LinkedList<>();
        PriorityQueue<Nodo> cola = new PriorityQueue<>(comparator());
        Collection<Nodo> hijos;
        
        while(!estadoActual.equals(objetivo)) {
            estadosVisitados.add(estadoActual);
            hijos = nodoActual.getHijos();
            for (Nodo hijo : hijos) {
                if(!estadosVisitados.contains(hijo.getEstado())) {
                    cola.add(hijo);
                    
                }
            }
            nodoActual = cola.poll();
            estadoActual = nodoActual.getEstado();
        }
        nObjetivo = nodoActual;
    }
    
    public Comparator<Nodo> comparator() {
        Comparator<Nodo> c = new Comparator<Nodo>() {
            @Override
            public int compare(Nodo n, Nodo n2) {
            	return n.ValorHeuristico(objetivo);
            }
        };
        return c;
    }

    private void LimpiarArbol() {
    	this.raiz = new Nodo(raiz.getEstado());
        this.nObjetivo = null;
    }
    
    public void imprimirSolucion() {
    	if(tipoDeBusqueda.equals("no definida")) {
    		System.out.println("Busqueda "+tipoDeBusqueda);
    		return;
    	}
	    Nodo n = nObjetivo;
	   	String salida = "";
	  	do {
		    salida = n+"\n"+salida;
		    n = n.getPadre();
	    }while(n != null);
	  	System.out.println(salida);
	  	System.out.println("Se econtró por busqueda en "+tipoDeBusqueda+"\n");
    }
    
}
