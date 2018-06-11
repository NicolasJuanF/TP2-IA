package frsf.cidisi.exercise.tp1.search;

import java.util.Vector;

import dominio.Nodo;
import frsf.cidisi.faia.agent.Agent;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;

public class BuscadorAgentePerception extends Perception {

	public static Nodo UNKNOWN_PERCEPTION = null;   
	private Vector<Nodo> posicionesBloqueadas;
	
    public  BuscadorAgentePerception() {
    	
    }

    public BuscadorAgentePerception(Agent agent, Environment environment) {
        super(agent, environment);
    }

    /**
     * This method is used to setup the perception.
     */
    @Override
    public void initPerception(Agent agentIn, Environment environmentIn) {
    	
    }
    @Override
    public String toString() {
    	String str = "";
    	for(Nodo e : this.getposicionesBloqueadas()){
    		str += "El nodo = "+e.getX()+", "+e.getY()+", "+e.getPiso();
    		str += " se encuentra bloqueado.";
    		str += "\n";
    	}
        return str.toString();
    }

	public void setposicionesBloqueadas(Vector<Nodo> posicionesBloqueadas) {
		this.posicionesBloqueadas = posicionesBloqueadas;
	}

	public Vector<Nodo> getposicionesBloqueadas() {
		return posicionesBloqueadas;
	}

}
