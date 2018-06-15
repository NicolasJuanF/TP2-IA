package frsf.cidici.faia.solver.productionsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import utils.ArchivoOutput;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.Solve;
import frsf.ia.tp.chatbot.solver.productionsystem.Problem;
import frsf.ia.tp.chatbot.solver.productionsystem.Regla;

public class ProductionSystem extends Solve{

	private List<Criteria> criteria;
	public List<Regla> listaDeReglas;
	public static List<Regla> used = new ArrayList<Regla>();
	public Problem problem;
	
	public ProductionSystem(List<Criteria> s, List<Regla> reglas){
		criteria = s;
		listaDeReglas = reglas;
	}
	
	@Override
	public void showSolution() {
	}

	@Override
	public Action solve(Object[] params) throws Exception {

		problem = (Problem) params[0]; //keywords detectadas
		Regla regla;


		
		//Se obtienen las reglas activas
		List<Regla> activeRules = match();
		
		//No hay mas reglas activas
		if(activeRules.isEmpty()) {
			return null;
		}
		
		//Resolucion de conflictos
    	for(Criteria i : criteria){	
    		Criteria actualCriteria = i;
    		System.out.println("\nCriterio:" + actualCriteria.toString());
    		ArchivoOutput.getInstance().agregarLinea("\nCriterio:" + actualCriteria.toString());
    		List<Regla> finalRules = actualCriteria.apply(activeRules);
    		if(finalRules.size()==0){
    			System.out.print("No hay reglas para aplicar");
    			ArchivoOutput.getInstance().agregarLinea("No hay reglas para aplicar");
    		}
    		else{
    			System.out.println("Reglas en Conflicto: ");
    			ArchivoOutput.getInstance().agregarLinea("Reglas en Conflicto: ");

            	for(Regla r : finalRules){
            		System.out.println(r.toString());
            		ArchivoOutput.getInstance().agregarLinea(r.toString());
            		
            	}
    			activeRules = finalRules;
    			
    			if(activeRules.size()==1){
    				break;
    			}
    		}
    	}
    	regla = activeRules.get(0);
    	this.ejecutar(regla);
		return new ProductionSystemAction(regla);
	}
	
	protected List<Regla> match(){

		List<Regla> listaReglasAplicables = new ArrayList<Regla>();
		Set<String> palabrasPercibidas = problem.getPalabrasClaves();

		for(Regla r : listaDeReglas){
			List<String> condiciones = r.getCondiciones();
			if((condiciones.containsAll(palabrasPercibidas))&&(condiciones.size()==palabrasPercibidas.size())){
				listaReglasAplicables.add(r);
			}
		}
		return listaReglasAplicables;
	}
	
	protected void ejecutar(Regla r){
		used.add(r);
		
	}

}
