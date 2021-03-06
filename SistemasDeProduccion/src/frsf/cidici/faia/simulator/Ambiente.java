package frsf.cidici.faia.simulator;

import frsf.cidisi.faia.environment.Environment;

public class Ambiente extends Environment {

    public Ambiente(String oracion) {
    	this.environmentState = new EstadoAmbiente(oracion);
    	
	}

	public EstadoAmbiente getEnvironmentState() {
        return (EstadoAmbiente) super.getEnvironmentState();
    }
    @Override
    public  AgentePerception getPercept() {
    	// Create a new perception to return
    	AgentePerception perception = new AgentePerception();
    	
    	perception.setOracion(this.getEnvironmentState().getOracion());
    	
        return perception;
    }

    public String toString() {
        return environmentState.toString();
    }
}
