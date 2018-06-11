package frsf.cidici.faia.solver.productionsystem;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import frsf.cidisi.faia.agent.Action;
import frsf.cidisi.faia.solver.Solve;
import frsf.ia.tp.chatbot.solver.productionsystem.Problema;
import frsf.ia.tp.chatbot.solver.productionsystem.Regla;

public class ProductionSystem extends Solve{

	private List<Criteria> criteria;
	public List<Regla> listaDeReglas;
	//used contiene la lista de reglas utilizadas. Sirve para el criterio de no duplicidad
	public static List<Regla> used = new ArrayList<Regla>();
	//El problema en este agente es, mediante una lista de palabras claves ver que regla aplicar.
	//El problema contiene la lista de palabras claves percibidas desde el ambiente.
	public Problema problema;
	
	public ProductionSystem(List<Criteria> s, List<Regla> reglas){
		criteria = s;
		listaDeReglas = reglas;
	}
	
	@Override
	public void showSolution() {
	}

	@Override
	public Action solve(Object[] params) throws Exception {

		problema = (Problema) params[0]; //Aca tiene las palabras claves detectadas
		Regla r;

		//El Do-While se saca porque en este caso resuelve el problema que tiene y luego ejecuta la accion
		//hasta que le pregunten o digan algo nuevamente
		
		//Se obtienen las reglas activas, es decir las que se pueden aplicar.
		List<Regla> activeRules = match();
		
		if(activeRules.isEmpty()) {
			//ACA SE DEBERIA MOSTRAR QUE NO SE ENTIENDE QUE SE DIJO???
			return null;
		}
		
		//Se resuelven los conflictos.
    	//for(Iterator<Criteria> i = criteria.iterator(); i.hasNext();){
    	for(Criteria i : criteria){	
    		Criteria actualCriteria = i;
    		System.out.println("\nCriterio:" + actualCriteria.toString());
    		List<Regla> finalRules = actualCriteria.apply(activeRules);
    		if(finalRules.size()==0){
    			//System.out.print("Reglas en Conflicto: -");
    			System.out.print("No hay reglas para aplicar");
    		}
    		else{
    			System.out.print("Reglas en Conflicto: ");
            	//for(Iterator<Regla> j = finalRules.iterator(); j.hasNext();)
            	//{
            	for(Regla j : finalRules){
    				System.out.print("("+j.getId()+")");
            	}
    			activeRules = finalRules;
    			if(activeRules.size()==1){
    				break;
    			}
    		}
    	}
    	//Se obtiene la regla elegida.
    	r = activeRules.get(0);
    	this.ejecutar(r);
		return new ProductionSystemAction(r);
	}
	
	protected List<Regla> match(){
		//ACA SE DEBE HACER EL MACHEO ENTRE LA LISTA DE PALABRAS CLAVES CON TODAS LAS REGLAS PARA VER CUALES SE
		//PUEDEN EJECUTAR
		List<Regla> listaReglasAplicables = new ArrayList<Regla>();
		Set<String> palabrasPercibidas = problema.getPalabrasClaves();

		for(Regla r : listaDeReglas){
			//Por cada regla tengo que verificar que la secuencia de palabras sea la misma.
			//Si es la misma entonces hay que agregar la regla a la lista a devolver.
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
