

import java.util.Collection;
import java.util.LinkedList;


public class Nodo {

	private String estado;
    private Nodo padre;
    private Collection<Nodo> hijos;
    private long profundidad;
    
    public Nodo(String estado) {
        this.estado = estado;
        this.padre = null;
        this.hijos = null;
        this.profundidad = 0;
    }
    
    public Nodo(String estado, Nodo padre, long profundidad) {
        this.estado = estado;
        this.padre = padre;
        this.hijos = null;
        this.profundidad = profundidad;
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
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(3)+estado.charAt(1)+estado.charAt(2)+estado.charAt(0)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
                
            case 1:
            	estadoTemp=""+estado.charAt(1)+estado.charAt(0)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(2)+estado.charAt(1)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(4)+estado.charAt(2)+estado.charAt(3)+estado.charAt(1)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
                
            case 2:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(2)+estado.charAt(1)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(5)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(2)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
            	
            case 3:
            	estadoTemp=""+estado.charAt(3)+estado.charAt(1)+estado.charAt(2)+estado.charAt(0)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(4)+estado.charAt(3)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(6)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(3)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
            	
            case 4: 
            	estadoTemp=""+estado.charAt(0)+estado.charAt(4)+estado.charAt(2)+estado.charAt(3)+estado.charAt(1)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(4)+estado.charAt(3)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(5)
            	+estado.charAt(4)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(7)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(4)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
            	
            case 5:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(5)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(2)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(5)
            	+estado.charAt(4)+estado.charAt(6)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));

            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(8)+estado.charAt(6)+estado.charAt(7)+estado.charAt(5);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
            	
            case 6:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(6)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(3)+estado.charAt(7)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(7)+estado.charAt(6)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
            	
            case 7:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(7)+estado.charAt(6)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(7)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(4)+estado.charAt(8);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(8)+estado.charAt(7);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
            	
            case 8:
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(5)+estado.charAt(6)+estado.charAt(8)+estado.charAt(7);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            	
            	estadoTemp=""+estado.charAt(0)+estado.charAt(1)+estado.charAt(2)+estado.charAt(3)+estado.charAt(4)
            	+estado.charAt(8)+estado.charAt(6)+estado.charAt(7)+estado.charAt(5);
            	hijos.add(new Nodo(estadoTemp, this, profundidad + 1 ));
            break;
       }
        
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
