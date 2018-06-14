package frsf.cidici.faia.simulator;



import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;

import utils.ArchivoOutput;


import frsf.cidisi.faia.simulator.SearchBasedAgentSimulator;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;
import java.util.HashSet;
import java.awt.Font;

public class Main extends JFrame{
	
	Agente agent;
    Ambiente environment;
    KnowledgeBasedAgentSimulator simulator;

    
	private static final long serialVersionUID = 1L;
	
	private JTextField mensaje = new JTextField();
	private JTextArea respuesta = new JTextArea();
	//private JScrollPane sp = new JScrollPane(respuesta);
	JButton enviar = new JButton("Enviar");

	public Main() {
		setResizable(false);
		
		agent = new Agente();
	    environment = new Ambiente("como te llamas?");
	    simulator = new KnowledgeBasedAgentSimulator(environment, agent);
		String oracionAux = environment.getEnvironmentState().getOracion();
		String rta = simulator.start().get(0);
		
		System.out.println("Entrada: " + oracionAux);
		ArchivoOutput.getInstance().agregarLinea("Entrada: " + oracionAux);
		
		System.out.println("Salida: " + rta);
		ArchivoOutput.getInstance().agregarLinea("Salida: " + rta);
		
		ArchivoOutput.getInstance().grabar();
	}
	
	public void buscarRespuesta(){
		if(!mensaje.getText().isEmpty()){
			Calendar calendario = Calendar.getInstance();
			int hora =calendario.get(Calendar.HOUR_OF_DAY);
			int minutos = calendario.get(Calendar.MINUTE);
			int segundos = calendario.get(Calendar.SECOND);
			String time = hora+":"+minutos+":"+segundos;
			environment.getEnvironmentState().setOracion(mensaje.getText());
			
			String rta = simulator.start().get(0);
			String oracionAux = environment.getEnvironmentState().getOracion();
			

	
			}
		}
	
	
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
	}
}
