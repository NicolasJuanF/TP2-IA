package dominio;


public class Enlace {
	private Nodo nodoInicio;
	private Nodo nodoDestino;
	
	public Enlace(){
		
	}
	public Enlace(Nodo inicio, Nodo destino){
		this.nodoInicio = inicio;
		this.nodoDestino = destino;
	}
	
	public boolean equals(Enlace unEnlace){ 
		return (nodoInicio.equal(unEnlace.getNodoInicio())&& nodoDestino.equal(unEnlace.getNodoDestino())); 
	}
	//Mira si el inicio del enlace es igual a otro
	public boolean inicioIguales(Enlace unEnlace){ 
		return nodoInicio.equal(unEnlace.getNodoInicio());
	}
	//Mira si el destino del enlace es igual a otro
	public boolean destinoIguales(Enlace unEnlace){ 
		return nodoDestino.equal(unEnlace.getNodoDestino());
	}
	//Comparan si los NODOS iniciales de cada enlace son iguales
	public boolean inicioIguales(Nodo unNodo){ 
		return nodoInicio.equal(unNodo); 
	}
	//Comparan si los NODOS destinos de cada enlace son iguales
	public boolean destinoIguales(Nodo unNodo){ 
		return nodoDestino.equal(unNodo); 
	}
	
	public void setNodoInicio(Nodo nodoInicio) {
		this.nodoInicio = nodoInicio;
	}
	public Nodo getNodoInicio() {
		return nodoInicio;
	}
	public void setNodoDestino(Nodo nodoDestino) {
		this.nodoDestino = nodoDestino;
	}
	public Nodo getNodoDestino() {
		return nodoDestino;
	}
}
