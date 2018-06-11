package interfaz;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dominio.Coordenadas;
import dominio.Mapa;
import dominio.Nodo;
import frsf.cidisi.exercise.tp1.search.BuscadorAgente;
import frsf.cidisi.exercise.tp1.search.FacultadAmbiente;
import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;


public class PanelMapa extends JFrame implements Runnable{
		Container contenedor = getContentPane();
		private static final long serialVersionUID = 1L; 
		Nodo nodoInicio, nodoFin;
	    public URL stringMapa;
	    Mapa mapa = new Mapa();
	    Coordenadas coordenadas = new Coordenadas();    	
	    int piso;
	    public java.awt.Image imagen;
	    public java.awt.Image iconoRobot;
	    public ArrayList<String> arreglo = new ArrayList<String>();
	    public HashSet<Nodo> listaBloqueados = new HashSet<Nodo>();
	    public JLabel acciones = new JLabel("",SwingConstants.CENTER);
	    Thread hilo;

	  	public PanelMapa(String inicio, String fin, HashSet<Nodo> listaBloqueados, int i) throws InterruptedException {
	  		setResizable(false);
	  		mapa = coordenadas.getMapa();
	  		this.nodoInicio = mapa.buscarNodo(inicio);
	  		this.nodoFin = mapa.buscarNodo(fin);
	  		this.piso = nodoInicio.getPiso();
	  		this.listaBloqueados = listaBloqueados;
	  		hilo = new Thread(this);
	  		inicializar(i);
	  		hilo.start();
		}

		public JPanel panel = new JPanel(){
			private static final long serialVersionUID = 1L;
			public void paintComponent(Graphics g){
		  		g.drawImage(imagen, 0, 0, getWidth(),getHeight(),this);
		  	}
	  	};
	  	public JLabel robot = new JLabel(""){
			private static final long serialVersionUID = 1L;	
			public void paintComponent(Graphics g){
		  		g.drawImage(iconoRobot, 0, 0, getWidth(),getHeight(),this);
		  	}
	  	};
	  	// Aca se carga el mapa.
		public void inicializar(int i) throws InterruptedException{
			iconoRobot = new ImageIcon(this.getClass().getResource("/img/marvin.png")).getImage();
			acciones.setBounds(930,10,180,60);
			contenedor.add(acciones);
			contenedor.add(robot);
			this.setBounds(0,0,1150,700);
	  		this.setTitle("Plano Facultad");                
	  		this.setLocationRelativeTo(null);
	  		seleccionarImagen(piso);
		  	contenedor.add(panel);
		  	this.setVisible(true);
		  	BuscadorAgente agent = new BuscadorAgente(nodoInicio.getDescripcion(), nodoFin.getDescripcion(),i);
	        FacultadAmbiente environment = new FacultadAmbiente(nodoInicio.getDescripcion(), listaBloqueados);
	        SearchBasedAgentSimulator simulator = new SearchBasedAgentSimulator(environment, agent);		      
	        arreglo = simulator.start();

		}

		public void seleccionarImagen(int piso){
			if(piso==1) stringMapa = this.getClass().getResource("/img/piso1.png");
	  		else if(piso==2) stringMapa = this.getClass().getResource("/img/piso2.png");
	  		else if(piso==3) stringMapa = this.getClass().getResource("/img/piso3.png");
	  		else stringMapa = this.getClass().getResource("/img/piso4.png");
			imagen = new ImageIcon(stringMapa).getImage();
		}

		@SuppressWarnings("deprecation")
		@Override
		public void run() {
			try{
				while(true){
					String accion;
			    	// Seteo la posicion inicial en el mapa.
			    	
			    	int posX = (int)(39+39.5*nodoInicio.getX());
			    	int posY = (int)(585-36.5*nodoInicio.getY());
			    	int movimientos;
			    	acciones.setBorder(BorderFactory.createLineBorder(Color.black, 2));
			    	acciones.setOpaque(true);
			    	acciones.setVisible(true);
			        robot.setBounds(posX, posY, 38, 36);
			        robot.setOpaque(true);
			        robot.setVisible(true);
			        for(int i = 1; i<arreglo.size()-1;i=i+2){
			        	// Las coordenada 0 en X esta a las 39 unidades. La coordenada en Y empieza de arriba, por eso el calculo es diferente.
			        	accion = arreglo.get(i);
			        	movimientos = Integer.parseInt(arreglo.get(i+1))/10-Integer.parseInt(arreglo.get(i-1))/10;
			        	acciones.setText("<html>Accion: " + accion + ".<br>" + "Energía: " + arreglo.get(i-1) + ".</html>");
			        	try {
			        		Thread.sleep(2000);
							repaint();
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
			        	if(accion == "AvanzarSur"){
			        		posY = (int)(posY+36.5*movimientos);
			        		robot.setBounds(posX, posY, 38, 36);
			        	}
			        	else if(accion == "AvanzarNorte"){
			        		posY = (int)(posY-36.5*movimientos);
			        		robot.setBounds(posX, posY, 38, 36);
			        	}
			        	else if(accion == "AvanzarEste"){
			        		posX = (int)(posX+39.5*movimientos);
			        		robot.setBounds(posX, posY, 38, 36);
			        	}
			        	else if(accion == "AvanzarOeste"){
			        		posX = (int)(posX-39.5*movimientos);
			        		robot.setBounds(posX, posY, 38, 36);
			        	}
			        	else if(accion == "BajarPiso"){
			        		piso--;
			        		seleccionarImagen(piso);
			        	}
			        	else if(accion == "SubirPiso"){
			        		piso++;
			        		seleccionarImagen(piso);
			        		
			        	}
					}
			        hilo.stop();;
				}
			}
			catch (Exception e){
				
			}
			
		}
}