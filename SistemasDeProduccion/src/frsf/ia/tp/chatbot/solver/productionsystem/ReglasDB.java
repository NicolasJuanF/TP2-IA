package frsf.ia.tp.chatbot.solver.productionsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReglasDB {
	private List<Regla> listaReglas;
	
	public ReglasDB(){
		listaReglas = new ArrayList<Regla>();
	}
	public List<Regla> crearReglas(){
		int id_incremental = 1; 
		//listaReglas.add(new Regla(Arrays.asList("PALABRAS"), RESPUESTA, ID, ESPECIFIDAD, PRIORIDAD, NOVEDAD) 
		
		//NOMBRES
		
		listaReglas.add(new Regla(Arrays.asList("NOMBRE"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("NOMBRE"), "*NO SE REQUIERE ACCIÓN*", id_incremental, 1, 1, 1));													id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("NOMBRE" , "FAMILIA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 2, 1, 1));						id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("NOMBRE" , "FAMILIA"), "ESPERANDO RESPUESTA PARA DETERMINAR PELIGRO", id_incremental, 2, 1, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++; 
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "FAMILIA"), "OBLIGAR NO RESPONDER", id_incremental, 3, 3, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "AMISTAD"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		
		//EDAD
		listaReglas.add(new Regla(Arrays.asList("EDAD"), "CUIDADO", id_incremental, 1, 1, 1));																		id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("EDAD"), "SUGERIR NO RESPONDER", id_incremental, 1, 1, 1));															id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("EDAD"), "ESPERANDO REPSUESTA PARA DETERMINAR PELIGRO", id_incremental, 1, 1, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA","EDAD"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));												id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA","EDAD"), "OBLIGAR NO RESPONDER", id_incremental, 2, 3, 1));												id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA","EDAD" , "FAMILIA"), "GRABANDO CONVERSACION, SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));			id_incremental++;
		
		//nacimiento
		listaReglas.add(new Regla(Arrays.asList("NACIMIENTO"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 2, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("NACIMIENTO"), "*NO SE REQUIERE ACCION*", id_incremental, 1, 1, 1));												id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));										id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO" , "FAMILIA"), "GRABANDO CONVERSACION, SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));	id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO" , "FAMILIA"), "LLAMANDO PADRES", id_incremental, 3, 2, 1));								id_incremental++;
		
		//ESCUELA
		listaReglas.add(new Regla(Arrays.asList("ESCUELA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("ESCUELA" , "AMISTAD"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));						id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "ESCUELA"), "CUIDADO (POSIBLE VIOLACION DE PRIVACIDAD)", id_incremental, 3, 1, 1));			id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "ESCUELA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"NOMBRE" , "ESCUELA"), "OBLIGAR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		
		//CASA
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CASA"), "LLAMANDO PADRES", id_incremental, 2, 3, 1));													id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CASA"), "OBLIGAR NO RESPONDER, GRABAR CONVERSACION", id_incremental, 2, 3, 1));						id_incremental++;
		
		
		//PROFESOR
		listaReglas.add(new Regla(Arrays.asList("PROFESOR"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"PROFESOR"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		
		//viaje 
		listaReglas.add(new Regla(Arrays.asList("TENER" ,"VIAJE"), "SUGERIR NO RESPONDER", id_incremental, 2, 1, 1));												id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"VIAJE"), "OBLIGAR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "TENER" ,"VIAJE"), "OBLIGAR NO RESPONDER", id_incremental, 3, 2, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "TENER" ,"VIAJE"), "OBLIGAR NO RESPONDER, NOTIFICAR PADRES", id_incremental, 3, 3, 1));				id_incremental++;
		
		//DINERO
		listaReglas.add(new Regla(Arrays.asList("DINERO", "TENER"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICÍA", id_incremental, 2, 3, 1));						id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "JOYERIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 2, 4, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "OBLIGAR NO RESPONDER, GRABAR CONVERSACION", id_incremental, 2, 4, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICÍA", id_incremental, 2, 3, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "JOYERIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 3, 4, 1));		id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "DINERO" , "FAMILIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 3, 4, 1));			id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "DINERO" ,"FAMILIA"), "GRABAR CONVERSACION, LLAMAR POLICIA", id_incremental, 3, 4, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "TENER" , "DINERO" , "FAMILIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 4, 4, 1));		id_incremental++;
		
		//TRABAJO
		listaReglas.add(new Regla(Arrays.asList("TRABAJO" ,"FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO" , "FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 4, 2, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO" , "FAMILIA"), "OBLIGAR NO RESPONDER, NOTIFICAR PADRES", id_incremental, 4, 3, 1));		id_incremental++;
		
		//CIUDAD
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CIUDAD"), "OBLIGAR NO RESPONDER, LLAMAR PADRES", id_incremental, 2, 3, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("CIUDAD"), "SUGERIR NO RESPONDER", id_incremental, 1, 1, 1));										id_incremental++;
		
		//LICENCIA
		listaReglas.add(new Regla(Arrays.asList("LICENCIA"), "CUIDADO (POSIBLE VIOLACIÓN DE SEGURIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "LICENCIA"), "CUIDADO (POSIBLE VIOLACIÓN DE SEGURIDAD)", id_incremental, 2, 1, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "LICENCIA", "FAMILIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));				id_incremental++;

		//HOBBY
		listaReglas.add(new Regla(Arrays.asList("HOBBY"), "*NO SE REQUIERE ACCION*", id_incremental, 1, 1, 1));														id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("HOBBY"), "ESPERANDO RESPUESTA PARA DETERMINAR PELIGRO", id_incremental, 1, 1, 1));																	id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("TENER" , "HOBBY"), "SUGERIR NO RESPONDER", id_incremental, 2, 1, 1));												id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "HOBBY"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA","TENER","HOBBY"), "SUGERIR NO REPONDER", id_incremental, 3, 4, 1));										id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "HOBBY" , "AMISTAD"), "SUGERIR NO RESPONDER", id_incremental, 3, 1, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "HOBBY", "FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
	
		return listaReglas;
	}
	
}
