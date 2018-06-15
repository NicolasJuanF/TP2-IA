package frsf.cidici.faia.simulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import utils.ArchivoOutput;

public class Main {
	Agente agent;
    Ambiente environment;
    KnowledgeBasedAgentSimulator simulator;

    String appName = "Chat con el Pibe";
    Main  mainGUI;
    JFrame newFrame = new JFrame(appName);
    JButton sendMessage;
    JTextField messageBox;
    JTextArea chatBox;
    JTextField usernameChooser;
    JFrame preFrame;

public void display() {
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel southPanel = new JPanel();
        southPanel.setBackground(Color.BLUE);
        southPanel.setLayout(new GridBagLayout());

        messageBox = new JTextField(30);
        messageBox.requestFocusInWindow();

        sendMessage = new JButton("Send Message");
        sendMessage.addActionListener(new sendMessageButtonListener());

        chatBox = new JTextArea();
        chatBox.setEditable(false);
        chatBox.setFont(new Font("Serif", Font.PLAIN, 15));
        chatBox.setLineWrap(true);

        mainPanel.add(new JScrollPane(chatBox), BorderLayout.CENTER);

        GridBagConstraints left = new GridBagConstraints();
        left.anchor = GridBagConstraints.LINE_START;
        left.fill = GridBagConstraints.HORIZONTAL;
        left.weightx = 512.0D;
        left.weighty = 1.0D;

        GridBagConstraints right = new GridBagConstraints();
        right.insets = new Insets(0, 10, 0, 0);
        right.anchor = GridBagConstraints.LINE_END;
        right.fill = GridBagConstraints.NONE;
        right.weightx = 1.0D;
        right.weighty = 1.0D;

        southPanel.add(messageBox, left);
        southPanel.add(sendMessage, right);

        mainPanel.add(BorderLayout.SOUTH, southPanel);

        newFrame.add(mainPanel);
        newFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newFrame.setSize(470, 300);
        newFrame.setVisible(true);
        agent = new Agente();
	    environment = new Ambiente(""); //ambiente inicial no tiene nada
	    simulator = new KnowledgeBasedAgentSimulator(environment, agent);
		String oracionAux = environment.getEnvironmentState().getOracion();
		/*String rta = simulator.start().get(0);
		
		System.out.println("Entrada: " + oracionAux);
		ArchivoOutput.getInstance().agregarLinea("Entrada: " + oracionAux);
		
		System.out.println("Salida: " + rta);
		ArchivoOutput.getInstance().agregarLinea("Salida: " + rta);
		
		ArchivoOutput.getInstance().grabar();*/
    }

    class sendMessageButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            if (messageBox.getText().length() < 1) {
                // do nothing
            } else if (messageBox.getText().equals(".clear")) {
                chatBox.setText("Cleared all messages\n");
                messageBox.setText("");
            } else {
                chatBox.append("<SmatToy>:  " + messageBox.getText()
                        + "\n");
                String resp = buscarRespuesta();
                chatBox.append("<AGENTE>:  " + resp
                        + "\n");
                messageBox.setText("");
                            }
            messageBox.requestFocusInWindow();
        }
    }

    String  username;

public String buscarRespuesta(){
	String rta ="";
	if(!messageBox.getText().isEmpty()){
		Calendar calendario = Calendar.getInstance();
		int hora =calendario.get(Calendar.HOUR_OF_DAY);
		int minutos = calendario.get(Calendar.MINUTE);
		int segundos = calendario.get(Calendar.SECOND);
		String time = hora+":"+minutos+":"+segundos;
		environment.getEnvironmentState().setOracion(messageBox.getText());
		
		rta = simulator.start().get(0);
		
		
		String oracionAux = environment.getEnvironmentState().getOracion();
		
		ArchivoOutput.getInstance().agregarLinea("Entrada: " + oracionAux);
		ArchivoOutput.getInstance().agregarLinea("Salida: " + rta);
		
		ArchivoOutput.getInstance().grabar();
		}
	return rta;
}
public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Main frame = new Main();
				frame.display();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
	}
}