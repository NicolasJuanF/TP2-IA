package frsf.ia.tp.chatbot.solver.productionsystem;

import java.util.List;

public class Regla{

	private List<String> condiciones; 	//Contiene las palabras claves de la condicion
	private String then; 				//Contiene la frase que va a contestar
	private int id;						//Es el id de la regla. Sirve para compararlas
	private int specificity;
	private int priority;
	private int novelty;
	
	
    public Regla (List<String> condiciones, String then, int id, int specificity, int priority, int novelty){
        //super();
        this.setCondiciones(condiciones);
        this.setThen(then);
        this.setId(id);
        this.setSpecificity(specificity);
        this.setPriority(priority);
        this.setNovelty(novelty);
    }  
	public void setThen(String then) {
		this.then = then;
	}

	public String getThen() {
		return then;
	}

	public void setCondiciones(List<String> condiciones) {
		this.condiciones = condiciones;
	}

	public List<String> getCondiciones() {
		return condiciones;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setSpecificity(int specificity) {
		this.specificity = specificity;
	}

	public int getSpecificity() {
		return specificity;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getPriority() {
		return priority;
	}

	public void setNovelty(int novelty) {
		this.novelty = novelty;
	}

	public int getNovelty() {
		return novelty;
	}
	
	@Override
	public String toString(){
		String result = "id:"+ id + " -> [";
		
		for(String k : condiciones){
			if(!k.equals(condiciones.get(condiciones.size() -1)))
				result += k + ",";
			else
				result += k;
		}
		
		result+= "] -> " + then;
		
		
		return result;
	}
    
}