package frsf.cidisi.exercise.tp1.search;

import java.util.HashSet;
import java.util.Vector;

import dominio.Enlace;
import dominio.Nodo;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.environment.Environment;

public class FacultadAmbiente extends Environment {

    public FacultadAmbiente(String inicio, HashSet<Nodo> listaBloqueados) {
    	this.environmentState = new EstadoFacultad(inicio, listaBloqueados);
	}

	public EstadoFacultad getEnvironmentState() {
        return (EstadoFacultad) super.getEnvironmentState();
    }
    /**
     * This method is called by the simulator. Given the Agent, it creates
     * a new perception reading, for example, the agent position.
     * @param agent
     * @return A perception that will be given to the agent by the simulator.
     */
    @Override
    public  BuscadorAgentePerception getPercept() {
    	// Create a new perception to return
        BuscadorAgentePerception perception = new BuscadorAgentePerception();
        Nodo nodoActual = this.getEnvironmentState().getposicionBuscador().clone();
        Vector<Nodo> nodosBloqueados = new Vector<Nodo>();
        for(Nodo n : this.getEnvironmentState().getMapa().buscarAdyacentes(nodoActual)){
        	for(Nodo n1 : this.getEnvironmentState().getposicionesBloqueadas()){
	        	if(n1.equal(n)){
	        		nodosBloqueados.add(n);
	        	}
        	}
        }
        perception.setposicionesBloqueadas(nodosBloqueados);
        return perception;
    }

    public String toString() {
        return environmentState.toString();
    }
    
    public boolean agentFailed(Action actionReturned){

        EstadoFacultad envState = this.getEnvironmentState();
        boolean failed = false;
        //El agente falla cuando se queda sin energia
        if(envState.getEnergiaConsumida() >= envState.getEnergiaTotal()){
        	failed = true;
        }
        return failed;
    }
}
