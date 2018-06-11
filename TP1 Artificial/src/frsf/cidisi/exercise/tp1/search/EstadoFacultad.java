package frsf.cidisi.exercise.tp1.search;

import java.util.HashSet;
import java.util.Vector;

import dominio.Coordenadas;
import dominio.Mapa;
import dominio.Nodo;

import frsf.cidisi.faia.state.EnvironmentState;

/**
 * This class represents the real world state.
 */
public class EstadoFacultad extends EnvironmentState {
    
	private Mapa mapa;
    private Nodo posicionActual;
    private Vector<Nodo> posicionesBloqueadas;
    private int energiaTotal;    
    private int energiaConsumida;

    public EstadoFacultad(String inicio, HashSet<Nodo> listaBloqueados) {
    	this.initState(inicio, listaBloqueados);
	}

	@Override
	public void initState() {
    }
	
    public void initState(String inicio, HashSet<Nodo> listaBloqueados) {

    	mapa = new Mapa();
    	posicionesBloqueadas = new Vector<Nodo>();
    	Coordenadas coordenadas = new Coordenadas();
    	mapa = coordenadas.getMapa();
    	
    	for(Nodo n : listaBloqueados){
    		posicionesBloqueadas.add(n);
    	}
    	//definirposicionesBloqueadas(15, 14, 1, "Pasillo");
    	//definirposicionesBloqueadas(15, 6, 2, "Pasillo");
    	//definirposicionesBloqueadas(7, 9, 2, "Pasillo");
    	//(X, Y, Piso)
    	posicionActual = mapa.buscarNodo(inicio);
    	setEnergiaTotal(1000);
    	energiaConsumida = 0;
    }
    @Override
    public String toString() {
        String str = "" + energiaConsumida;
        return str;
    }
     public Nodo getposicionBuscador(){
        return posicionActual;
     }
     public void setposicionBuscador(Nodo arg){
    	 posicionActual = arg;
     }
     public Mapa getMapa(){
        return mapa;
     }
     public void setMapa(Mapa arg){
        mapa = arg;
     }
     public void setEnergiaConsumida(int energiaConsumida) {
		this.energiaConsumida = energiaConsumida;
     }
     public int getEnergiaConsumida() {
    	 return energiaConsumida;
     }
	public void setEnergiaTotal(int energiaTotal) {
		this.energiaTotal = energiaTotal;
	}
	public int getEnergiaTotal() {
		return energiaTotal;
	}
	public void setposicionesBloqueadas(Vector<Nodo> posicionesBloqueadas) {
		this.posicionesBloqueadas = posicionesBloqueadas;
	}
	public Vector<Nodo> getposicionesBloqueadas() {
		return posicionesBloqueadas;
	}
	public void definirposicionesBloqueadas(int x1, int y1, int piso1, String nodoA){ 
 
		Nodo nodo1 = new Nodo(x1, y1, piso1, nodoA);
		if((null != nodo1)){ 
			posicionesBloqueadas.addElement(nodo1);
		}
	}
	
}

