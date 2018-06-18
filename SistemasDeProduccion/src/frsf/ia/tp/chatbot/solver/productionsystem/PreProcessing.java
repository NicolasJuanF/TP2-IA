package frsf.ia.tp.chatbot.solver.productionsystem;

import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class PreProcessing {
	private static final String vocalesAcentuadas = "¡·…ÈÕÌ”Û⁄˙—Ò‹¸";
	private static final String vocalesNoAcentuadas = "AaEeIiOoUuNnUu";
	private static final String signosPuntuacion = ",.;:ø?°!()'$%&";
	
	public static String sanitize(String oracion){
	    char[] iterable = oracion.toCharArray();
	    
	    
	    for (int i = 0; i < iterable.length; i++) {
	    	//Eliminamos acentos
	        int pos = vocalesAcentuadas.indexOf(iterable[i]);
	        if (pos > -1) {
	        	iterable[i] = vocalesNoAcentuadas.charAt(pos);
	        }
	        
	        //Eliminamos signos de puntuacion
	        pos = signosPuntuacion.indexOf(iterable[i]);
	        if(pos > -1){
	        	for(int j = i; j < iterable.length-1; j++){
	        		iterable[j] = iterable[j+1];
	        	}
	        	iterable[iterable.length-1] = ' ';
	        }
	    }
	    return new String(iterable).toUpperCase();
	}
	
	//Divide la oracion en un conjunto de palabras clave
	public static Set<String> tokenize(String oracion){
		Set<String> tokensSet = new HashSet<String>();
		String siguiente;
		
		System.out.println(oracion);
		oracion = sanitize(oracion);
		System.out.println(oracion);
		
		StringTokenizer tokens = new StringTokenizer(oracion);
		while(tokens.hasMoreTokens()){
			siguiente = tokens.nextToken();
			
			if(siguiente.equals("MADRE") 
					|| siguiente.equals("PADRE") 
					|| siguiente.equals("PAPA")
					|| siguiente.equals("MAMA")
					|| siguiente.equals("PA")
					|| siguiente.equals("MA")
					|| siguiente.equals("HERMANO")
					|| siguiente.equals("HERMANA")
					|| siguiente.equals("HERMANOS")
					|| siguiente.equals("HERMANAS")
					){
				tokensSet.add("FAMILIA");
			}
			
			if(siguiente.equals("NOMBRE")
					|| siguiente.equals("NOMBRES")
					|| siguiente.equals("APELLIDO")
					|| siguiente.equals("APODO")
					|| siguiente.equals("APODOS")
					|| siguiente.equals("LLAMA")
					|| siguiente.equals("LLAMAS")
					|| siguiente.equals("LLAMAN")
					|| siguiente.equals("LLAMA")
					|| siguiente.equals("MARGARET")
					|| siguiente.equals("GEORGE")
					){
				tokensSet.add("NOMBRE");
			}
			if(siguiente.equals("AMIGA")
					|| siguiente.equals("AMIGO")
					|| siguiente.equals("AMIGOS")
					|| siguiente.equals("AMIGAS")
					){
				tokensSet.add("AMISTAD");
			}
			if(siguiente.equals("NACI")
					|| siguiente.equals("NACISTE")
					|| siguiente.equals("CUMPLEANOS")
					|| siguiente.equals("ANOS")
					|| siguiente.equals("EDAD")
					
					){
				tokensSet.add("EDAD");
			}
			if(siguiente.equals("NACI")
					|| siguiente.equals("NACISTE")
					|| siguiente.equals("NACIMIENTO")
					){
				tokensSet.add("NACIMIENTO");
			}
			if(siguiente.equals("NACI")
					|| siguiente.equals("NACISTE")
					|| siguiente.equals("NACIMIENTO")
					|| siguiente.equals("NACIO")
					|| siguiente.equals("NACE")
					
					
					){
				tokensSet.add("NACIMIENTO");
			}
			if(siguiente.equals("QUE")
					|| siguiente.equals("COMO")
					|| siguiente.equals("DONDE")
					|| siguiente.equals("CUANDO")
					|| siguiente.equals("QUIEN")
					|| siguiente.equals("QUIENES")
					|| siguiente.equals("CUANTO")
					|| siguiente.equals("CUANTA")
					|| siguiente.equals("CUANTAS")
					|| siguiente.equals("CUANTOS")
					|| siguiente.equals("CUAL")
					
					){
				tokensSet.add("PREGUNTA");
			}
			if(siguiente.equals("ESCUELA")
					|| siguiente.equals("PRIMARIA")
					|| siguiente.equals("JARDIN")
					|| siguiente.equals("SECUNDARIA")
					|| siguiente.equals("COLEGIO")
					|| siguiente.equals("CLASES")
					|| siguiente.equals("CLASE")
					|| siguiente.equals("GRADO")
					|| siguiente.equals("GRADOS")
					|| siguiente.equals("CURSO")
					){
				tokensSet.add("ESCUELA");
			}
			if(siguiente.equals("ESCUELA")
					|| siguiente.equals("PRIMARIA")
					|| siguiente.equals("JARDIN")
					|| siguiente.equals("SECUNDARIA")
					|| siguiente.equals("COLEGIO")
					|| siguiente.equals("CLASES")
					|| siguiente.equals("CLASE")
					|| siguiente.equals("GRADO")
					|| siguiente.equals("GRADOS")
					|| siguiente.equals("CURSO")
					){
				tokensSet.add("ESCUELA");
			}
			if(siguiente.equals("PROFESOR")
					|| siguiente.equals("PROFESORA")
					|| siguiente.equals("PROFESORES")
					|| siguiente.equals("MAESTRO")
					|| siguiente.equals("MAESTRA")
					|| siguiente.equals("MAESTROS")
					|| siguiente.equals("MAESTRAS")
					){
				tokensSet.add("PROFESOR");
			}
			if(siguiente.equals("BANCO")
					|| siguiente.equals("BANCOS")
					|| siguiente.equals("ALCANCIA")
					|| siguiente.equals("AHORROS")
					|| siguiente.equals("AHORRAR")
					|| siguiente.equals("AHORRO")
					|| siguiente.equals("PLATA")
					|| siguiente.equals("DINERO")
					){
				tokensSet.add("DINERO");
			}
			if(siguiente.equals("JOYERIA")
					|| siguiente.equals("CADENA")
					|| siguiente.equals("COLLAR")
					|| siguiente.equals("DIAMANTES")
					|| siguiente.equals("ANILLOS")
					|| siguiente.equals("ANILLO")
					|| siguiente.equals("JOYA")
					|| siguiente.equals("DIAMANTE")
					|| siguiente.equals("JOYAS")
					|| siguiente.equals("COLLARES")
					){
				tokensSet.add("JOYERIA");
			}
			if(siguiente.equals("TRABAJO")
					|| siguiente.equals("TRABAJA")
					|| siguiente.equals("TRABAJAR")
					|| siguiente.equals("TRABAJAN")
					|| siguiente.equals("PROFESION")
					){
				tokensSet.add("TRABAJO");
			}
			if(siguiente.equals("CASA")
					|| siguiente.equals("HOGAR")
					|| siguiente.equals("DIRECCION")
					|| siguiente.equals("CALLE")
					|| siguiente.equals("PROFESION")
					|| siguiente.equals("VIVIR")
					|| siguiente.equals("VIVES")
					|| siguiente.equals("VIVEN")
					){
				tokensSet.add("CASA");
			}
			if(siguiente.equals("VIAJE")
					|| siguiente.equals("VIAJAR")
					|| siguiente.equals("SALIDA")
					|| siguiente.equals("PASEO")
					|| siguiente.equals("IR")
					|| siguiente.equals("SALIR")
					|| siguiente.equals("PASEO")
					|| siguiente.equals("PASEAR")
					|| siguiente.equals("VACACIONES")
					|| siguiente.equals("IR")
					){
				tokensSet.add("VIAJE");
			}
			if(siguiente.equals("TENER")
					|| siguiente.equals("TENES")
					|| siguiente.equals("TIENES")
					|| siguiente.equals("TIENEN")
					|| siguiente.equals("TIENE")
					){
				tokensSet.add("TENER");
			}
			if(siguiente.equals("CIUDAD")
					|| siguiente.equals("BARRIO")
					|| siguiente.equals("PARANA")
					){
				tokensSet.add("CIUDAD");
			}
			if(siguiente.equals("CONDUCIR")
					|| siguiente.equals("LICENCIA")
					|| siguiente.equals("MANEJAR")
					){
				tokensSet.add("LICENCIA");
			}
			if(siguiente.equals("ACTIVIDAD")
					|| siguiente.equals("ACTIVIDADES")
					|| siguiente.equals("HOBBIES")
					|| siguiente.equals("HOBBY")
					|| siguiente.equals("INTERES")
					|| siguiente.equals("INTERESES")
					|| siguiente.equals("INTERESA")
					|| siguiente.equals("INTERESAN")
					|| siguiente.equals("GUSTOS")
					|| siguiente.equals("GUSTA")
					|| siguiente.equals("GUSTO")
					|| siguiente.equals("HACER")
					|| siguiente.equals("DEPORTE")
					|| siguiente.equals("DEPORTES")
					){
				tokensSet.add("HOBBY");
			}



			
		}
		
		System.out.println(tokensSet);
		
		return tokensSet;
	}
}
