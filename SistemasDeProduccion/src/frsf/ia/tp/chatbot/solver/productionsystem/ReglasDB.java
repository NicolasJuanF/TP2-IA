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
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "DINERO" , "FAMILIA"), "NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 4, 4, 1));				id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "JOYERIA"), "NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 3, 4, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" , "JOYERIA"), "NO RESPONDER, LLAMAR PADRES , LLAMAR POLICIA", id_incremental, 2, 4, 1));							id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"DINERO"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 2, 3, 1));											id_incremental++;
		
		
		//TRABAJO
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 3, 3, 1));					id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("PREGUNTA" ,"TENER" , "TRABAJO" , "FAMILIA"), "SUGERIR NO RESPONDER, LLAMAR PADRES", id_incremental, 4, 3, 1));		id_incremental++;
		listaReglas.add(new Regla(Arrays.asList("TRABAJO" ,"FAMILIA"), "SUGERIR NO RESPONDER", id_incremental, 2, 2, 1));							id_incremental++;
		
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
	
		
		
		//BORRAR DESPUES 
		/*listaReglas.add(new Regla(Arrays.asList("HOLA", "COMO", "ESTAR"), "HOLA", 2, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("COMO", "ESTAR"), "TODO BIEN, ¿VOS?", 48, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("COMO", "ESTAR"), "ACA ANDAMOS, TRABAJANDO COMO SE DEBE :)", 49, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("BIEN"), "ME ALEGRO ENTONCES!)", 50, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("MAL"), "UUH, PONELE ONDA!", 51, 1, 1, 1));
		
		
		listaReglas.add(new Regla(Arrays.asList("HOLA"), "HOLA, ¿COMO VA?", 1, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("HOLA"), "HOLA", 46, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("CHAU"), "CHAU", 47, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("CHAU"), "HASTA LUEGO", 4, 1, 1, 1));
		
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "IA"), "INTELIGENCIA ARTIFICIAL SE RINDE EN EL AULA 01", 5, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "IA"), "INTELIGENCIA ARTIFICIAL SE RINDE EN EL AULA MM5", 6, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "IA"), "INTELIGENCIA ARTIFICIAL SE RINDE EN EL AULA E03", 7, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "AMII"), "ANÁLISIS MATEMÁTICO II SE RINDE EN EL AULA 20", 8, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "AMII"), "ANÁLISIS MATEMÁTICO II SE RINDE EN EL AULA 21", 9, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "AMII"), "ANÁLISIS MATEMÁTICO II SE RINDE EN EL AULA 22", 10, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "TC"), "TEORÍA DE CONTROL SE RINDE EN EL AULA 11", 11, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "TC"), "TEORÍA DE CONTROL SE RINDE EN EL AULA MM5", 12, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "ISW"), "INGENIERÍA DE SOFTWARE SE RINDE EN EL AULA 01", 13, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "ISW"), "INGENIERÍA DE SOFTWARE SE RINDE EN EL AULA 10", 14, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "FISICA"), "FÍSICA SE RINDE EN EL AULA 18", 15, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "RENDIR", "FISICA"), "FÍSICA SE RINDE EN EL AULA 20", 16, 1, 1, 1));
		
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "IA"), "HOY ES EN EL LABORATORIO 4", 17, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "SG"), "SI NO ES EN LA MULTIMEDIOS 5, PEGA EN EL PALO JAJA", 18, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "SG"), "EN EL LABORATORIO 4", 19, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "QUIMICA"), "EN EL LABORATORIO DE QUÍMICA, ¿DÓNDE SINO?", 20, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "MS"), "¡EN EL AULA 20!", 21, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "MA"), "CREO QUE ES EN EL AULA E03 PORQUE HAY PRÁCTICA", 22, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "CURSAR", "MA"), "LA TEORÍA ES EN EL AULA 16", 23, 1, 1, 1));
		
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "MILGUT"), "A MILAGROS LA PODÉS ENCONTRAR EN EL CIDISI", 24, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "MILGUT"), "ESTA DANDO CLASES DE INTELIGENCIA ARTIFICIAL", 25, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "JORGEROA"), "EN EL CIDISI SEGURO ESTÁ", 26, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "LAURACALIUSCO"), "A ESTA HORA LA ENCONTRÁS EN RELACIONES INTERNACIONALES", 27, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("CIDISI", "ENCONTRAR", "LUCIANABALLEJOS"), "SI, LLEGÓ HACE UN RATITO", 28, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("CIDISI", "ENCONTRAR", "LUCIANABALLEJOS"), "NO, SE FUE RECIÉN", 29, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("CIDISI", "ENCONTRAR", "LUCIANABALLEJOS"), "NO, ESTÁ EN EL AULA 10 DANDO CLASES", 30, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("OFICINA", "ENCONTRAR", "MARTACASTELLARO"), "CREO QUE SI", 31, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("OFICINA", "ENCONTRAR", "MARTACASTELLARO"), "ESTABA EN UNA REUNIÓN CON HORACIO LEONE", 32, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "MALVA"), "ES DIFÍCIL SABERLO, SE JUBILÓ", 33, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "PABLOVILLAREAL"), "LA VERDAD, NO SE SI SE ENCUENTRA EN LA FACULTAD", 34, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DONDE", "ENCONTRAR", "PABLOVILLAREAL"), "CREO QUE ESTÁ EN EL AULA MULTIMEDIOS 5", 35, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("POSGRADO", "ENCONTRAR", "JORGEVEGA"), "SI, ENTRÓ Y NUNCA SALIÓ, ASÍ QUE SÍ", 36, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DPTOSISTEMAS", "ESTAR", "RODRIGOLEDESMA"), "EN VINCULACIÓN TECNOLÓGICA, CON RAÚL", 37, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("DPTOSISTEMAS", "ESTAR", "RODRIGOLEDESMA"), "NO, NO ESTÁ", 38, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("FACULTAD", "ESTAR", "SUSANAROMANIZ"), "SI, ESTÁ EN SU OFICINA", 39, 1, 1, 1));
		
		listaReglas.add(new Regla(Arrays.asList("COMO", "LLEGAR", "CIDISI"), "VAMOS QUE TE LLEVO", 40, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("COMO", "LLEGAR", "POSGRADO"), "VAMOS QUE TE LLEVO", 41, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("COMO", "LLEGAR", "AULA18"), "VAMOS QUE TE LLEVO", 42, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("COMO", "LLEGAR", "BANCO"), "VAMOS QUE TE LLEVO", 43, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("COMO", "LLEGAR", "DPTOSISTEMAS"), "VAMOS QUE TE LLEVO", 52, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("HABER", "ASCENSOR"), "SI SI", 44, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("HABER", "ASCENSOR"), "SI, PERO ESTÁ ROTO", 45, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("HABER", "ASCENSOR","FACULTAD"), "SI SI", 53, 1, 1, 1));
		listaReglas.add(new Regla(Arrays.asList("HABER", "ASCENSOR","FACULTAD"), "SI, PERO ESTÁ ROTO", 54, 1, 1, 1));*/
		
		
		
		return listaReglas;
	}
	
}
