

import java.util.Collection;
import java.util.LinkedList;

public class Nodo {

    private String estado;
    private Nodo padre;
    private Collection<Nodo> hijos;
    private long profundidad;
    private char heuristica;
 
    public Nodo(String estado) {
        this.estado = estado;
        this.padre = null;
        this.hijos = null;
        this.profundidad = 0;
        this.heuristica = '0';
    }
    
    public Nodo(String estado, Nodo padre, long profundidad, char heuristica) {
        this.estado = estado;
        this.padre = padre;
        this.hijos = null;
        this.profundidad = profundidad;
        this.heuristica = heuristica;
    }

    public void setHeuristica(int heuristica) {
        this.heuristica = (char) heuristica;
    }
    
    public String getEstado() {
        return estado;
    }

    public Collection<Nodo> getHijos() {
    	generaHijos();
        return hijos;
    }
    
    public Nodo getPadre() {
        return padre;
    }
    
    private void generaHijos() {
    	
        int i = estado.indexOf(" ");
        String estadoTemp;
        
        if (hijos == null)
        	hijos = new LinkedList<Nodo>();
        
        switch(i) {
            case 0:
      
            	estadoTemp=""+estado.charAt(1)+estado.charAt(0)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(3)+estado.charAt(1)+estado.charAt(2)+estado.charAt(0)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
                
            case 1:
            	estadoTemp=""+estado.charAt(1)+estado.charAt(0)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(2)+estado.charAt(1)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(4)+estado.charAt(2)+estado.charAt(3)+estado.charAt(1)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
                
            case 2:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(2)+estado.charAt(1)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(5)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(2)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
            	
            case 3:
            	estadoTemp=""+estado.charAt(3)+estado.charAt(1)+estado.charAt(2)+estado.charAt(0)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(4)+estado.charAt(3)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(6)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(3)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
            	
            case 4: 
            	estadoTemp=""+estado.charAt(0)+estado.charAt(4)+estado.charAt(2)+estado.charAt(3)+estado.charAt(1)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(4)+estado.charAt(3)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(5)
            	+estado.charAt(4)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(7)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(4)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
            	
            case 5:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(5)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(2)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(5)
            	+estado.charAt(4)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(8)+estado.charAt(6)+estado.charAt(7)+estado.charAt(5);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
            	
            case 6:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(6)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(3)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(7)+estado.charAt(6)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
            	
            case 7:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(7)+estado.charAt(6)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(7)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(4)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(8)+estado.charAt(7);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
            	
            case 8:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(8)+estado.charAt(7);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(8)+estado.charAt(6)+estado.charAt(7)+estado.charAt(5);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1, heuristica ));
            break;
       }
        
    }

      public int ValorHeuristico(String objetivo) {
		switch(heuristica) {
			case 1:
				return Heuristica1(objetivo);
			case 2:
				return Heuristica2(objetivo);
			case 3:
				return Heuristica3(objetivo);
		}
		return 0;
	}
	
	private int Heuristica1(String objetivo) {
		
		int valorHeuristico = 0;
		
		for(int i = 0; i < estado.length(); i++) {
			if(this.estado.charAt(i) != objetivo.charAt(i)) {
				valorHeuristico++;
			}
		}
		return valorHeuristico;
	}

	private int Heuristica2(String objetivo) {
		
		int valorheuristico = 0, caracter1 = 0, caracter2 = 0, valorheuricaracter = 0;
		
		for(int i = 0; i < estado.length(); i++) {
			valorheuricaracter = 0;
			caracter1 = (int) estado.charAt(i);
			caracter2 = (int) objetivo.charAt(i);
			valorheuricaracter = caracter1 - caracter2;
			valorheuricaracter = Math.abs(valorheuricaracter);
			valorheuristico += valorheuricaracter;
		}
		return valorheuristico;
	}

	private int Heuristica3(String objetivo) {
		return this.estado.compareTo(objetivo);
	}
    
	@Override
	public String toString() {
		return "Nivel: " + profundidad + "\n"
			  +"    |\n"
			  +"    V\n"
			  +" |"+estado.charAt(0)+"|"+estado.charAt(1)+"|"+estado.charAt(2)+"|\n"
			  +" |"+estado.charAt(3)+"|"+estado.charAt(4)+"|"+estado.charAt(5)+"|\n"
			  +" |"+estado.charAt(6)+"|"+estado.charAt(7)+"|"+estado.charAt(8)+"|\n";
	}
	
}



