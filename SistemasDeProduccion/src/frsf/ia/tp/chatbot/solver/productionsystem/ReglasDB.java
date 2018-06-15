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
		listaReglas.add(new Regla(Arrays.asList("NOMBRE" , "FAMILIA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 2, 1, 1));						id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("NOMBRE" , "FAMILIA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 2, 1, 1));						id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++; 
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "AMISTAD"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		
		//EDAD
		listaReglas.add(new Regla(Arrays.asList("EDAD"), "CUIDADO", id_incremental, 1, 1, 1));																		id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "EDAD"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));												id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "EDAD" , "FAMILIA"), "GRABANDO CONVERSACION, SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));			id_incremental++;
		
		//nacimiento
		listaReglas.add(new Regla(Arrays.asList("NACIMIENTO"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));										id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO" , "FAMILIA"), "GRABANDO CONVERSACION, SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));	id_incremental++;
		
		//ESCUELA
		listaReglas.add(new Regla(Arrays.asList("ESCUELA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("ESCUELA" , "AMISTAD"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));						id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "ESCUELA"), "CUIDADO (POSIBLE VIOLACION DE PRIVACIDAD)", id_incremental, 3, 1, 1));			id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA", "ESCUELA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"NOMBRE" , "ESCUELA"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		
		//CASA
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CASA"), "LLAMANDO PADRES", id_incremental, 2, 3, 1));													id_incremental++;
		
		//PROFESOR
		listaReglas.add(new Regla(Arrays.asList("PROFESOR"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"PROFESOR"), "LLAMANDO PADRES", id_incremental, 2, 2, 1));												id_incremental++;
		
		//viaje 
		listaReglas.add(new Regla(Arrays.asList("TENER" ,"VIAJE"), "LLAMANDO PADRES", id_incremental, 2, 1, 1));													id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTAR" ,"VIAJE"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		
		
		//DINERO
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "DINERO" , "FAMILIA"), "NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 4, 4, 1));		id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "JOYERIA"), "NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 3, 4, 1));				id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "JOYERIA"), "NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 2, 4, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 2, 4, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICÍA", id_incremental, 2, 3, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("DINERO", "TENER"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICÍA", id_incremental, 2, 3, 1));									id_incremental++;
		
		//TRABAJO
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO" , "FAMILIA"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 4, 3, 1));		id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("TRABAJO" ,"FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		
		//CIUDAD
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CIUDAD"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("CIUDAD"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));										id_incremental++;
		
		
		//LICENCIA
		listaReglas.add(new Regla(Arrays.asList("LICENCIA"), "CUIDADO (POSIBLE VIOLACIÓN DE SEGURIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTAR" , "LICENCIA"), "CUIDADO (POSIBLE VIOLACIÓN DE SEGURIDAD)", id_incremental, 2, 1, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTAR" , "LICENCIA", "FAMILIA"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));				id_incremental++;
		
		
		//HOBBY
		listaReglas.add(new Regla(Arrays.asList("HOBBY"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 1, 1, 1));											id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("TENER" , "HOBBY"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 2, 1, 1));								id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PRUGUNTAR" , "HOBBY"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 2, 2, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PRUGUNTAR" , "HOBBY" , "AMISTAD"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 1, 1));				id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PRUGUNTAR" , "HOBBY", "FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
	
		
	
		
		
		return listaReglas;
	}
	
}
