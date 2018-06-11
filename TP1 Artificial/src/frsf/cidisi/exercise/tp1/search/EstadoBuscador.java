package frsf.cidisi.exercise.tp1.search;

import java.util.Vector;

import dominio.Coordenadas;
import dominio.Enlace;
import dominio.Mapa;
import dominio.Nodo;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;

/**
 * Represent the internal state of the Agent.
 */
public class EstadoBuscador extends SearchBasedAgentState {
	
    private Mapa mapa;
    private Vector<Nodo> posicionesBloqueadas;
    private Nodo posicionElegida;
    private Nodo posicionActual;
    private Nodo ultimaPosicionVisitada;
    private int energiaTotal;
    private int energiaConsumida;
    
    public EstadoBuscador() {
        this.initState();
    }

    public EstadoBuscador(String inicio, String fin) {
		this.initState(inicio,fin);
	}


	/**
     * This method clones the state of the agent. It's used in the search
     * process, when creating the search tree.
     */
    @Override
    public SearchBasedAgentState clone() {
        
    	EstadoBuscador newState = new EstadoBuscador(this.getposicion().getDescripcion(), this.getposicionElegida().getDescripcion());
    	
    	Mapa newMapa = new Mapa();
	    for(Nodo n : this.getMapa().listaNodos())
	    	newMapa.agregarNodo(n.getX(), n.getY(), n.getPiso(), n.getDescripcion());
	    for(Enlace e : this.getMapa().listaEnlace())
	    	newMapa.agregarEnlace(e);
	    newState.setMapa(newMapa);
	    
	    Vector<Nodo> newNodosBloqueados = new Vector<Nodo>();
	    for(Nodo n : this.getposicionesBloqueadas())
	    	newNodosBloqueados.add(new Nodo(n.getX(), n.getY(), n.getPiso(), n.getDescripcion()));
	    newState.setposicionesBloqueadas(newNodosBloqueados);
	    
	    newState.setposicionElegida(this.posicionElegida.clone());
	    newState.setposicion(this.getposicion().clone());
    	newState.setenergiaConsumida(this.energiaConsumida);
    	newState.setenergiaTotal(this.energiaTotal);
    	newState.setUltimaPosicionVisitada(this.ultimaPosicionVisitada);
    	
        return newState;
    }

    /**
     * This method is used to update the Agent State when a Perception is
     * received by the Simulator.
     */
    @Override
    public void updateState(Perception p) {
    	BuscadorAgentePerception percepcion = (BuscadorAgentePerception) p;
    	Vector<Nodo> nuevoVector = new Vector<Nodo>();
    	for(Nodo n : this.getposicionesBloqueadas()){
    		nuevoVector.add(n);
    	}
    	for(Nodo e : percepcion.getposicionesBloqueadas()){
    		nuevoVector.add(e);
    	}
    	setposicionesBloqueadas(nuevoVector);

    }
    /**
     * This method is optional, and sets the initial state of the agent.
     */
    @Override
    public void initState() {
        
    	posicionesBloqueadas = new Vector<Nodo>();
    	mapa = new Mapa();
    	Coordenadas coordenadas = new Coordenadas();
    	mapa = coordenadas.getMapa();
    	ultimaPosicionVisitada = posicionActual;
    	energiaTotal = 1000;
    	energiaConsumida = 0;
    	
    }
    
    private void initState(String inicio, String fin) {
    	posicionesBloqueadas = new Vector<Nodo>();
    	mapa = new Mapa();
    	Coordenadas coordenadas = new Coordenadas();
    	mapa = coordenadas.getMapa();
    	posicionElegida = mapa.buscarNodo(fin);
    	posicionActual = mapa.buscarNodo(inicio);
    	ultimaPosicionVisitada = posicionActual;
    	energiaTotal = 1000;
    	energiaConsumida = 0;
	}

    /**
     * This method returns the String representation of the agent state.
     */
    @Override
    public String toString() {
        String str = "Estado del Agente: \n";
        str += "Posicion actual: X = "+posicionActual.getX()+", Y = "+posicionActual.getY()+", Piso = "+posicionActual.getPiso()+".\n";
        str += "Ultima posicion visitada: "+ultimaPosicionVisitada.getX()+", "+ultimaPosicionVisitada.getY();
        str += "\nEnergia consumida: "+energiaConsumida+".\n";
        
        return str;
    }

    /**
     * This method is used in the search process to verify if the node already
     * exists in the actual search.
     */
    @Override
     public boolean equals(Object obj) {
       
    	EstadoBuscador estadoComparado = (EstadoBuscador) obj;
        
    	boolean mismoNodo = estadoComparado.getposicion().getX() == this.getposicion().getX() &&
    						estadoComparado.getposicion().getY() == this.getposicion().getY() &&
    						estadoComparado.getposicion().getPiso() == this.getposicion().getPiso();
    	
    	return mismoNodo && (estadoComparado.getUltimaPosicionVisitada().equal(this.getUltimaPosicionVisitada()));
     }
   
     public int getenergiaTotal(){
        return energiaTotal;
     }
     public void setenergiaTotal(int arg){
        energiaTotal = arg;
     }
     public int getenergiaConsumida(){
        return energiaConsumida;
     }
     public void setenergiaConsumida(int arg){
        energiaConsumida = arg;
     }
     public Mapa getMapa(){
        return mapa;
     }
     public void setMapa(Mapa arg){
        mapa = arg;
     }
     public Nodo getposicionElegida(){
        return posicionElegida;
     }
     public void setposicionElegida(Nodo arg){
        posicionElegida = arg;
     }
     public Nodo getposicion(){
         return posicionActual;
     }
     public void setposicion(Nodo arg){
        posicionActual = arg;
     }
     
     public void setUltimaPosicionVisitada(Nodo ultimaPosicionVisitada) {
    	 this.ultimaPosicionVisitada = ultimaPosicionVisitada;
     }

     public Nodo getUltimaPosicionVisitada() {
    	 return ultimaPosicionVisitada;
     }

	public void setposicionesBloqueadas(Vector<Nodo> posicionesBloqueadas) {
		this.posicionesBloqueadas = posicionesBloqueadas;
	}

	public Vector<Nodo> getposicionesBloqueadas() {
		return posicionesBloqueadas;
	}
}

