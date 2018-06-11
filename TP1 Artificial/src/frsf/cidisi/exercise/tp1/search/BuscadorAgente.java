package frsf.cidisi.exercise.tp1.search;

import frsf.cidisi.exercise.tp1.search.actions.AvanzarEste;
import frsf.cidisi.exercise.tp1.search.actions.AvanzarNorte;
import frsf.cidisi.exercise.tp1.search.actions.AvanzarOeste;
import frsf.cidisi.exercise.tp1.search.actions.AvanzarSur;
import frsf.cidisi.exercise.tp1.search.actions.BajarPiso;
import frsf.cidisi.exercise.tp1.search.actions.Retroceder;
import frsf.cidisi.exercise.tp1.search.actions.SubirPiso;
import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.agent.search.Problem;
import frsf.cidisi.faia.agent.search.SearchAction;
import frsf.cidisi.faia.agent.search.SearchBasedAgent;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.search.*;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Vector;

public class BuscadorAgente extends SearchBasedAgent {

	int indice;
	
    public BuscadorAgente(String inicio, String fin, int i){
    	// The Agent Goal
        ObjectivoAgente agGoal = new ObjectivoAgente();
        indice=i;

        // The Agent State
        EstadoBuscador agState = new EstadoBuscador(inicio, fin);
        this.setAgentState(agState);

        // Create the operators
        Vector<SearchAction> operators = new Vector<SearchAction>();
        
        operators.addElement(new AvanzarNorte());
        operators.addElement(new AvanzarEste());
        operators.addElement(new AvanzarSur());
        operators.addElement(new AvanzarOeste());
        operators.addElement(new SubirPiso());	
        operators.addElement(new BajarPiso());	
        operators.addElement(new Retroceder());
        
        // Create the Problem which the agent will resolve
        Problem problem = new Problem(agGoal, agState, operators);
        this.setProblem(problem);
	}

	/**
     * This method is executed by the simulator to ask the agent for an action.
     */
    @Override
    public Action selectAction() {

    	Strategy strategy;
    	int i=indice;
    	//Estrategias No Informadas
    	if(i==0){
    		strategy = new DepthFirstSearch();
    	}
    	else if(i==1){
    		strategy = new BreathFirstSearch();
    	}
    	//Estrategia Informada
    	//Avara
    	else{
    		Heuristic h = new Heuristic();
            strategy = new GreedySearch(h);	
    	}
        
		// Create a Search object with the strategy
        Search searchSolver = new Search(strategy);

        /* Generate an XML file with the search tree. It can also be generated
         * in other formats like PDF with PDF_TREE */
        searchSolver.setVisibleTree(Search.EFAIA_TREE); //XML

        // Set the Search searchSolver.
        this.setSolver(searchSolver);

        // Ask the solver for the best action
        Action selectedAction = null;
        try {
            selectedAction =
                    this.getSolver().solve(new Object[]{this.getProblem()});
        } catch (Exception ex) {
            Logger.getLogger(BuscadorAgente.class.getName()).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;

    }

    /**
     * This method is executed by the simulator to give the agent a perception.
     * Then it updates its state.
     * @param p
     */
    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
}
