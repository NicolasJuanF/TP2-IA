package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.faia.solver.search.IEstimatedCostFunction;
import frsf.cidisi.faia.solver.search.NTree;

/**
 * This class allows to define a function to be used by any
 * informed search strategy, like A Star or Greedy.
 */
public class Heuristic implements IEstimatedCostFunction {

    /**
     * It returns the estimated cost to reach the goal from a NTree node.
     */
    @Override
    public double getEstimatedCost(NTree node) {
        EstadoBuscador agState = (EstadoBuscador) node.getAgentState();
	
        //Aca tenemos que definir la heuristica que se utilizará en las estrategias Avara y/o A*
        int posicionesEnX = Math.abs((agState.getposicion().getX()) - (agState.getposicionElegida().getX()));
        int posicionesEnY = Math.abs((agState.getposicion().getY()) - (agState.getposicionElegida().getY()));
		int nroPisos = Math.abs(agState.getposicion().getPiso() - agState.getposicionElegida().getPiso());
		double total = (posicionesEnX + posicionesEnY)*(nroPisos+1);
		
        return total;
    }
}
