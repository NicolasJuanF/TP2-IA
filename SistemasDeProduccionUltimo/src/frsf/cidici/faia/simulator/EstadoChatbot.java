package frsf.cidici.faia.simulator;

import java.util.HashSet;
import java.util.Set;

import frsf.cidisi.faia.agent.Perception;
import frsf.cidisi.faia.state.AgentState;
import frsf.ia.tp.chatbot.solver.productionsystem.Conversion;

public class EstadoChatbot extends AgentState {

	//SE DEBEN DEFINIR LAS VARIABLES DEL ESTADO DEL AGENTE
	private Set<String> listaClaves = new HashSet<String>();
	
    public EstadoChatbot() {

    }

    public void updateState(Perception p) {
    	ChatbotPerception cbp = (ChatbotPerception) p;
    	//ACA SE DEFINE COMO SE VA A ACTUALIZAR EL ESTADO DEL AGENTE
    	listaClaves.clear();
    	listaClaves = Conversion.convertir(cbp.getOracion());
    }
    @Override
    public void initState() {}

    @Override
    public String toString() {
        String str = "Estado del Agente: \n";
        str = str + "Palabras claves detectadas: " + listaClaves;
        return str;
    }

	public Set<String> getListaClaves() {
		return listaClaves;
	}

	public void setListaClaves(Set<String> listaClaves) {
		this.listaClaves = listaClaves;
	}
	
}

