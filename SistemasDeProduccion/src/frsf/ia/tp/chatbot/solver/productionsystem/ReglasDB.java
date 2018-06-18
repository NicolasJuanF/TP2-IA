package frsf.ia.tp.chatbot.solver.productionsystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReglasDB {
	private List<Regla> reglas;
	
	public ReglasDB(){
		reglas = new ArrayList<Regla>();
	}
	public List<Regla> crearReglas(){
		int id_incremental = 1; 
		//listaReglas.add(new Regla(Arrays.asList("PALABRAS"), RESPUESTA, ID, ESPECIFIDAD, PRIORIDAD, NOVEDAD) 
		/*1*/ reglas.add(new Regla(Arrays.asList("NOMBRE"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		/*2*/ reglas.add(new Regla(Arrays.asList("NOMBRE"), "*NO SE REQUIERE ACCIÓN*", id_incremental, 1, 1, 1));													id_incremental++;
		/*3*/ reglas.add(new Regla(Arrays.asList("NOMBRE" , "FAMILIA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 2, 1, 1));						id_incremental++;
		/*4*/ reglas.add(new Regla(Arrays.asList("NOMBRE" , "FAMILIA"), "ESPERANDO RESPUESTA PARA DETERMINAR PELIGRO", id_incremental, 2, 1, 1));					id_incremental++;
		/*5*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++; 
		/*6*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "FAMILIA"), "OBLIGAR NO RESPONDER", id_incremental, 3, 3, 1));								id_incremental++;
		/*7*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "AMISTAD"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		/*8*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NOMBRE" , "PROFESOR"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		
		
		//EDAD
		/*9*/ reglas.add(new Regla(Arrays.asList("EDAD"), "CUIDADO", id_incremental, 1, 1, 1));																		id_incremental++;
		/*10*/ reglas.add(new Regla(Arrays.asList("EDAD"), "SUGERIR NO RESPONDER", id_incremental, 1, 1, 1));															id_incremental++;
		/*11*/ reglas.add(new Regla(Arrays.asList("EDAD"), "ESPERANDO REPSUESTA PARA DETERMINAR PELIGRO", id_incremental, 1, 1, 1));									id_incremental++;
		/*12*/ reglas.add(new Regla(Arrays.asList("PREGUNTA","EDAD"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));												id_incremental++;
		/*13*/ reglas.add(new Regla(Arrays.asList("PREGUNTA","EDAD"), "OBLIGAR NO RESPONDER", id_incremental, 2, 3, 1));												id_incremental++;
		/*14*/ reglas.add(new Regla(Arrays.asList("PREGUNTA","EDAD" , "FAMILIA"), "GRABANDO CONVERSACION, SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));			id_incremental++;
		
		//nacimiento
		/*15*/ reglas.add(new Regla(Arrays.asList("NACIMIENTO"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 2, 1));								id_incremental++;
		/*16*/ reglas.add(new Regla(Arrays.asList("NACIMIENTO"), "*NO SE REQUIERE ACCION*", id_incremental, 1, 1, 1));												id_incremental++;
		/*17*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));										id_incremental++;
		/*18*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO" , "FAMILIA"), "GRABANDO CONVERSACION, SUGERIR NO RESPONDER", id_incremental, 3, 3, 1));	id_incremental++;
		/*19*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "NACIMIENTO" , "FAMILIA"), "LLAMANDO PADRES", id_incremental, 3, 2, 1));								id_incremental++;
		
		//ESCUELA
		/*20*/ reglas.add(new Regla(Arrays.asList("ESCUELA"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		/*21*/ reglas.add(new Regla(Arrays.asList("ESCUELA" , "AMISTAD"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));						id_incremental++;
		/*22*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "ESCUELA"), "CUIDADO (POSIBLE VIOLACION DE PRIVACIDAD)", id_incremental, 3, 1, 1));			id_incremental++;
		/*23*/ reglas.add(new Regla(Arrays.asList("PREGUNTA", "ESCUELA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		/*24*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"NOMBRE" , "ESCUELA"), "OBLIGAR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
		
		//CASA
		/*25*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CASA"), "LLAMANDO PADRES", id_incremental, 2, 3, 1));													id_incremental++;
		/*26*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CASA"), "OBLIGAR NO RESPONDER, GRABAR CONVERSACION", id_incremental, 2, 3, 1));						id_incremental++;
		
		
		//PROFESOR
		/*27*/ reglas.add(new Regla(Arrays.asList("PROFESOR"), "CUIDADO (POSIBLE VIOLACIÓN DE PRIVACIDAD)", id_incremental, 1, 1, 1));								id_incremental++;
		/*28*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"PROFESOR"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		
		//viaje 
		/*29*/ reglas.add(new Regla(Arrays.asList("TENER" ,"VIAJE"), "SUGERIR NO RESPONDER", id_incremental, 2, 1, 1));												id_incremental++;
		/*30*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"VIAJE"), "OBLIGAR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		/*31*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "TENER" ,"VIAJE"), "OBLIGAR NO RESPONDER", id_incremental, 3, 2, 1));									id_incremental++;
		/*32*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "TENER" ,"VIAJE"), "OBLIGAR NO RESPONDER, NOTIFICAR PADRES", id_incremental, 3, 3, 1));				id_incremental++;
		
		//DINERO
		/*33*/ reglas.add(new Regla(Arrays.asList("DINERO", "TENER"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICÍA", id_incremental, 2, 3, 1));						id_incremental++;
		/*34*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "JOYERIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 2, 4, 1));							id_incremental++;
		/*35*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "OBLIGAR NO RESPONDER, GRABAR CONVERSACION", id_incremental, 2, 4, 1));								id_incremental++;
		/*36*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICÍA", id_incremental, 2, 3, 1));					id_incremental++;
		/*37*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "JOYERIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 3, 4, 1));		id_incremental++;
		/*38*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "DINERO" , "FAMILIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 3, 4, 1));			id_incremental++;
		/*39*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "DINERO" ,"FAMILIA"), "GRABAR CONVERSACION, LLAMAR POLICIA", id_incremental, 3, 4, 1));							id_incremental++;
		/*40*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "TENER" , "DINERO" , "FAMILIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 4, 4, 1));		id_incremental++;
		
		//TRABAJO
		/*41*/ reglas.add(new Regla(Arrays.asList("TRABAJO" ,"FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		/*42*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));					id_incremental++;
		/*43*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO" , "FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 4, 2, 1));					id_incremental++;
		/*44*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TRABAJO" , "FAMILIA"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 4, 2, 1));					id_incremental++;
		/*45*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO" , "FAMILIA"), "OBLIGAR NO RESPONDER, NOTIFICAR PADRES", id_incremental, 4, 3, 1));		id_incremental++;
		
		//CIUDAD
		/*46*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" ,"CIUDAD"), "OBLIGAR NO RESPONDER, LLAMAR PADRES", id_incremental, 2, 3, 1));							id_incremental++;
		/*47*/ reglas.add(new Regla(Arrays.asList("CIUDAD"), "SUGERIR NO RESPONDER", id_incremental, 1, 1, 1));										id_incremental++;
		
		//LICENCIA
		/*48*/ reglas.add(new Regla(Arrays.asList("LICENCIA"), "CUIDADO (POSIBLE VIOLACIÓN DE SEGURIDAD)", id_incremental, 1, 1, 1));									id_incremental++;
		/*49*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "LICENCIA"), "CUIDADO (POSIBLE VIOLACIÓN DE SEGURIDAD)", id_incremental, 2, 1, 1));					id_incremental++;
		/*50*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "LICENCIA", "FAMILIA"), "OBLIGAR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));				id_incremental++;

		//HOBBY
		/*51*/ reglas.add(new Regla(Arrays.asList("HOBBY"), "*NO SE REQUIERE ACCION*", id_incremental, 1, 1, 1));														id_incremental++;
		/*52*/ reglas.add(new Regla(Arrays.asList("HOBBY"), "ESPERANDO RESPUESTA PARA DETERMINAR PELIGRO", id_incremental, 1, 1, 1));																	id_incremental++;
		/*53*/ reglas.add(new Regla(Arrays.asList("TENER" , "HOBBY"), "SUGERIR NO RESPONDER", id_incremental, 2, 1, 1));												id_incremental++;
		/*54*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "HOBBY"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));											id_incremental++;
		/*55*/ reglas.add(new Regla(Arrays.asList("PREGUNTA","TENER","HOBBY"), "SUGERIR NO REPONDER", id_incremental, 3, 4, 1));										id_incremental++;
		/*56*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "HOBBY" , "AMISTAD"), "SUGERIR NO RESPONDER", id_incremental, 3, 1, 1));								id_incremental++;
		/*57*/ reglas.add(new Regla(Arrays.asList("PREGUNTA" , "HOBBY", "FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 3, 2, 1));								id_incremental++;
	
		return reglas;
	}
	
}
