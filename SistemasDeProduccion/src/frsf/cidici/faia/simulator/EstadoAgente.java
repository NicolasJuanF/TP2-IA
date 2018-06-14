package frsf.cidici.faia.simulator;

import java.util.HashSet;
import java.util.Set;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.AgentState;
import frsf.ia.tp.chatbot.solver.productionsystem.PreProcessing;

public class EstadoAgente extends AgentState {

	//SE DEBEN DEFINIR LAS VARIABLES DEL ESTADO DEL AGENTE
	private Set<String> claves = new HashSet<String>();
	
    public EstadoAgente() {

    }

    public void updateState(Perception p) {
    	AgentePerception cbp = (AgentePerception) p;
    	claves.clear();
    	claves = PreProcessing.tokenize(cbp.getOracion());
    }
    @Override
    public void initState() {}

    @Override
    public String toString() {
        String str = "Estado Agente: \n";
        str = str + "Palabras clave: " + claves;
        return str;
    }

	public Set<String> getListaClaves() {
		return claves;
	}

	public void setListaClaves(Set<String> listaClaves) {
		this.claves = listaClaves;
	}
	
}

