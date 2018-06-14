package utils;


import java.io.*;
import java.util.LinkedList;


public class ArchivoOutput {
	
		String nombre;
		LinkedList<String> respuestas;
		public static String LOG_NAME = "Log.txt";	
		private static ArchivoOutput instance;

		public static ArchivoOutput getInstance(){
			if(instance == null){
				instance = new ArchivoOutput(LOG_NAME);
				}
			return instance;
		}
		
		
		
	    private ArchivoOutput(String n) {
	    	nombre = n;
	    	respuestas = new LinkedList<String>();
	    }
	    
	    public void agregarLinea(String rta){
	    	respuestas.addLast(rta);
	    }
	    
	    public void grabar()
	    {
	        try
	        {
	        	FileOutputStream fstream = new FileOutputStream(nombre);
	            DataOutputStream salida = new DataOutputStream(fstream);
	            BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(salida));		            
	            while(!respuestas.isEmpty()){
	            	buffer.write(respuestas.removeFirst());
	            	buffer.newLine();
	            }
	            buffer.close();
	            fstream.close();
	        }
	        catch (Exception e){}
	    }    
}