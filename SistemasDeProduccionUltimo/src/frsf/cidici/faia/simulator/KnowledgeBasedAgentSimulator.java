package frsf.cidici.faia.simulator;

import java.util.ArrayList;
import java.util.Vector;


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
		
		ArrayList<String> mensaje = new ArrayList<String>();
		
		ProductionSystemAction act;
		//int contador = 0;
        System.out.println("----------------------------------------------------");
        System.out.println("--- " + this.getSimulatorName() + " ---");
        System.out.println("----------------------------------------------------");
        System.out.println();

        Perception perception;
        Action action = null;
        //TODO Futuro: Esta hecho para el ChatBot pero debería incluirse el método learn en la clase agente.
        ChatbotAgent agent;
        agent = (ChatbotAgent) this.getAgents().firstElement();

        //do {
        System.out.println("------------------------------------");
        System.out.println("Sending perception to agent...");
        perception = this.getPercept();
        agent.see(perception);
        System.out.println("Oracion percibida: " + perception);
        System.out.println("Environment: " + environment);
        System.out.println(agent.getAgentState().toString());
        
        //System.out.println("Asking the agent that start the learning process...");
        try {
			action = agent.learn();
		} catch (Exception e) {
			e.printStackTrace();
		}

        if (action == null){
        	//System.out.println("\nRule to execute: None");
        	mensaje.add("NO ENTENDÍ LO QUE ME DIJISTE");
        }
        else{
        	act = (ProductionSystemAction) action;
        	//System.out.println("\nRule to execute: " + act.getRegla().getId());
        	mensaje.add(act.getRegla().getThen().toString());
        }
        System.out.println();

        this.ruleReturned(agent, action);
        //contador ++;
        //EL WHILE DEBE SER HASTA QUE SALGA Y NO HASTA QUE TERMINE DE "APRENDER"
        //} while (!this.finishForRule(action) && !this.finishForAgentState(agent));
		//} while(contador<10);
        // Check what happened.
        /*if (this.finishForRule(action)) {
            System.out.println("The agent has executed the finish rule.");
        } else {
            System.out.println("The agent has finished learning!");
        }*/
        // Leave a blank line
        System.out.println();

        // This call can be moved to the Simulator class
        this.environment.close();

        // Launch simulationFinished event
        SimulatorEventNotifier.runEventHandlers(EventType.SimulationFinished, null);
        
		//return null;
		return mensaje;
		
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
			return (((String) act.getRegla().getThen()).equalsIgnoreCase("chau")||(((String) act.getRegla().getThen()).equalsIgnoreCase("hasta luego"))||((String) act.getRegla().getThen()).equalsIgnoreCase("nos vemos"));  	
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
        this.getEnvironment().updateState(((ChatbotAgent) agents.elementAt(0)).getAgentState(), action);
    }
    
}
