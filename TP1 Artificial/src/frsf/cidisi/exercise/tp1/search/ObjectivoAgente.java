package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.agent.search.GoalTest;
import frsf.cidisi.faia.state.AgentState;

public class ObjectivoAgente extends GoalTest {

    @Override
    public boolean isGoalState (AgentState agentState) {
    
    	EstadoBuscador estado = (EstadoBuscador) agentState;
    	
    	if(estado.getposicion().equal(estado.getposicionElegida())){
    		return true;
    	}
    	else
    		return false;
	}
}