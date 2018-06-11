package interfaz;

import javax.swing.JFrame;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JLabel;

import dominio.Coordenadas;
import dominio.Mapa;
import dominio.Nodo;

import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.JTabbedPane;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class PantallaPrincipal extends JFrame implements ChangeListener{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		Mapa mapa = new Mapa();
		Vector<Nodo> nodos;
		ArrayList<String> arreglo = new ArrayList<String>();
		HashSet<Nodo> listaBloqueados = new HashSet<Nodo>();
		JRadioButton radioBtnAscensor1 = new JRadioButton("Ascensor");
    	JRadioButton rdbtnEscaleraA1 = new JRadioButton("Escalera (13, 7)");
    	JRadioButton rdbtnEscaleraB1 = new JRadioButton("Escalera (13, 0)");
		JRadioButton rdbtnEscaleraC1 = new JRadioButton("Escalera (12,6)");
		JRadioButton rdbtnEscaleraD1 = new JRadioButton("Escalera (13, 11)");
		JRadioButton rdbtnEscaleraE1 = new JRadioButton("Escalera (16,16)");		
		JRadioButton rdbtnEscaleraF1 = new JRadioButton("Escalera (22,0)");
		JRadioButton radioBtnAscensor2 = new JRadioButton("Ascensor");
		JRadioButton rdbtnEscaleraA2 = new JRadioButton("Escalera (13,7)");
		JRadioButton rdbtnEscaleraB2 = new JRadioButton("Escalera (13, 0)");
		JRadioButton rdbtnEscaleraC2 = new JRadioButton("Escalera (12,6)");
		JRadioButton rdbtnEscaleraD2 = new JRadioButton("Escalera (13, 11)");
		JRadioButton rdbtnEscaleraE2 = new JRadioButton("Escalera (16,16)");
		JRadioButton rdbtnEscaleraF2 = new JRadioButton("Escalera (22,0)");
		JRadioButton radioBtnAscensor3 = new JRadioButton("Ascensor");		
		JRadioButton rdbtnEscaleraB3 = new JRadioButton("Escalera (13, 0)");
		JRadioButton rdbtnEscaleraC3 = new JRadioButton("Escalera (12,6)");
		JRadioButton rdbtnEscaleraG3 = new JRadioButton("Escalera (7, 4)");
		JRadioButton radioBtnAscensor4 = new JRadioButton("Ascensor");		
		JRadioButton rdbtnEscaleraB4 = new JRadioButton("Escalera (13, 0)");
		JRadioButton rdbtnEscaleraG4 = new JRadioButton("Escalera (7, 4)");
		
	public PantallaPrincipal() {
		getContentPane().setLayout(null);
		
		Coordenadas coordenadas = new Coordenadas();
    	mapa = new Mapa();
    	mapa = coordenadas.getMapa();
    	nodos = mapa.listaNodos();	

    	// Acá solo ordeno las habitaciones alfabéticamente para que sea más cómodo.
    	ArrayList<String> ubicaciones = new ArrayList<String>();
    	for(Nodo n: nodos){
			if(n.getDescripcion() != "Pasillo" && n.getDescripcion() != "Escalera" && n.getDescripcion() != "Ascensor")
				ubicaciones.add(n.getDescripcion());
    	}
    	Collections.sort(ubicaciones);
    	
    	// Declaro y lleno los comboBox de habitaciones.
		final JComboBox<String> comboInicio = new JComboBox<String>();
		final JComboBox<String> comboFin = new JComboBox<String>();
		comboInicio.setBounds(273, 23, 204, 20);
		comboFin.setBounds(273, 48, 204, 20);
		for(String s: ubicaciones) {
			comboInicio.addItem(s);
			comboFin.addItem(s);
		}
		getContentPane().add(comboInicio);
		getContentPane().add(comboFin);
		
		
		JLabel lblInicial = new JLabel("Elija la posici\u00F3n de salida del agente:");
		lblInicial.setBounds(56, 26, 179, 14);
		getContentPane().add(lblInicial);
		
		JLabel lblFinal = new JLabel("Elija la posici\u00F3n de destino:");
		lblFinal.setBounds(56, 51, 179, 14);
		getContentPane().add(lblFinal);
		
		final JComboBox<String> comboMetodo = new JComboBox<String>();
		comboMetodo.setBounds(273, 73, 204, 20);
		comboMetodo.addItem("Profundidad");
		comboMetodo.addItem("Amplitud");
		comboMetodo.addItem("Avara");
		getContentPane().add(comboMetodo);
		
		JLabel lblSeleccioneLaForma = new JLabel("Seleccione la forma de b\u00FAsqueda:");
		lblSeleccioneLaForma.setBounds(56, 76, 179, 14);
		getContentPane().add(lblSeleccioneLaForma);
		
		JButton btnComenzar = new JButton("Comenzar B\u00FAsqueda");
		btnComenzar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					if(comboInicio.getSelectedItem().toString() != comboFin.getSelectedItem().toString())
						new PanelMapa(comboInicio.getSelectedItem().toString(), comboFin.getSelectedItem().toString(), listaBloqueados, comboMetodo.getSelectedIndex());
					else {
						new Alerta();
					}
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		});
		
		btnComenzar.setBounds(195, 269, 180, 23);
		getContentPane().add(btnComenzar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(Color.LIGHT_GRAY);
		tabbedPane.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seleccione los nodos a bloquear", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tabbedPane.setBounds(10, 118, 532, 140);
		getContentPane().add(tabbedPane);
		
		// Acá se anaden los radioButtons del piso 1.
		JPanel panelPiso1 = new JPanel();
		tabbedPane.addTab("Piso 1", null, panelPiso1, null);
		panelPiso1.setLayout(null);				
		rdbtnEscaleraA1.setBounds(16, 7, 163, 23);
		rdbtnEscaleraA1.addChangeListener(this);
		panelPiso1.add(rdbtnEscaleraA1);	
		rdbtnEscaleraC1.setBounds(16, 35, 163, 23);
		rdbtnEscaleraC1.addChangeListener(this); 
		panelPiso1.add(rdbtnEscaleraC1);		
		radioBtnAscensor1.setBounds(181, 61, 163, 23);
		radioBtnAscensor1.addChangeListener(this);
		panelPiso1.add(radioBtnAscensor1);		
		rdbtnEscaleraF1.setBounds(181, 35, 163, 23);
		rdbtnEscaleraF1.addChangeListener(this);
		panelPiso1.add(rdbtnEscaleraF1);		
		rdbtnEscaleraB1.setBounds(181, 9, 163, 23);
		rdbtnEscaleraB1.addChangeListener(this);
		panelPiso1.add(rdbtnEscaleraB1);		
		rdbtnEscaleraD1.setBounds(346, 7, 163, 23);
		rdbtnEscaleraD1.addChangeListener(this);
		panelPiso1.add(rdbtnEscaleraD1);		
		rdbtnEscaleraE1.setBounds(346, 35, 163, 23);
		rdbtnEscaleraE1.addChangeListener(this);
		panelPiso1.add(rdbtnEscaleraE1);
		
		// Acá se anaden los radioButtons del piso 2.
		JPanel panelPiso2 = new JPanel();
		tabbedPane.addTab("Piso 2", null, panelPiso2, null);
		panelPiso2.setLayout(null);				
		radioBtnAscensor2.setBounds(171, 61, 163, 23);
		radioBtnAscensor2.addChangeListener(this);
		panelPiso2.add(radioBtnAscensor2);		
		rdbtnEscaleraA2.setBounds(6, 7, 163, 23);
		rdbtnEscaleraA2.addChangeListener(this);
		panelPiso2.add(rdbtnEscaleraA2);		
		rdbtnEscaleraB2.setBounds(171, 9, 163, 23);
		rdbtnEscaleraB2.addChangeListener(this);
		panelPiso2.add(rdbtnEscaleraB2);		
		rdbtnEscaleraC2.setBounds(6, 35, 163, 23);
		rdbtnEscaleraC2.addChangeListener(this);
		panelPiso2.add(rdbtnEscaleraC2);		
		rdbtnEscaleraD2.setBounds(336, 7, 163, 23);
		rdbtnEscaleraD2.addChangeListener(this);
		panelPiso2.add(rdbtnEscaleraD2);		
		rdbtnEscaleraE2.setBounds(336, 35, 163, 23);
		rdbtnEscaleraE2.addChangeListener(this);
		panelPiso2.add(rdbtnEscaleraE2);		
		rdbtnEscaleraF2.setBounds(171, 35, 163, 23);
		rdbtnEscaleraF2.addChangeListener(this);
		panelPiso2.add(rdbtnEscaleraF2);
		
		// Acá se anaden los radioButtons del piso 3.
		JPanel panelPiso3 = new JPanel();
		tabbedPane.addTab("Piso 3", null, panelPiso3, null);
		panelPiso3.setLayout(null);
		radioBtnAscensor3.setBounds(283, 47, 163, 23);
		radioBtnAscensor3.addChangeListener(this);
		panelPiso3.add(radioBtnAscensor3);
		rdbtnEscaleraB3.setBounds(283, 19, 163, 23);
		rdbtnEscaleraB3.addChangeListener(this);
		panelPiso3.add(rdbtnEscaleraB3);
		rdbtnEscaleraG3.setBounds(37, 19, 163, 23);
		rdbtnEscaleraG3.addChangeListener(this);
		panelPiso3.add(rdbtnEscaleraG3);
		rdbtnEscaleraC3.setBounds(37, 47, 109, 23);
		rdbtnEscaleraC3.addChangeListener(this);
		panelPiso3.add(rdbtnEscaleraC3);
		
		// Acá se anaden los radioButtons del piso 4.
		JPanel panelPiso4 = new JPanel();
		tabbedPane.addTab("Piso 4", null, panelPiso4, null);
		panelPiso4.setLayout(null);		
		rdbtnEscaleraG4.setBounds(205, 7, 163, 23);
		rdbtnEscaleraG4.addChangeListener(this);
		panelPiso4.add(rdbtnEscaleraG4);		
		rdbtnEscaleraB4.setBounds(205, 33, 163, 23);
		rdbtnEscaleraB4.addChangeListener(this);
		panelPiso4.add(rdbtnEscaleraB4);
		radioBtnAscensor4.setBounds(205, 57, 163, 23);
		radioBtnAscensor4.addChangeListener(this);
		panelPiso4.add(radioBtnAscensor4);
		
		this.setBounds(0,0,568,333);
  		this.setTitle("Menú Búsqueda");                
  		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	@Override
	public void stateChanged(ChangeEvent e) {
		if(radioBtnAscensor1.isSelected()) listaBloqueados.add(mapa.buscarNodo(14, 2, 1));
		if(radioBtnAscensor2.isSelected()) listaBloqueados.add(mapa.buscarNodo(14, 2, 2));
		if(radioBtnAscensor3.isSelected()) listaBloqueados.add(mapa.buscarNodo(14, 2, 3));
		if(radioBtnAscensor4.isSelected()) listaBloqueados.add(mapa.buscarNodo(14, 2, 4));
		if(rdbtnEscaleraA1.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 7, 1));
		if(rdbtnEscaleraA2.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 7, 2));
		if(rdbtnEscaleraB1.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 0, 1));
		if(rdbtnEscaleraB2.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 0, 2));
		if(rdbtnEscaleraB3.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 0, 3));
		if(rdbtnEscaleraB4.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 0, 4));
		if(rdbtnEscaleraC1.isSelected()) listaBloqueados.add(mapa.buscarNodo(12, 6, 1));
		if(rdbtnEscaleraC2.isSelected()) listaBloqueados.add(mapa.buscarNodo(12, 6, 2));
		if(rdbtnEscaleraC3.isSelected()) listaBloqueados.add(mapa.buscarNodo(12, 6, 3));
		if(rdbtnEscaleraD1.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 11, 1));
		if(rdbtnEscaleraD2.isSelected()) listaBloqueados.add(mapa.buscarNodo(13, 11, 2));
		if(rdbtnEscaleraE1.isSelected()) listaBloqueados.add(mapa.buscarNodo(16, 16, 1));
		if(rdbtnEscaleraE2.isSelected()) listaBloqueados.add(mapa.buscarNodo(16, 16, 2));
		if(rdbtnEscaleraF1.isSelected()) listaBloqueados.add(mapa.buscarNodo(22, 0, 1));
		if(rdbtnEscaleraF2.isSelected()) listaBloqueados.add(mapa.buscarNodo(22, 0, 2));
		if(rdbtnEscaleraG3.isSelected()) listaBloqueados.add(mapa.buscarNodo(7, 4, 3));
		if(rdbtnEscaleraG4.isSelected()) listaBloqueados.add(mapa.buscarNodo(7, 4, 4));
	}
	public static void main(String[] args) {
		new PantallaPrincipal();
	}
	
}