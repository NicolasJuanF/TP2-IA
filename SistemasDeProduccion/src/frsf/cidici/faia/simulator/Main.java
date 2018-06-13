package frsf.cidici.faia.simulator;



import javax.swing.JFrame;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JButton;


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
	
	ChatbotAgent agent;
    Ambiente environment;
    KnowledgeBasedAgentSimulator simulator;

    
	private static final long serialVersionUID = 1L;
	
	private JTextField mensaje = new JTextField();
	private JTextArea respuesta = new JTextArea();
	//private JScrollPane sp = new JScrollPane(respuesta);
	JButton enviar = new JButton("Enviar");

	public Main() {
		setResizable(false);
		
		agent = new ChatbotAgent();
	    environment = new Ambiente("COMO ESTAS");
	    simulator = new KnowledgeBasedAgentSimulator(environment, agent);
		String oracionAux = environment.getEnvironmentState().getOracion();
		String rta = simulator.start().get(0);
		
		System.out.println("Entrada: " + oracionAux);
		System.out.println("Salida: " + rta);
		
		/*getContentPane().setLayout(null);
		//respuesta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		respuesta.setRows(1);
		respuesta.setEditable(false);
		//respuesta.setBounds(25, 25, 650, 300);
		respuesta.setColumns(10);
		//respuesta.setBackground(Color.WHITE);
		
		sp.setBounds(25, 25, 679, 384);
		getContentPane().add(sp);
		sp.setViewportView(respuesta);
		
		//mensaje.setBounds(25, 420, 569, 41);
		getContentPane().add(mensaje);
		mensaje.setColumns(10);
		
		enviar.setBounds(604, 420, 100, 41);
		getContentPane().add(enviar);
		
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				buscarRespuesta();
			}
		});*/
		
		/*mensaje.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				mensaje.setText(mensaje.getText().toUpperCase());
			}
			public void keyPressed(KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					buscarRespuesta();
				}
			}
			
		});
		
		 addWindowListener(new WindowAdapter(){
	            @Override
	            public void windowClosing(WindowEvent e){
	                System.out.println("Fin");
	                System.exit(EXIT_ON_CLOSE);
	            }
		 });*/
			this.setBounds(300,100,720,500);
			
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
			
			/*respuesta.setText(respuesta.getText()+time+"    Usted dice:\n      " + oracionAux);
			respuesta.setText(respuesta.getText()+"\n");
			respuesta.setText(respuesta.getText()+time+"    El Agente dice:\n      " + rta);
			respuesta.setText(respuesta.getText()+"\n");
			mensaje.setText("");*/
			
	
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
