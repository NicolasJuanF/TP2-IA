package frsf.ia.tp.chatbot.solver.productionsystem;

import java.util.Set;

public class Problem {

    protected Set<String> palabrasClave;

    public Problem() {
    }
    
    public Set<String> getPalabrasClaves() {
		return palabrasClave;
	}
	public void setPalabrasClaves(Set<String> set) {
		this.palabrasClave = set;
	}
}