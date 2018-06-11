package frsf.cidisi.exercise.tp1.search.actions;

import java.util.Vector;

import dominio.Nodo;

import frsf.cidisi.exercise.tp1.search.EstadoBuscador;
import frsf.cidisi.exercise.tp1.search.EstadoFacultad;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgentState;
import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;

public class SubirPiso extends SearchAction {

    /**
     * This method updates a tree node state when the search process is running.
     * It does not updates the real world state.
     */
    @Override
    public SearchBasedAgentState execute(SearchBasedAgentState s) {
        EstadoBuscador agState = (EstadoBuscador) s;
        
        Vector<Nodo> nodosAdyacentes = agState.getMapa().buscarAdyacentes(agState.getposicion());
        Nodo nodoActual = agState.getposicion().clone();
        boolean estaBloqueado = false;
        if((nodoActual.getPiso()<agState.getposicionElegida().getPiso())){
	        for(Nodo n : nodosAdyacentes){
	    		if((nodoActual.getX()==n.getX())&&(nodoActual.getY()==n.getY())&&(nodoActual.getPiso()<n.getPiso())&&(!n.equal(agState.getUltimaPosicionVisitada()))){	
	    			for(Nodo n1 : agState.getposicionesBloqueadas()){
						if(n1.equal(n)){
							//Si entra acá quiere decir que el nodo adyacente al oeste esta bloqueado.
							estaBloqueado = true;
						}
					}
					if((!estaBloqueado)&&(agState.getenergiaConsumida()<=agState.getenergiaTotal())){
		    			agState.setUltimaPosicionVisitada(nodoActual);
		    			agState.setposicion(n);
		    			agState.setenergiaConsumida((int)(agState.getenergiaConsumida()+this.getCost()));
		    			return agState;
					}
				}
	    	}
        }
        return null;
    }
    /**
     * This method updates the agent state and the real world state.
     */
    @Override
    public EnvironmentState execute(AgentState ast, EnvironmentState est) {
        EstadoFacultad environmentState = (EstadoFacultad) est;
        EstadoBuscador agState = ((EstadoBuscador) ast);

        Nodo nodoActual = agState.getposicion().clone();
        Vector<Nodo> nodosAdyacentes = agState.getMapa().buscarAdyacentes(agState.getposicion());
        boolean estaBloqueado = false;
        if((nodoActual.getPiso()<agState.getposicionElegida().getPiso())){
	        for(Nodo n : nodosAdyacentes){
	    		if((nodoActual.getX()==n.getX())&&(nodoActual.getY()==n.getY())&&(nodoActual.getPiso()<n.getPiso())&&(!n.equal(agState.getUltimaPosicionVisitada()))){	
	        		
	    			for(Nodo n1 : agState.getposicionesBloqueadas()){
						if(n1.equal(n)){
							//Si entra acá quiere decir que el nodo adyacente al oeste esta bloqueado.
							estaBloqueado = true;
						}
					}
					if(!estaBloqueado){
						agState.setUltimaPosicionVisitada(nodoActual);
		    			agState.setposicion(n);
		    			agState.setenergiaConsumida((int)(agState.getenergiaConsumida()+this.getCost()));
		    			
		    			environmentState.setposicionBuscador(n);
		    			environmentState.setEnergiaConsumida((int)(environmentState.getEnergiaConsumida()+this.getCost()));
		    			
		    			return environmentState;
	        		}
	    		}
	        }    
	    }    
        return null;
    }

    /**
     * This method returns the action cost.
     */
    @Override
    public Double getCost() {
        return new Double(10);
    }

    /**
     * This method is not important for a search based agent, but is essensial
     * when creating a calculus based one.
     */
    @Override
    public String toString() {
        return "SubirPiso";
    }
	@Override
	public Double getCost(int x1, int x2) {
		// TODO Auto-generated method stub
		return null;
	}
}