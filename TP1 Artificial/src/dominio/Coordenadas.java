package dominio;

public class Coordenadas {
	
	Mapa mapa = new Mapa();
	
	public Coordenadas(){
		inicializar();
	}
	
	public Mapa getMapa(){
		return mapa;
	}
	
	public void inicializar(){	
     	//Aca se crean los nodos del piso 1
      	mapa.agregarNodo(15, 16, 1, "Pasillo");		
      	mapa.agregarNodo(2, 15, 1, "Lab Quimica");			mapa.agregarNodo(4, 15, 1, "Aula 07");
      	mapa.agregarNodo(6, 15, 1, "Aula 06");      		mapa.agregarNodo(7, 15, 1, "Aula 05");
      	mapa.agregarNodo(9, 15, 1, "Aula 04");      		mapa.agregarNodo(11, 15, 1, "Aula 03");
      	mapa.agregarNodo(12, 15, 1, "Aula 02");      		mapa.agregarNodo(13, 15, 1, "CEUT");
      	mapa.agregarNodo(14, 15, 1, "Aula 01");      		mapa.agregarNodo(15, 15, 1, "Informes");
      	mapa.agregarNodo(15, 14, 1, "Pasillo"); 			mapa.agregarNodo(16, 14, 1, "Pasillo");
      	mapa.agregarNodo(18, 14, 1, "Cantina");
      	mapa.agregarNodo(2, 12, 1, "Lab Fisica");  			mapa.agregarNodo(7, 12, 1, "Pasillo");
      	mapa.agregarNodo(10, 12, 1, "Pasillo");  			mapa.agregarNodo(15, 12, 1, "Aula Estudio");
      	mapa.agregarNodo(15, 11, 1, "Pasillo");  			mapa.agregarNodo(18, 11, 1, "Biblioteca");
      	mapa.agregarNodo(7, 9, 1, "Taller de Mecanica"); 	mapa.agregarNodo(15, 9, 1, "Oficinas 1A");
      	mapa.agregarNodo(15, 7, 1, "Pasillo");   			mapa.agregarNodo(18, 7, 1, "Alumnado");
      	mapa.agregarNodo(13, 6, 1, "Pasillo");   			mapa.agregarNodo(15, 6, 1, "Pasillo");
      	mapa.agregarNodo(7, 5, 1, "Pasillo");   			mapa.agregarNodo(12, 5, 1, "Dpto Electrica A");
      	mapa.agregarNodo(18, 4, 1, "SAE");   	 			mapa.agregarNodo(26, 4, 1, "Estadio 1B");
      	mapa.agregarNodo(18, 2, 1, "Pasillo");   			mapa.agregarNodo(20, 2, 1, "Relaciones Internacionales");
      	mapa.agregarNodo(22, 2, 1, "Oficinas 1B");  		mapa.agregarNodo(24, 2, 1, "DASUTEN");
      	mapa.agregarNodo(26, 2, 1, "Vestuarios");   		mapa.agregarNodo(13, 1, 1, "Pasillo");      		
      	mapa.agregarNodo(14, 1, 1, "Pasillo");				mapa.agregarNodo(15, 1, 1, "Pasillo");	
      	//Nodos de habitaciones que son posibles destinos
      	mapa.agregarNodo(14, 9, 1, "Dpto Mecanica");		mapa.agregarNodo(12, 1, 1, "Dpto Electrica B");	
      	
      	//Ascensores y escaleras del piso 1
      	mapa.agregarNodo(16, 16, 1, "Escalera");      	mapa.agregarNodo(13, 11, 1, "Escalera");
      	mapa.agregarNodo(12, 6, 1, "Escalera");      	mapa.agregarNodo(13, 7, 1, "Escalera");
      	mapa.agregarNodo(13, 0, 1, "Escalera");      	mapa.agregarNodo(22, 0, 1, "Escalera");
      	mapa.agregarNodo(14, 2, 1, "Ascensor");
      	
    	//Aca se crean los enlaces piso 1
      	mapa.conectar(2, 12, 1, 2, 15, 1);      mapa.conectar(2, 15, 1, 4, 15, 1);
      	mapa.conectar(4, 15, 1, 6, 15, 1);     	mapa.conectar(6, 15, 1, 7, 15, 1);
      	mapa.conectar(7, 15, 1, 9, 15, 1);     	mapa.conectar(9, 15, 1, 11, 15, 1);
      	mapa.conectar(11, 15, 1, 12, 15, 1);    mapa.conectar(12, 15, 1, 13, 15, 1);
      	mapa.conectar(13, 15, 1, 14, 15, 1);    mapa.conectar(14, 15, 1, 15, 15, 1);
      	mapa.conectar(15, 15, 1, 15, 16, 1);    mapa.conectar(7, 15, 1, 7, 12, 1);
      	mapa.conectar(7, 12, 1, 7, 9, 1);  	    mapa.conectar(7, 9, 1, 7, 5, 1);
      	mapa.conectar(7, 12, 1, 10, 12, 1);     mapa.conectar(10, 12, 1, 15, 12, 1);
      	mapa.conectar(15, 15, 1, 15, 14, 1);    mapa.conectar(15, 14, 1, 15, 12, 1);
      	mapa.conectar(15, 14, 1, 16, 14, 1);    mapa.conectar(16, 14, 1, 18, 14, 1);
      	mapa.conectar(15, 12, 1, 15, 11, 1);    mapa.conectar(15, 11, 1, 15, 9, 1);
     	mapa.conectar(15, 9, 1, 15, 7, 1);      mapa.conectar(15, 7, 1, 15, 6, 1);
     	mapa.conectar(15, 6, 1, 15, 1, 1);	    mapa.conectar(15, 6, 1, 13, 6, 1);
     	mapa.conectar(15, 1, 1, 14, 1, 1);	    mapa.conectar(14, 1, 1, 13, 1, 1);
     	mapa.conectar(7, 5, 1, 12, 5, 1);	    mapa.conectar(18, 14, 1, 18, 11, 1);
     	mapa.conectar(18, 11, 1, 18, 7, 1);     mapa.conectar(18, 7, 1, 18, 4, 1);
     	mapa.conectar(18, 4, 1, 18, 2, 1);	    mapa.conectar(18, 2, 1, 20, 2, 1);
     	mapa.conectar(20, 2, 1, 22, 2, 1);	    mapa.conectar(22, 2, 1, 24, 2, 1);
     	mapa.conectar(24, 2, 1, 26, 2, 1);	    mapa.conectar(26, 2, 1, 26, 4, 1);
     	mapa.conectar(15, 16, 1, 16, 16, 1);	mapa.conectar(13, 11, 1, 15, 11, 1);
     	mapa.conectar(13, 7, 1, 15, 7, 1);	    mapa.conectar(12, 6, 1, 13, 6, 1);
     	mapa.conectar(13, 0, 1, 13, 1, 1);	    mapa.conectar(14, 1, 1, 14, 2, 1);
     	mapa.conectar(21, 0, 1, 22, 0, 1);		mapa.conectar(14, 9, 1, 15, 9, 1);
     	mapa.conectar(12, 1, 1, 13, 1, 1);		mapa.conectar(22, 2, 1, 22, 0, 1);
 
      	//Aca se crean los nodos del piso 2
    	mapa.agregarNodo(15, 16, 2, "Pasillo");
    	mapa.agregarNodo(2, 15, 2, "Pasillo");   	 	mapa.agregarNodo(4, 15, 2, "Pasillo");
    	mapa.agregarNodo(6, 15, 2, "Pasillo");      	mapa.agregarNodo(7, 15, 2, "Pasillo");
    	mapa.agregarNodo(9, 15, 2, "Pasillo");    	 	mapa.agregarNodo(11, 15, 2, "Pasillo");
    	mapa.agregarNodo(13, 15, 2, "Pasillo");   		mapa.agregarNodo(14, 15, 2, "Pasillo");
    	mapa.agregarNodo(15, 15, 2, "Pasillo");	  		mapa.agregarNodo(7, 14, 2, "Pasillo");
    	mapa.agregarNodo(15, 13, 2, "Materias Basicas");    	
    	mapa.agregarNodo(2, 12, 2, "Pasillo");	 	 	 mapa.agregarNodo(10, 12, 2, "Banios 2A");
    	mapa.agregarNodo(15, 12, 2, "Pasillo");	  		 mapa.agregarNodo(16, 12, 2, "Aula Consulta 2A");
    	mapa.agregarNodo(7, 11, 2, "Pasillo");    		 mapa.agregarNodo(10, 11, 2, "Pasillo");
    	mapa.agregarNodo(12, 11, 2, "Pasillo");  		 mapa.agregarNodo(18, 11, 2, "Pasillo");
    	mapa.agregarNodo(7, 9, 2, "Pasillo");     		 mapa.agregarNodo(15, 9, 2, "Pasillo");
    	mapa.agregarNodo(18, 8, 2, "Pasillo");
    	mapa.agregarNodo(15, 7, 2, "Pasillo"); 		
    	mapa.agregarNodo(9, 6, 2, "Banios 2B");   		 mapa.agregarNodo(15, 6, 2, "Mesa Estudio 2A");
    	mapa.agregarNodo(18, 6, 2, "Pasillo");			
    	mapa.agregarNodo(7, 5, 2, "Aula Civil"); 	     mapa.agregarNodo(9, 5, 2, "CECOVI");
    	mapa.agregarNodo(15, 5, 2, "Mesa Estudio 2B");
    	mapa.agregarNodo(22, 4, 2, "Pasillo");    		 mapa.agregarNodo(26, 4, 2, "Pasillo");
    	mapa.agregarNodo(13, 1, 2, "Pasillo");  		 mapa.agregarNodo(14, 1, 2, "Pasillo");
    	mapa.agregarNodo(15, 1, 2, "Pasillo");    		 mapa.agregarNodo(18, 1, 2, "Pasillo");
    	mapa.agregarNodo(21, 1, 2, "Aula Consulta 2B"); 	 mapa.agregarNodo(22, 1, 2, "Pasillo");
    	mapa.agregarNodo(24, 1, 2, "Pasillo");     		 mapa.agregarNodo(26, 1, 2, "Pasillo");
    	mapa.agregarNodo(21, 0, 2, "Pasillo");	    	
    	
      	//Ascensores y escaleras del piso 2
      	mapa.agregarNodo(16, 16, 2, "Escalera");      		mapa.agregarNodo(13, 11, 2, "Escalera");
      	mapa.agregarNodo(12, 6, 2, "Escalera");      		mapa.agregarNodo(13, 7, 2, "Escalera");
      	mapa.agregarNodo(13, 0, 2, "Escalera");      		mapa.agregarNodo(22, 0, 2, "Escalera");      	
      	mapa.agregarNodo(14, 2, 2, "Ascensor");
      	
    	//Nodos de habitaciones que son posibles destinos
      	mapa.agregarNodo(1, 12, 2, "Aula 18");					mapa.agregarNodo(8, 9, 2, "Dpto Civil");	
      	mapa.agregarNodo(1, 15, 2, "Aula Sist Representacion");	mapa.agregarNodo(14, 9, 2, "Dpto Basicas");	
      	mapa.agregarNodo(2, 16, 2, "Aula 16");					mapa.agregarNodo(19, 11, 2, "Aula E01");	
      	mapa.agregarNodo(4, 16, 2, "Aula 15");      			mapa.agregarNodo(19, 8, 2, "Aula E02");	
      	mapa.agregarNodo(6, 16, 2, "Aula 14");	      			mapa.agregarNodo(19, 6, 2, "Aula E03");	
      	mapa.agregarNodo(7, 16, 2, "Aula 13");    				mapa.agregarNodo(12, 1, 2, "Dpto Industrial");	
      	mapa.agregarNodo(9, 16, 2, "Aula 12");     				mapa.agregarNodo(22, 5, 2, "Estadio 2A");
      	mapa.agregarNodo(11, 16, 2, "Aula 11");    				mapa.agregarNodo(26, 5, 2, "Estadio 2B");	
      	mapa.agregarNodo(13, 16, 2, "Aula 10");      			mapa.agregarNodo(24, 0, 2, "Aula MM2");	
      	mapa.agregarNodo(14, 16, 2, "Aula 09");					mapa.agregarNodo(26, 0, 2, "Aula MM3");	
      	mapa.agregarNodo(8, 14, 2, "Aula 19");
      	
     	//Aca se crean los enlaces piso 2
      	mapa.conectar(15, 16, 2, 16, 16, 2);    mapa.conectar(15, 16, 2, 15, 15, 2);
      	mapa.conectar(2, 15, 2, 4, 15, 2);      mapa.conectar(4, 15, 2, 6, 15, 2);
      	mapa.conectar(6, 15, 2, 7, 15, 2);      mapa.conectar(7, 15, 2, 9, 15, 2);
      	mapa.conectar(9, 15, 2, 11, 15, 2);     mapa.conectar(11, 15, 2, 13, 15, 2);
      	mapa.conectar(13, 15, 2, 14, 15, 2);    mapa.conectar(14, 15, 2, 15, 15, 2);
      	mapa.conectar(2, 12, 2, 2, 15, 2);      mapa.conectar(2, 15, 2, 4, 15, 2);
      	mapa.conectar(7, 15, 2, 7, 14, 2);      mapa.conectar(7, 14, 2, 7, 11, 2);
      	mapa.conectar(7, 11, 2, 7, 9, 2);	    mapa.conectar(7, 9, 2, 7, 5, 2);
      	mapa.conectar(7, 11, 2, 10, 11, 2);     mapa.conectar(10, 11, 2, 12, 11, 2);
      	mapa.conectar(10, 11, 2, 10, 12, 2);    mapa.conectar(7, 5, 2, 9, 5, 2);
      	mapa.conectar(15, 5, 2, 9, 5, 2);	    mapa.conectar(9, 6, 2, 9, 5, 2);
      	mapa.conectar(15, 15, 2, 15, 13, 2);    mapa.conectar(15, 13, 2, 15, 12, 2);
      	mapa.conectar(15, 12, 2, 15, 9, 2);     mapa.conectar(15, 9, 2, 15, 7, 2);
      	mapa.conectar(15, 7, 2, 15, 6, 2);      mapa.conectar(15, 6, 2, 15, 5, 2);
      	mapa.conectar(15, 5, 2, 15, 1, 2);      mapa.conectar(13, 1, 2, 14, 1, 2);
      	mapa.conectar(14, 1, 2, 15, 1, 2);      mapa.conectar(15, 1, 2, 18, 1, 2);
      	mapa.conectar(18, 1, 2, 21, 1, 2);      mapa.conectar(21, 1, 2, 22, 1, 2);
      	mapa.conectar(22, 1, 2, 24, 1, 2);      mapa.conectar(24, 1, 2, 26, 1, 2);
      	mapa.conectar(18, 11, 2, 18, 8, 2);     mapa.conectar(18, 8, 2, 18, 6, 2);
      	mapa.conectar(18, 6, 2, 18, 1, 2);      mapa.conectar(15, 12, 2, 16, 12, 2);
      	mapa.conectar(22, 4, 2, 22, 1, 2);      mapa.conectar(26, 4, 2, 26, 1, 2);
      	mapa.conectar(21, 1, 2, 21, 0, 2);      mapa.conectar(12, 11, 2, 13, 11, 2);
      	mapa.conectar(15, 7, 2, 13, 7, 2);      mapa.conectar(15, 6, 2, 12, 6, 2);
      	mapa.conectar(13, 0, 2, 13, 1, 2);      mapa.conectar(14, 1, 2, 14, 2, 2);
     	mapa.conectar(22, 0, 2, 21, 0, 2);     	
     	mapa.conectar(1, 12, 2, 2, 12, 2);	    mapa.conectar(1, 15, 2, 2, 15, 2);
     	mapa.conectar(2, 16, 2, 2, 15, 2); 	    mapa.conectar(4, 16, 2, 4, 15, 2);
     	mapa.conectar(6, 16, 2, 6, 15, 2);      mapa.conectar(7, 16, 2, 7, 15, 2);
     	mapa.conectar(9, 16, 2, 9, 15, 2);      mapa.conectar(11, 16, 2, 11, 15, 2);
     	mapa.conectar(13, 16, 2, 13, 15, 2);    mapa.conectar(14, 16, 2, 14, 15, 2);
     	mapa.conectar(7, 14, 2, 8, 14, 2); 	    mapa.conectar(7, 9, 2, 8, 9, 2);
     	mapa.conectar(14, 9, 2, 15, 9, 2); 	    mapa.conectar(18, 11, 2, 19, 11, 2);
     	mapa.conectar(18, 8, 2, 19, 8, 2);      mapa.conectar(18, 6, 2, 19, 6, 2);
     	mapa.conectar(12, 1, 2, 13, 1, 2);      mapa.conectar(22, 5, 2, 22, 4, 2);
     	mapa.conectar(26, 5, 2, 26, 4, 2);	    mapa.conectar(24, 0, 2, 24, 1, 2);
     	mapa.conectar(26, 0, 2, 26, 1, 2);

     	//Aca se crean los nodos piso 3
     	mapa.agregarNodo(6, 6, 3, "Pasillo");			mapa.agregarNodo(9, 6, 3, "Pasillo");
     	mapa.agregarNodo(6, 4, 3, "Pasillo");			mapa.agregarNodo(11, 6, 3, "Pasillo");
     	mapa.agregarNodo(8, 6, 3, "Pasillo");				
     	//Nodos de habitaciones que son posibles destinos
      	mapa.agregarNodo(5, 6, 3, "Aula 22");			mapa.agregarNodo(6, 3, 3, "Anexo");
     	mapa.agregarNodo(8, 3, 3, "Aula 21");			mapa.agregarNodo(9, 7, 3, "Javalab");
    	
      	//Ascensores y escaleras del piso 3
      	mapa.agregarNodo(7, 4, 3, "Escalera");			mapa.agregarNodo(12, 6, 3, "Escalera");      	    	
      	mapa.agregarNodo(13, 0, 3, "Escalera");      	mapa.agregarNodo(14, 2, 3, "Ascensor");
     	
     	//Aca se crean los enlaces piso 3
      	mapa.conectar(6, 6, 3, 6, 4, 3);	    mapa.conectar(6, 6, 3, 8, 6, 3);
      	mapa.conectar(8, 6, 3, 9, 6, 3);	    mapa.conectar(9, 6, 3, 11, 6, 3);
      	mapa.conectar(8, 6, 3, 8, 3, 3); 	    mapa.conectar(11, 6, 3, 12, 6, 3);
      	mapa.conectar(9, 6, 3, 9, 7, 3);	    mapa.conectar(6, 3, 3, 6, 4, 3);
      	mapa.conectar(5, 6, 3, 6, 6, 3); 	    mapa.conectar(6, 4, 3, 7, 4, 3);
      	
      	//Aca se crean los nodos del piso 4
    	mapa.agregarNodo(3, 7, 4, "Pasillo");			mapa.agregarNodo(8, 4, 4, "Pasillo");
    	mapa.agregarNodo(5, 7, 4, "Pasillo");			mapa.agregarNodo(11, 6, 4, "Pasillo");
    	mapa.agregarNodo(7, 7, 4, "Pasillo");			mapa.agregarNodo(11, 2, 4, "Pasillo");
    	mapa.agregarNodo(8, 7, 4, "Pasillo");			mapa.agregarNodo(11, 1, 4, "Pasillo");
    	mapa.agregarNodo(10, 7, 4, "Pasillo");			mapa.agregarNodo(13, 1, 4, "Pasillo");
    	mapa.agregarNodo(11, 7, 4, "Pasillo");			mapa.agregarNodo(14, 1, 4, "Pasillo");
    	//Nodos de habitaciones que son posibles destinos
      	mapa.agregarNodo(2, 7, 4, "Laboratorio 3");				mapa.agregarNodo(10, 6, 4, "TICs");
     	mapa.agregarNodo(3, 9, 4, "Laboratorio 4");				mapa.agregarNodo(12, 7, 4, "Dpto Sistemas");
     	mapa.agregarNodo(5, 8, 4, "Laboratorio Conectividad");	mapa.agregarNodo(12, 6, 4, "Sala Estudio A");
     	mapa.agregarNodo(7, 8, 4, "Laboratorio 2");				mapa.agregarNodo(12, 2, 4, "Sala Estudio B");
     	mapa.agregarNodo(10, 8, 4, "CIDISI");				
     	
      	//Ascensores y escaleras del piso 4
      	mapa.agregarNodo(7, 4, 4, "Escalera");		    mapa.agregarNodo(14, 2, 4, "Ascensor");
      	mapa.agregarNodo(13, 0, 4, "Escalera");
      	
      	//Aca se crean los enlaces piso 4
      	mapa.conectar(3, 7, 4, 5, 7, 4);      	mapa.conectar(11, 6, 4, 11, 2, 4);
      	mapa.conectar(5, 7, 4, 7, 7, 4);      	mapa.conectar(11, 2, 4, 11, 1, 4);
      	mapa.conectar(7, 7, 4, 8, 7, 4);      	mapa.conectar(11, 1, 4, 13, 1, 4);
      	mapa.conectar(8, 7, 4, 8, 4, 4);     	mapa.conectar(13, 1, 4, 14, 1, 4);
      	mapa.conectar(8, 7, 4, 10, 7, 4);      	mapa.conectar(14, 1, 4, 14, 2, 4);
      	mapa.conectar(10, 7, 4, 11, 7, 4);      mapa.conectar(13, 1, 4, 13, 0, 4);
      	mapa.conectar(11, 7, 4, 11, 6, 4);      mapa.conectar(7, 4, 4, 8, 4, 4);
      	mapa.conectar(2, 7, 4, 3, 7, 4);		mapa.conectar(10, 6, 4, 11, 6, 4);
      	mapa.conectar(3, 9, 4, 3, 7, 4);		mapa.conectar(11, 6, 4, 12, 6, 4);
      	mapa.conectar(5, 8, 4, 5, 7, 4);		mapa.conectar(11, 7, 4, 12, 7, 4);
      	mapa.conectar(7, 8, 4, 7, 7, 4);		mapa.conectar(11, 2, 4, 12, 2, 4);
      	mapa.conectar(10, 8, 4, 10, 7, 4);
      	
    	//Enlaces que conectan los pisos entre si
      	mapa.conectar(16, 16, 1, 16, 16, 2);    mapa.conectar(13, 11, 1, 13, 11, 2);
      	mapa.conectar(13, 7, 1, 13, 7, 2);      mapa.conectar(13, 0, 1, 13, 0, 2);      	
      	mapa.conectar(22, 0, 1, 22, 0, 2);		mapa.conectar(14, 2, 1, 14, 2, 2);
      	
      	mapa.conectar(14, 2, 2, 14, 2, 3);		mapa.conectar(7, 4, 3, 7, 4, 4);
      	mapa.conectar(13, 0, 2, 13, 0, 3);		mapa.conectar(13, 0, 3, 13, 0, 4);
      	mapa.conectar(12, 6, 2, 12, 6, 3);		mapa.conectar(14, 2, 3, 14, 2, 4);

     }
}
