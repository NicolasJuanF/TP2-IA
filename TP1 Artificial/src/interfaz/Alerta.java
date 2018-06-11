package interfaz;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Alerta extends JFrame {
	public Alerta() {
		getContentPane().setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnAceptar.setBounds(107, 51, 89, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblLaUbicacinDe = new JLabel("\u00A1La ubicaci\u00F3n de inicio y fin deben ser distintas!");
		lblLaUbicacinDe.setHorizontalAlignment(SwingConstants.CENTER);
		lblLaUbicacinDe.setFont(new Font("Arial", Font.PLAIN, 12));
		lblLaUbicacinDe.setBounds(10, 11, 287, 29);
		getContentPane().add(lblLaUbicacinDe);
		
		this.setBounds(0,0,330,130);
  		this.setTitle("Error en la selección.");                
  		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

	private static final long serialVersionUID = 1L;
}
