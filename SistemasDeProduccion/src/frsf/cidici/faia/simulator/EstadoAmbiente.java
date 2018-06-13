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
        String str = "Se escribió: "+this.oracion;
        return str;
    }

	public void update(AgentState ast, Regla rule) {
		//ACA TIENE QUE ACTUALIZAR EL ESTADO DEL AMBIENTE, ES DECIR LA PANTALLA
		//System.out.println(rule.toString());
		System.out.println("Agente dice: "+rule.getThen());
	}
	public String getOracion() {
		return oracion;
	}
	public void setOracion(String oracion) {
		this.oracion = oracion;
	}
}

