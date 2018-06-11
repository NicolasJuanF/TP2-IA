package dominio;

import java.util.Vector;

public class Mapa {
	
	Vector<Enlace> enlaces;
	Vector<Nodo> nodos;
	
	public Mapa(){
		enlaces = new Vector<Enlace>();
		nodos = new Vector<Nodo>(); 
	}
	public void agregarNodo(int x, int y, int piso, String descripcion){ 
		nodos.addElement(new Nodo(x, y, piso, descripcion)); 
	}
	public void agregarEnlace(Enlace enlace){ 
		enlaces.addElement(enlace); 
	}

	public Nodo buscarNodo(int x, int y, int piso){ 
		int maximo = nodos.size();
		int i = 0;
		Nodo salida = null;
		while (i < maximo){ 
			if ((((Nodo)nodos.elementAt(i)).getX()==x)&&(((Nodo)nodos.elementAt(i)).getY()==y)&&(((Nodo)nodos.elementAt(i)).getPiso()==piso)){ 
				salida = ((Nodo)nodos.elementAt(i));
				i = maximo;
			}
			else i ++; 
		}
		return salida;
	}
	
	public Nodo buscarNodo(String descripcion){ 
		int maximo = nodos.size();
		int i = 0;
		Nodo salida = null;
		while (i < maximo){ 
			if (nodos.elementAt(i).getDescripcion() == descripcion){
				salida = ((Nodo)nodos.elementAt(i));
				i = maximo;
			}
			else i ++; 
		}
		return salida;
	}
	
	public Vector<Nodo> buscarAdyacentes(Nodo unNodo){
		Vector<Nodo> salida = new Vector<Nodo>();
		for(int i = 0; i < enlaces.size(); i++)
			if(((Enlace)enlaces.elementAt(i)).inicioIguales(unNodo))
				salida.addElement(((Enlace)enlaces.elementAt(i)).getNodoDestino());
		return salida;
	}
	
	
	
	public Vector<Nodo> listaNodos(){ 
		return nodos;
	}
	public Vector<Enlace> listaEnlace(){ 
		return enlaces;
	}
	
	public void conectar(int x1, int y1, int piso1, int x2, int y2, int piso2){ 
		Nodo nodo1; 
		Nodo nodo2;
		nodo1 = this.buscarNodo(x1, y1, piso1);
		nodo2 = this.buscarNodo(x2, y2, piso2);
		if((null != nodo1) && (null != nodo2)){ 
			enlaces.addElement(new Enlace(nodo1,nodo2));
			enlaces.addElement(new Enlace(nodo2,nodo1));
		}
	}
	
}
