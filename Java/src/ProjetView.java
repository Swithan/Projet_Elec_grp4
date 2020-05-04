import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

public class ProjetView implements Observer{
	private ProjetModel model = new ProjetModel();
	private JLabel titre = new JLabel("PROJET D'ELECTRONIQUE");
	private JLabel labelChoixPort = new JLabel("Choisissez le port : ");
	private String[] ports = new String[] {"COM1", "COM2"};
	private JComboBox<String> choixPort = new JComboBox<>(ports);
	private JLabel labelAfficherSeuil = new JLabel("Seuil de distance maximal actuel : 100");	
	private JLabel labelEntrerSeuil = new JLabel("  Nouveau seuil de distance: ");
	private JTextField entrerSeuil = new JTextField(3);
	private JButton appliquerSeuil = new JButton("Appliquer");
	private JLabel alerte = new JLabel("Pas d'alertes");
	

	public ProjetView(ProjetModel model) {
		
		this.model = model;
		
		JFrame window = new JFrame();
		window.setTitle("Electronique Groupe 4");
		window.setSize(400, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.white);
		window.setLayout(null);
		Font titreFont = new Font("Comic Sans MS", Font.PLAIN, 15);
	
		titre.setBounds(90, 10, 300, 20);
		titre.setForeground(Color.black);
		titre.setFont(titreFont);
		window.add(titre);
		
		
		
		labelChoixPort.setBounds(90, 70, 150, 20);
		window.add(labelChoixPort);
		choixPort.setBounds(210, 70, 70, 20);
		window.add(choixPort);
		
		
		labelEntrerSeuil.setBounds(80, 137, 200, 20);
		window.add(labelEntrerSeuil);
		entrerSeuil.setText("100");
		entrerSeuil.setBounds(250, 138, 50, 20);
		window.add(entrerSeuil);	
		appliquerSeuil.setBounds(150, 170, 100, 20);
		window.add(appliquerSeuil);
		
		labelAfficherSeuil.setBounds(85, 200, 250, 20);
		window.add(labelAfficherSeuil);
		
		alerte.setForeground(Color.green);
		alerte.setBounds(140, 260, 100, 20);
		window.add(alerte);

		window.setVisible(true);
	}
	
	public String getSeuil() {
		return(entrerSeuil.getText());
	}
	
	public void setDistance(String string) {
		labelAfficherSeuil.setText("Seuil de distance maximal actuel : " + string);
	}
	
	void calculerDistance(ActionListener listenForDistanceButton){
		appliquerSeuil.addActionListener(listenForDistanceButton);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.setDistance(this.model.getDist());
		
	}
}