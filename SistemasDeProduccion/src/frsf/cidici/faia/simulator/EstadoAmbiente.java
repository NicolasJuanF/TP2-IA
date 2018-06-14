package frsf.cidici.faia.simulator;

import frsf.cidisi.faia.state.AgentState;
import frsf.cidisi.faia.state.EnvironmentState;
import frsf.ia.tp.chatbot.solver.productionsystem.Regla;

public class EstadoAmbiente extends EnvironmentState {
    
	//Se deben definir las variables del estado del ambiente

	private String oracion;

	public EstadoAmbiente(String oracion) {
    	this.oracion=oracion;
    }
    
	@Override
	public void initState() {

    }
	
    @Override
    public String toString() {
        return this.oracion;
    }

	public void update(AgentState ast, Regla rule) {
	}
	public String getOracion() {
		return oracion;
	}
	public void setOracion(String oracion) {
		this.oracion = oracion;
	}
}

