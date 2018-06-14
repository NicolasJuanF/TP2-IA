package frsf.cidici.faia.simulator;

import java.util.ArrayList;
import java.util.Vector;

import utils.ArchivoOutput;


import frsf.cidici.faia.solver.productionsystem.ProductionSystemAction;
import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.agent.Agent;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.environment.Environment;
import frsf.cidisi.faia.simulator.events.EventType;
import frsf.cidisi.faia.simulator.events.SimulatorEventNotifier;

public class KnowledgeBasedAgentSimulator extends frsf.cidisi.faia.simulator.Simulator {

    public KnowledgeBasedAgentSimulator(Environment environment, Vector<Agent> agents) {
        super(environment,agents);
    }
    
    public KnowledgeBasedAgentSimulator(Environment environment, Agent agent) {
   		Vector<Agent> v = new Vector<Agent>();
   		v.add(agent);
    	this.environment = environment;
    	this.agents = v;
    }
	
	@Override
	public ArrayList<String> start() {
		
		ArrayList<String> resultado = new ArrayList<String>();
		
		ProductionSystemAction act;
        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();
        
		ArchivoOutput.getInstance().agregarLinea("----------------------------------------------------");
		ArchivoOutput.getInstance().agregarLinea("--- " + this.getSimulatorName() + " ---");
		ArchivoOutput.getInstance().agregarLinea("----------------------------------------------------");
		ArchivoOutput.getInstance().agregarLinea("\n");

        

        Perception perception;
        Action action = null;
        Agente agent;
        agent = (Agente) this.getAgents().firstElement();

        System.out.println("------------------------------------");
        System.out.println("Sending perception to agent...");
        perception = this.getPercept();
        agent.see(perception);
        System.out.println("Percepcion: " + perception);
        System.out.println("Environment: " + environment);
        System.out.println(agent.getAgentState().toString());
        
        
		ArchivoOutput.getInstance().agregarLinea("----------------------------------------------------");
		ArchivoOutput.getInstance().agregarLinea("Sending perception to agent...");
		ArchivoOutput.getInstance().agregarLinea("Percepcion: " + perception);
		ArchivoOutput.getInstance().agregarLinea("Environment: " + environment);
		ArchivoOutput.getInstance().agregarLinea(agent.getAgentState().toString());

        
        try {
			action = agent.learn();
		} catch (Exception e) {
			e.printStackTrace();
		}

        if (action == null)
        	resultado.add("No hay acciones disponibles");
        else{
        	act = (ProductionSystemAction) action;
        	resultado.add(act.getRegla().getThen().toString());
        }
        System.out.println();

        this.ruleReturned(agent, action);
      
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
        
		//return null;
		return resultado;
		
	}

	protected boolean finishForAgentState(Agent agent) {
		// TODO Futuro: Ver como deberá ser este método
		return false;
	}

	protected boolean finishForRule(Action action) {
		// TODO Futuro: Ver como deberá ser este método
		if(action == null){
			return false;
		}
		else{
			ProductionSystemAction act = (ProductionSystemAction) action;		
			return (((String) act.getRegla().getThen()).equalsIgnoreCase("APAGAR"));  	
		}
	}	
	public String getSimulatorName() {
        return "Knowledge Based Simulator";
    }

    public void ruleReturned(Agent agent,Action action) {
        if(action!=null){
        	this.updateState(action);
        }
    }
    
    protected void updateState(Action action) {
    	//TODO Futuro: Esta hecho para el ChatBot pero debería incluirse en otro lugar el metodo requerido.
        this.getEnvironment().updateState(((Agente) agents.elementAt(0)).getAgentState(), action);
    }
    
}
