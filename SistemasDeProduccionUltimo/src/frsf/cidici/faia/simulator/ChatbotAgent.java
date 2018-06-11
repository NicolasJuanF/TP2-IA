package frsf.cidici.faia.simulator;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.sun.istack.internal.logging.Logger;

import frsf.cidici.faia.solver.productionsystem.Criteria;
import frsf.cidici.faia.solver.productionsystem.NoDuplication;
import frsf.cidici.faia.solver.productionsystem.Novelty;
import frsf.cidici.faia.solver.productionsystem.Priority;
import frsf.cidici.faia.solver.productionsystem.ProductionSystem;
import frsf.cidici.faia.solver.productionsystem.Random;
import frsf.cidici.faia.solver.productionsystem.Specificity;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Perception;
import frsf.ia.tp.chatbot.solver.productionsystem.CreaRegla;
import frsf.ia.tp.chatbot.solver.productionsystem.Problema;
import frsf.ia.tp.chatbot.solver.productionsystem.Regla;


public class ChatbotAgent extends KnowledgeBasedAgent{

	EstadoChatbot agState;
	List<Criteria> listaCriterios;
	List<Regla> listaReglas;
	ProductionSystem ps;
	Problema problema;
	
	public ChatbotAgent(){
		
		agState = new EstadoChatbot();
        this.setAgentState(agState);
		
		listaCriterios = new ArrayList<Criteria>();
		listaCriterios.add(new NoDuplication());
		listaCriterios.add(new Specificity());
		listaCriterios.add(new Novelty());
		listaCriterios.add(new Random());
		listaCriterios.add(new Priority());
		
		listaReglas = new ArrayList<Regla>();
		cargarReglas();
		
		ps = new ProductionSystem(listaCriterios, listaReglas);
		
		problema = new Problema();
	}

    @Override
    public void see(Perception p) {
        this.getAgentState().updateState(p);
    }
    public Action learn() throws Exception{
    	
    	Action selectedAction = null;
    	problema.setPalabrasClaves(agState.getListaClaves());
    	//Problema[] list = {problema};
    	//Aca se deben pasar las palabras claves, se pasan como un problema para que sea del tipo Object
    	//selectedAction = ps.solve(list);
    	
    	try {
            selectedAction = ps.solve(new Object[]{problema});
        } catch (Exception ex) {
            Logger.getLogger(ChatbotAgent.class.getName(), null).log(Level.SEVERE, null, ex);
        }

        // Return the selected action
        return selectedAction;
        
    }

	public void cargarReglas(){//ACA SE CARGAN LAS REGLAS 
		/*Estructura de una regla:
		Condiciones - Then - id - specificity - priority - novelty*/
		listaReglas = new CreaRegla().crearReglas();
	}
	
	@Override
	public Action selectAction() {
		// TODO Auto-generated method stub
		return null;
	}
}

